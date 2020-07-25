package com.mysalon.salonparent.repository;

import com.mysalon.salonparent.entity.UserProfileData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfileData, String> {
	UserProfileData findByFirstName(String name);
	UserProfileData findByUid(String uid);
	UserProfileData findByMobileNumber(String mobile);
}
