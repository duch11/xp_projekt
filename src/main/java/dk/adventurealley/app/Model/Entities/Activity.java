package dk.adventurealley.app.Model.Entities;

import java.util.ArrayList;

public class Activity {

    private String name;
    private String equipment;
    private String imagePath;
    private ArrayList<Requirement> activityReq;
    private String description;

    public Activity() {
    }

    public Activity(String name, String equipment, String imagePath, ArrayList<Requirement> activityReq, String description) {
        this.name = name;
        this.equipment = equipment;
        this.imagePath = imagePath;
        this.activityReq = activityReq;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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