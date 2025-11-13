package com.profile.api.controller;

import com.profile.api.io.ProfileRequest;
import com.profile.api.io.ProfileResponse;
import com.profile.api.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse registerUser(@Valid   @RequestBody ProfileRequest request) {

        ProfileResponse response = profileService.createProfile(request);

        return response;
    }
}
