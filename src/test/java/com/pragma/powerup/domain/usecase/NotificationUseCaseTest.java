package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.ports.IMessageNotificationPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificationUseCaseTest {

    @InjectMocks
    NotificationUseCase notificationUseCase;

    @Mock
    IMessageNotificationPort messageNotificationPort;

    @Test
    void notifyClientReturnTrue() {
        NotificationUseCase notificationUseCase = new NotificationUseCase(messageNotificationPort);
        String message = "Hola guapo :v";
        String phone = "+57 3134625323";
        when(messageNotificationPort.sendNotificationToNumber(message, phone)).thenReturn(true);

        boolean result = notificationUseCase.notifyClient(message, phone);

        assertTrue(result);
        verify(messageNotificationPort, times(1)).sendNotificationToNumber(message, phone);
    }

    @Test
    void notifyClientReturnFalse() {
        NotificationUseCase notificationUseCase = new NotificationUseCase(messageNotificationPort);
        String message = "Hola guapo :v";
        String phone = "+57 3134625323";
        when(messageNotificationPort.sendNotificationToNumber(message, phone)).thenReturn(false);

        boolean result = notificationUseCase.notifyClient(message, phone);

        assertFalse(result);
        verify(messageNotificationPort, times(1)).sendNotificationToNumber(message, phone);
    }
}