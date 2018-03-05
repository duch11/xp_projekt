package dk.adventurealley.app.models;

import java.util.ArrayList;

public class Activity {

    private String name;
    private ArrayList<Requirement> requirements;
    private String equipment;
    private String imagePath;
    private String description;

    public Activity(String name, ArrayList<Requirement> requirements, String equipment, String imagePath, String description) {
        this.name = name;
        this.requirements = requirements;
        this.equipment = equipment;
        this.imagePath = imagePath;
        this.description = description;
    }

    public Activity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(ArrayList<Requirement> requirements) {
        this.requirements = requirements;
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
