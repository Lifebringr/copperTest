package co.copper.test.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name="randomuser")
public class RandomUser {
    @Id
    public String uuid;

    @Column(name = "firstname")
    public String firstName;
    @Column(name = "lastname")
    public String lastName;
    public String email;
    public String password;

    @JsonProperty("name")
    private void extractFromName(Map<String, String> name) {
        firstName = name.get("first");
        lastName = name.get("last");
    }

    @JsonProperty("login")
    private void extractFromLogin(Map<String, String> login) {
        password = login.get("password");
        uuid = login.get("uuid");
    }
}

