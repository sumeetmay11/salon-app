package com.mysalon.salonparent;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mysalon.salonparent.entity.UserProfileData;
import com.mysalon.salonparent.repository.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MongoDBTest {
    @Autowired
    UserProfileRepository userProfileRepository;
    @Autowired
    private UserProfileService userProfileService;

    @Test
    public void insertAndCheckUserProfile()
    {
         UserProfileData userProfileData=userProfileService.getUser("8802421341");
        System.out.println(userProfileData);
    }


}
