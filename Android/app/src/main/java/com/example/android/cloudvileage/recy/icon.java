package com.example.android.cloudvileage.recy;

public class icon {
    private int cloudvillage_image;
    private String cloudvillage_title;
    private int cloudvillage_authorimage;
    private String cloudvillage_authorname;
    private String cloudvillage_clicknum;

    public icon(int cloudvillage_image, String cloudvillage_title, int cloudvillage_authorimage, String cloudvillage_authorname, String cloudvillage_clicknum) {
        this.cloudvillage_image = cloudvillage_image;
        this.cloudvillage_title = cloudvillage_title;
        this.cloudvillage_authorimage = cloudvillage_authorimage;
        this.cloudvillage_authorname = cloudvillage_authorname;
        this.cloudvillage_clicknum = cloudvillage_clicknum;
    }

    public int getCloudvillage_image() {
        return cloudvillage_image;
    }

    public void setCloudvillage_image(int cloudvillage_image) {
        this.cloudvillage_image = cloudvillage_image;
    }

    public String getCloudvillage_title() {
        return cloudvillage_title;
    }

    public void setCloudvillage_title(String cloudvillage_title) {
        this.cloudvillage_title = cloudvillage_title;
    }

    public int getCloudvillage_authorimage() {
        return cloudvillage_authorimage;
    }

    public void setCloudvillage_authorimage(int cloudvillage_authorimage) {
        this.cloudvillage_authorimage = cloudvillage_authorimage;
    }

    public String getCloudvillage_authorname() {
        return cloudvillage_authorname;
    }

    public void setCloudvillage_authorname(String cloudvillage_authorname) {
        this.cloudvillage_authorname = cloudvillage_authorname;
    }

    public String getCloudvillage_clicknum() {
        return cloudvillage_clicknum;
    }

    public void setCloudvillage_clicknum(String cloudvillage_clicknum) {
        this.cloudvillage_clicknum = cloudvillage_clicknum;
    }
}
