package com.org.job.vegyy;

/**
 * Created by LENOVO on 7/7/2018.
 */

public class
Category {


    private String id;
    private String Name;

    public Category(){}

    public Category (String Name,String id)
    {
        this.Name = Name;
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

