package com.org.job.vegyy.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Muhammad Ahkam Ahmad on 7/31/2018.
 */

public class ModelShowCard {


    @SerializedName("status")
    @Expose
    private List<Status> status = null;
    @SerializedName("totalitems")
    @Expose
    private String totalitems;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("grandtotal")
    @Expose
    private String grandtotal;
    @SerializedName("status_message")
    @Expose
    private String statusMessage;

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public String getTotalitems() {
        return totalitems;
    }

    public void setTotalitems(String totalitems) {
        this.totalitems = totalitems;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(String grandtotal) {
        this.grandtotal = grandtotal;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }


    public class Status {

        @SerializedName("card_id")
        @Expose
        private String cardId;
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
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("quantity")
        @Expose
        private String quantity;
        @SerializedName("unit")
        @Expose
        private String unit;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

    }


}