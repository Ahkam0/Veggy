package com.org.job.vegyy.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Muhammad Ahkam Ahmad on 7/30/2018.
 */

public class ModelShowItems {

    @SerializedName("status")
    @Expose
    private List<Status> status = null;
    @SerializedName("status_message")
    @Expose
    private String statusMessage;

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }


    public class Status {

        @SerializedName("item_id")
        @Expose
        private String itemId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("urdu_name")
        @Expose
        private String urduName;
        @SerializedName("priceKG")
        @Expose
        private String priceKG;
        @SerializedName("priceGRAM")
        @Expose
        private String priceGRAM;
        @SerializedName("image")
        @Expose
        private String image;

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrduName() {
            return urduName;
        }

        public void setUrduName(String urduName) {
            this.urduName = urduName;
        }

        public String getPriceKG() {
            return priceKG;
        }

        public void setPriceKG(String priceKG) {
            this.priceKG = priceKG;
        }

        public String getPriceGRAM() {
            return priceGRAM;
        }

        public void setPriceGRAM(String priceGRAM) {
            this.priceGRAM = priceGRAM;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    }

}
