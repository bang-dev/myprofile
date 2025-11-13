package com.profile.api.io;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Email(message = "Email should be valid")
    @NotNull(message = "Email cannot be null")
    private String email;
    @Min(value = 6, message = "Password must be at least 6 characters long")
    @Max(value = 10,message = "Password must be at most 10 characters long")
    private String password;
}
