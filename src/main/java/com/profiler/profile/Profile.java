package com.profiler.profile;

/**
 * Created by jpsierens on 8/29/18.
 */
public class Profile {
    private final String firstName;
    private final String lastName;
    private final String email;

    public Profile(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "Profile: "+getFirstName()+" "+getLastName()+", "+getEmail();
    }
}
