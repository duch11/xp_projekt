package dk.adventurealley.app.Model.Entities;

/**
 * Created by Ejer on 05-03-2018.
 */
public class Requirement {
    private String name;
    private String value;


    //Full constructor
    public Requirement(String name, String value) {
        this.name = name;
        this.value = value;
    }

    // Lavet af Andreas og Jonas
    // Bruges til; "Create requirement name" i Requirement repo
    public Requirement(String name) {
        this.name = name;
    }

    // Bruges af Create Controller, til model
    public Requirement() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Requirement{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}