package dk.adventurealley.app.Model.Entities;

import java.util.ArrayList;

public class Activity {

    private int id;
    private String name;
    private String equipment;
    private String imagePath;
    private ArrayList<Requirements> activityReq;
    private String description;

    public Activity() {
    }

    public Activity(int id, String name, String equipment, String imagePath, ArrayList<Requirements> activityReq, String description) {
        this.id = id;
        this.name = name;
        this.equipment = equipment;
        this.imagePath = imagePath;
        this.activityReq = activityReq;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Requirements> getActivityReq() {
        return activityReq;
    }

    public void setActivityReq(ArrayList<Requirements> activityReq) {
        this.activityReq = activityReq;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}