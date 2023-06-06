package com.pragma.powerup.adapters.driving.http.controller;

import com.pragma.powerup.adapters.driving.http.dto.request.SendNotificationRequestDto;
import com.pragma.powerup.adapters.driving.http.handlers.INotificationHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaging/v1/employee")
@RequiredArgsConstructor
public class EmployeeRestController {
    private final INotificationHandler notificationHandler;

    @Operation(summary = "Send notification to phone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notification sent", content = @Content),
            @ApiResponse(responseCode = "400", description = "Notification couldn't be sent", content = @Content)
    })
    @PostMapping("/send-notification")
    public ResponseEntity<Boolean> sendMessageToClient(@RequestBody @Valid SendNotificationRequestDto sendNotificationRequestDto) {
        return new ResponseEntity<>(this.notificationHandler.notifyClient(sendNotificationRequestDto), HttpStatus.OK);
    }
}