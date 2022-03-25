package co.copper.test.services;

import co.copper.test.datamodel.RandomUser;
import co.copper.test.datamodel.RandomUserResponse;
import co.copper.test.storage.RandomUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RandomUserServiceTest {

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
//TODO: parked for now
    }
}