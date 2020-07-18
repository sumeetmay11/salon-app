package com.mysalon.salonparent;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysalon.salonparent.entity.UserProfileData;
import com.mysalon.salonparent.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    public void insertUser(JsonObject jsonObject)
    {
        UserProfileData userProfileData=new Gson().fromJson(jsonObject,UserProfileData.class);
        userProfileRepository.insert(userProfileData);

    }

    public UserProfileData getUser(String uid) {
        return userProfileRepository.findByUid(uid);
    }
}
