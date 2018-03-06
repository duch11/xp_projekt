package dk.adventurealley.app.Model.Entities;

import java.util.ArrayList;

/**
 * Created by Ejer on 05-03-2018.
 */
public class Activity {
    private String name;
    private ArrayList<Requirement> regList;
    private String equipment;
    private String imagePath;
    private String description;

    public Activity(String name, ArrayList<Requirement> regList, String equipment, String imagePath, String description) {
        this.name = name;
        this.regList = regList;
        this.equipment = equipment;
        this.imagePath = imagePath;
        this.description = description;
    }

    public Activity(String name, String equipment, String imagePath, String description) {
        this.name = name;
        this.regList = regList;
        this.equipment = equipment;
        this.imagePath = imagePath;
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
                ", regList=" + regList +
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

    public ArrayList<Requirement> getRegList() {
        return regList;
    }

    public void setRegList(ArrayList<Requirement> regList) {
        this.regList = regList;
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
}
