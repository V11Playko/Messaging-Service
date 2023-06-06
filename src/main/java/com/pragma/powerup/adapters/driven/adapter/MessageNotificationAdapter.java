package com.pragma.powerup.adapters.driven.adapter;

import com.pragma.powerup.adapters.driven.exceptions.TwilioException;
import com.pragma.powerup.domain.ports.IMessageNotificationPort;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class MessageNotificationAdapter implements IMessageNotificationPort {

    private static final String SERVICE_SID = System.getenv("TWILIO_SERVICE_SID");

    @Override
    public boolean sendNotificationToNumber(String message, String phone) {
        try{
            Message twilioMessage = Message.creator(new PhoneNumber(phone), SERVICE_SID, message)
                    .create();
            return twilioMessage.getStatus() == Message.Status.ACCEPTED;
        } catch (ApiException e) {
            throw new TwilioException();
        }
    }
}
