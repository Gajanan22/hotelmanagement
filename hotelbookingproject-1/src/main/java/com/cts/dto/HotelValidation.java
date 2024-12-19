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
public class HotelValidation {
 
//    @NotNull(message = "Hotel ID cannot be null")
//    private Long id;
// 
    @NotBlank(message = "Hotel name is required")
    private String name;
 
    @NotBlank(message = "Place is required")
    private String place;
 
    @Positive(message = "Price must be positive")
    private double price;
 
    @Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 5, message = "Rating must not exceed 5")
    private double rating;
    
    @NotBlank(message = "Place is required")
    private String ratingtext;
}