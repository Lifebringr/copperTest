package co.copper.test.services;

import co.copper.test.datamodel.RandomUser;
import co.copper.test.datamodel.RandomUserResponse;
import co.copper.test.storage.RandomUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static co.copper.test.services.RandomUserService.RANDOM_USERS_API;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RandomUserServiceTest {


    @Captor
    private ArgumentCaptor<List<RandomUser>> randomUsersCaptor;
    @Test
    void getAllRandomUsersWillRetrieveAllRandomUsersFromTheRepository() {
        RandomUserRepository mockRepository = mock(RandomUserRepository.class);
        RandomUser sampleUser = new RandomUser();
        Iterable<RandomUser> expectedUsers = Collections.singleton(sampleUser);

        when(mockRepository.findAll()).thenReturn(expectedUsers);

        RandomUserService randomUserService = new RandomUserService(mockRepository, null);
        assertEquals(expectedUsers, randomUserService.getAllRandomUsers());
    }

    @Test
    void download20() {
        RandomUserRepository mockRepository = mock(RandomUserRepository.class);
        RestTemplate mockRestTemplate = mock(RestTemplate.class);
        RandomUser sampleUser = new RandomUser();
        List<RandomUser> expectedUsers = List.of(sampleUser);
        RandomUserResponse randomUserResponse = new RandomUserResponse();
        randomUserResponse.results = expectedUsers;

        when(mockRestTemplate.getForObject(RANDOM_USERS_API, RandomUserResponse.class)).thenReturn(randomUserResponse);

        RandomUserService randomUserService = new RandomUserService(mockRepository, mockRestTemplate);
        randomUserService.download20();
        verify(mockRepository).saveAll(randomUsersCaptor.capture());
        assertEquals(expectedUsers, randomUsersCaptor.getValue());
    }
}