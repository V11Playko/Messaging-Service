package com.pragma.powerup.configuration;

import com.twilio.Twilio;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfiguration {
    private static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public TwilioConfiguration() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
}
