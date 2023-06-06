package com.pragma.powerup.adapters.driving.http.handlers.impl;

import com.pragma.powerup.adapters.driving.http.dto.request.SendNotificationRequestDto;
import com.pragma.powerup.adapters.driving.http.handlers.INotificationHandler;
import com.pragma.powerup.domain.api.INotificationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationHandler implements INotificationHandler {
    private final INotificationServicePort notificationServicePort;

    @Override
    public boolean notifyClient(SendNotificationRequestDto sendNotificationRequestDto) {
        return notificationServicePort.notifyClient(
                sendNotificationRequestDto.getMessage(),
                sendNotificationRequestDto.getPhone()
        );
    }
}
