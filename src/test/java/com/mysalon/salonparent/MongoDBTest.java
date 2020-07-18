package com.mysalon.salonparent;

import com.mysalon.salonparent.entity.UserProfileData;
import com.mysalon.salonparent.repository.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MongoDBTest {
    @Autowired
    UserProfileRepository userProfileRepository;

    @Test
    public void insertAndCheckUserProfile()
    {
        UserProfileData profileData=userProfileRepository.findByUid("1");
        System.out.println(profileData);
    }
}
