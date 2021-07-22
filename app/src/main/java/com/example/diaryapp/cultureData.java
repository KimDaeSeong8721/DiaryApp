package com.example.diaryapp;

public class cultureData {

    private String cultureName;
    private String culutreLocation;

    public cultureData(String cultureName, String culutreLocation){

        this.cultureName = cultureName;
        this.culutreLocation = culutreLocation;
    }



    public String getCultureName()
    {
        return this.cultureName;
    }

    public String getCulutreLocation()
    {
        return this.culutreLocation;
    }
}
