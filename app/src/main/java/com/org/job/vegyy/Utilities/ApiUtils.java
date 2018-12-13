package com.org.job.vegyy.Utilities;


public class ApiUtils {

    public static String BASE_URL = "http://dailyfresh.circlesltd.com/Api/";

    public static SOService getSOService() {

        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}