package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.INotificationServicePort;
import com.pragma.powerup.domain.ports.IMessageNotificationPort;

public class NotificationUseCase implements INotificationServicePort {
    private final IMessageNotificationPort messageNotificationPort;

    public NotificationUseCase(IMessageNotificationPort messageNotificationPort) {
        this.messageNotificationPort = messageNotificationPort;
    }

    @Override
    public boolean notifyClient(String message, String phone) {
        return messageNotificationPort.sendNotificationToNumber(message, phone);
    }
}
