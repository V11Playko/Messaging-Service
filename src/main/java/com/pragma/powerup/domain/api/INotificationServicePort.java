package com.pragma.powerup.domain.api;

public interface INotificationServicePort {
    boolean notifyClient(String message, String phone);
}
