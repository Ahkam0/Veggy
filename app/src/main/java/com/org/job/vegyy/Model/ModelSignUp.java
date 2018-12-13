package com.org.job.vegyy.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Muhammad Ahkam Ahmad on 8/5/2018.
 */

public class ModelSignUp {

    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("status_message")
    @Expose
    private String statusMessage;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}

