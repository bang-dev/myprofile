package com.profile.api.service;


import com.profile.api.io.ProfileRequest;
import com.profile.api.io.ProfileResponse;
import org.springframework.stereotype.Service;


public interface ProfileService {

    ProfileResponse createProfile(ProfileRequest request);
}
