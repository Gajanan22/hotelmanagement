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
public class BookingValidation {
 
    @NotNull(message = "Booking ID cannot be null")
    private Long id;
 
    @NotNull(message = "Room number is required")
    @Min(value = 1, message = "Room number must be at least 1")
    private Long room;
 
    @NotNull(message = "Number of adults is required")
    @Min(value = 1, message = "At least one adult is required")
    private Long adult;
 
    @Min(value = 0, message = "Number of children cannot be negative")
    private Long child;
 
    @NotBlank(message = "Arrival date is required")
    private String arrival;
 
    @NotBlank(message = "Departure date is required")
    private String departure;
 
    @Positive(message = "Total amount must be positive")
    private Long totalamount;
 
    @Min(value = 0, message = "Savings cannot be negative")
    private Long savings;
}
