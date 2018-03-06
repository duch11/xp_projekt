package dk.adventurealley.app.Models;

import java.util.ArrayList;

public class Activity {
    private String name;
    private String equipment;
    private String imagePath;
    //private ArrayList<Requirements> reqList;

    public Activity(String name, String equipment, String imagePath){
        this.name = name;
        this.equipment = equipment;
        this.imagePath = imagePath;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String image_path) {
        this.imagePath = imagePath;
    }
}
