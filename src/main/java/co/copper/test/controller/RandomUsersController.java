package co.copper.test.controller;

import co.copper.test.datamodel.RandomUser;
import co.copper.test.services.RandomUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/test", produces = "application/json")
@Controller
public class RandomUsersController {
    private final RandomUserService randomUserService;

    public RandomUsersController(RandomUserService randomUserService) {
        this.randomUserService = randomUserService;
    }

    @GetMapping("")
    @ResponseBody
    public Iterable<RandomUser> getAllRandomUsers() {
        return randomUserService.getAllRandomUsers();

    }

    @PostMapping("download20")
    @ResponseBody
    public Integer download20() {
        return randomUserService.download20();

    }

}
