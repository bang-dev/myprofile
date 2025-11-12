package com.profile.api.service;

import com.profile.api.entity.UserEntity;
import com.profile.api.io.ProfileRequest;
import com.profile.api.io.ProfileResponse;
import com.profile.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;

    @Override
    public ProfileResponse createProfile(ProfileRequest request) {

        UserEntity newProfile = convertToUserEntity(request);

        newProfile =  userRepository.save(newProfile);

        return convertToProfileResponse(newProfile);
    }

    private ProfileResponse convertToProfileResponse(UserEntity newProfile) {
        return ProfileResponse.builder()
                .userId(newProfile.getUserId())
                .name(newProfile.getName())
                .email(newProfile.getEmail())
                .isAccountVerified(newProfile.getIsAccountVerified())
                .build();
    }

    private UserEntity convertToUserEntity(ProfileRequest request) {
        return UserEntity.builder()
                .name(request.getName())
                .userId(UUID.randomUUID().toString())
                .email(request.getEmail())
                .password(request.getPassword())
                .isAccountVerified(false)
                .resetOtpExpireAt(0L)
                .verifyOtp(null)
                .verifyOtpExpireAt(0L)
                .resetOtp(null)
                .build();

    }
}
