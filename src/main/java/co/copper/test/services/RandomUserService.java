package co.copper.test.services;

import co.copper.test.datamodel.RandomUser;
import co.copper.test.datamodel.RandomUserResponse;
import co.copper.test.storage.RandomUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RandomUserService {

    private static final Logger log = LoggerFactory.getLogger(RandomUserService.class);
    public static final String RANDOM_USERS_API = "https://randomuser.me/api?results=20";
    private final RandomUserRepository randomUserRepository;
    private final RestTemplate restTemplate;

    public RandomUserService(RandomUserRepository randomUserRepository, RestTemplate restTemplate) {
        this.randomUserRepository = randomUserRepository;
        this.restTemplate = restTemplate;
    }

    public Iterable<RandomUser> getAllRandomUsers() {
        return randomUserRepository.findAll();
    }

    public Integer download20() {
        RandomUserResponse randomUserResponse = this.restTemplate.getForObject(RANDOM_USERS_API, RandomUserResponse.class);
        randomUserRepository.saveAll(randomUserResponse.results);
        return randomUserResponse.results.size();
    }
}
