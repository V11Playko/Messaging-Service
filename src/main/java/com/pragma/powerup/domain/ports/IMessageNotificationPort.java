package com.pragma.powerup.domain.ports;

public interface IMessageNotificationPort {
    boolean sendNotificationToNumber(String message, String phone);
}
