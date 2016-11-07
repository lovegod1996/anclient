package com.example.a123.myapplication.bean;

/**
 * Created by 123 on 2016/11/7.
 */

public class Help {
    private Long id;
    private  String title;
    private int version;
    public HelpDetail theHelpDetail[];

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public HelpDetail[] getTheHelpDetail() {
        return theHelpDetail;
    }

    public void setTheHelpDetail(HelpDetail[] theHelpDetail) {
        this.theHelpDetail = theHelpDetail;
    }
}
