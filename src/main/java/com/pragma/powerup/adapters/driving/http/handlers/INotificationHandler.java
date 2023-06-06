package com.pragma.powerup.adapters.driving.http.handlers;

import com.pragma.powerup.adapters.driving.http.dto.request.SendNotificationRequestDto;

public interface INotificationHandler {
    boolean notifyClient(SendNotificationRequestDto sendNotificationRequestDto);
}
