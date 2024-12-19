package com.cts.dto;
 
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserValidation {
 
//    @NotNull(message = "User ID cannot be null")
//    private Long id;
// 
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String username;
 
    @NotBlank(message = "Password is required")
    @Size(min = 4, message = "Password must be at least 4 characters")
    private String password;
 
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
 
    @NotNull(message = "Date of Birth is required")
    private String dob;
 
    @NotBlank(message = "Gender is required")
    private String gender;
    
    private String number;
    private String roles;
}
