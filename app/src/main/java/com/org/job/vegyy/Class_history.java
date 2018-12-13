package com.org.job.vegyy;

public class Class_history {
    public String time;
    public String status;
    public String total;

    public Class_history(String time, String status, String total){
        this.status = status;
        this.time = time;
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
