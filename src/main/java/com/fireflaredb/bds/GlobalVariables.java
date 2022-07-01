package com.fireflaredb.bds;

public class GlobalVariables {
    private static boolean isUserVerified;
    private static String currentLoginedUserPhone;

    private static String currentLoginedUserName;

    public static String getCurrentLoginedUserName() {
        return currentLoginedUserName;
    }

    public static void setCurrentLoginedUserName(String currentLoginedUserName) {
        GlobalVariables.currentLoginedUserName = currentLoginedUserName;
    }

    public static void setCurrentLoginedUserPhone(String loginedUserPhone) {
        currentLoginedUserPhone = loginedUserPhone;
    }

    public static String getCurrentLoginedUserPhone() {
        return currentLoginedUserPhone;
    }

    public static boolean getUserVerified() {
        return isUserVerified;
    }

    public static void setUserVerified(boolean userVerified) {
        System.out.println("setUserVerified Is Working" + " " + userVerified);
        isUserVerified = userVerified;
    }
}
