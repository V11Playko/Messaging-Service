package com.pragma.powerup.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SendNotificationRequestDto {

    @Pattern(regexp = "^\\+?57\\s(3[0-2]|7[0-1])\\d{8}$", message = "Pattern not allowed")
    @Size(min = 7,
            max = 15,
            message = "Phone number must be between 7 and 15 characters, example +57 313 ....")
    @NotBlank(message = "Field 'phone' it's required")
    private String phone;
    @NotBlank(message = "Field 'message' it's required")
    @Size(min = 3, max = 255)
    private String message;
}
