package dk.adventurealley.app.Model.Entities;

import java.util.ArrayList;

/**
 * Created by Ejer on 05-03-2018.
 */
public class Activity {
    private String name;
    private ArrayList<Requirement> reqList;
    private String equipment;
    private String imagePath;
    private String description;
    private ArrayList<Requirement> activityReq;

    public Activity(String name, ArrayList<Requirement> reqList, String equipment, String imagePath, String description) {
        this.name = name;
        this.reqList = reqList;
        this.equipment = equipment;
        this.imagePath = imagePath;
        this.description = description;
    }

    public Activity(String name, String equipment, String imagePath, String description) {
    public Activity(String name, String equipment, String imagePath, ArrayList<Requirement> activityReq, String description) {
        this.name = name;
        this.reqList = reqList;
        this.equipment = equipment;
        this.imagePath = imagePath;
        this.description = description;
        this.imagePath = imagePath;
        this.activityReq = activityReq;
        this.description = description;
    }



    public Activity() {
    }

    public Activity(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", regList=" + reqList +
                ", equipment='" + equipment + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Requirement> getReqList() {
        return reqList;
    }

    public void setReqList(ArrayList<Requirement> regList) {
        this.reqList = regList;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ArrayList<Requirement> getActivityReq() {
        return activityReq;
    }

    public void setActivityReq(ArrayList<Requirement> activityReq) {
        this.activityReq = activityReq;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", equipment='" + equipment + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", activityReq=" + activityReq +
                ", description='" + description + '\'' +
                '}';
    }
}