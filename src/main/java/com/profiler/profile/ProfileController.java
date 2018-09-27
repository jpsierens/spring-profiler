package com.profiler.profile;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by jpsierens on 8/29/18.
 */
@RestController
public class ProfileController {
    HashMap<String, Profile> profileDB = new HashMap<>();

    @PostMapping(value="/profile")
    public void createProfile(
            @RequestParam(value = "firstName", defaultValue = "Joe") String firstName,
            @RequestParam(value = "lastName", defaultValue = "Doe") String lastName,
            @RequestParam(value = "email") String email
    ) {
        Profile profile = new Profile(firstName, lastName, email);
        // 'save' to DB.
        profileDB.put(email, profile);
        System.out.println("Saving: "+profile);
    }

    @GetMapping(value="/profile")
    public Profile getProfile(@RequestParam(value = "email") String email) throws Exception {
        System.out.println("Retrieving: "+profileDB.get(email));
        Profile profile = profileDB.get(email);
        if (profile == null) {
            throw new Exception("email doesnt exist");
        } else {
            return profile;
        }
    }


    @PutMapping(value="/profile")
    public void updateProfile(
            @RequestParam(value = "firstName", defaultValue = "Joe") String firstName,
            @RequestParam(value = "lastName", defaultValue = "Doe") String lastName,
            @RequestParam(value = "email") String email
    ) {
        System.out.println("Updating: "+profileDB.get(email));
        profileDB.remove(email);
        profileDB.put(email, new Profile(firstName, lastName, email));
    }

    @DeleteMapping(value="/profile")
    public void deleteprofile(@RequestParam(value = "email") String email) throws Exception {
        Profile profile = profileDB.get(email);
        if (profile == null) {
            throw new Exception("email doesnt exist");
        } else {
            profileDB.remove(email);
        }
    }
}
