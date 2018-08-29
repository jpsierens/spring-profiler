package com.profiler.profile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jpsierens on 8/29/18.
 */
@RestController
public class ProfileController {

    @RequestMapping("/profile")
    public Profile profile(
            @RequestParam(value = "firstName", defaultValue = "Joe") String firstName,
            @RequestParam(value = "lastName", defaultValue = "Doe") String lastName,
            @RequestParam(value = "email") String email
    ) {
        return new Profile(firstName, lastName, email);
    }
}
