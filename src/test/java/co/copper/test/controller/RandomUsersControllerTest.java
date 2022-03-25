package co.copper.test.controller;

import co.copper.test.datamodel.RandomUser;
import co.copper.test.services.RandomUserService;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RandomUsersControllerTest {

    @Test
    void getAllRandomUsersShouldRetrieveAllUsersFromTheService() {
        RandomUserService mockRandomUserService = mock(RandomUserService.class);
        RandomUsersController unit = new RandomUsersController(mockRandomUserService);
        RandomUser sampleUser = new RandomUser();
        Iterable<RandomUser> expectedUsers = Collections.singleton(sampleUser);

        when(mockRandomUserService.getAllRandomUsers()).thenReturn(expectedUsers);


        assertEquals(expectedUsers, unit.getAllRandomUsers());
    }

    @Test
    void download20ShouldReturnTheNumberOfDownloadedUsersFromTheService() {

        RandomUserService mockRandomUserService = mock(RandomUserService.class);
        RandomUsersController unit = new RandomUsersController(mockRandomUserService);
        Integer expectedResult = 77;

        when(mockRandomUserService.download20()).thenReturn(expectedResult);


        assertEquals(expectedResult, unit.download20());
    }
}