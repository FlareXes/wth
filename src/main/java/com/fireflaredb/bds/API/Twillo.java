package com.fireflaredb.bds.API;

import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;


public class Twillo {
    public static final String ACCOUNT_SID = "ACe279fadef07678e69535cfde42fe1704";
    public static final String AUTH_TOKEN = "d05f68e6f0706ac3d6690788dcc3ede3";

    public static String sendOTP(String phone) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Verification verification = Verification.creator(
                        "VA3d0334886ce77236ccbedb5dd9ee2ea8",
                        "+91" + phone,
                        "sms")
                .create();
        System.out.println("OTP Sent");
        return verification.getStatus();
    }

    public static boolean verifyOTP(String revOTP, String phone) {
        boolean flag = false;
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        VerificationCheck verificationCheck = VerificationCheck.creator(
                        "VA3d0334886ce77236ccbedb5dd9ee2ea8",
                        revOTP)
                .setTo("+91" + phone).create();
        if (verificationCheck.getStatus() == "approved") {
            flag = true;
        }
        System.out.println("OTP Received Passed: " + flag);
        return flag;
    }
}

//9358361733
