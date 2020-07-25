package com.mysalon.salonparent;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysalon.salonparent.entity.UserProfileData;
import com.mysalon.salonparent.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    public String insertUser(UserProfileData userProfileData)
    {
        UserProfileData existing=getUserByMobile(userProfileData.getMobileNumber());
        if(existing!=null)
        {
            return "User already exist";
        }
        userProfileData.setUid(UUID.randomUUID().toString());
        userProfileRepository.insert(userProfileData);
        return "Success";
    }

    public UserProfileData getUser(String mobile) {
        return this.getUserByMobile(mobile);
    }

    private UserProfileData getUserByMobile(String mobileNumber) {
        return userProfileRepository.findByMobileNumber(mobileNumber);
    }
}
