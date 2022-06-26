package com.fireflaredb.bds.API;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class CallBacks {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void TwilloMsgCall(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new PhoneNumber("+15558675310"),
                        new PhoneNumber("+15017122661"),
                        "This is the ship that made the Kessel Run in fourteen parsecs?")
                .create();

        System.out.println(message.getSid());
    }
}

