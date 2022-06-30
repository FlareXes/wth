package com.fireflaredb.bds.API;

import java.text.DecimalFormat;
import java.util.Random;

public class Utils {
    public String generateOTP() {
        return new DecimalFormat("000000").format(new Random().nextInt(999999));
    }
}
