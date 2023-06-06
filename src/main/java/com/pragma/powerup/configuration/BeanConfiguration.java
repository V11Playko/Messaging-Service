package com.pragma.powerup.configuration;

import com.pragma.powerup.adapters.driven.adapter.MessageNotificationAdapter;
import com.pragma.powerup.domain.api.INotificationServicePort;
import com.pragma.powerup.domain.ports.IMessageNotificationPort;
import com.pragma.powerup.domain.usecase.NotificationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IMessageNotificationPort messageNotificationPort() {
        return new MessageNotificationAdapter();
    }

    @Bean
    public INotificationServicePort notificationServicePort(){
        return new NotificationUseCase(messageNotificationPort());
    }
}
