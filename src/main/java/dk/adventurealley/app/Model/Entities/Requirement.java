package dk.adventurealley.app.Model.Entities;

/**
 * Created by Ejer on 05-03-2018.
 */
public class Requirement {
    private String reqName;
    private String value;


    //Full constructor
    public Requirement(String reqName, String value) {
        this.reqName = reqName;
        this.value = value;
    }

    // Lavet af Andreas og Jonas
    // Bruges til; "Create requirement name" i Requirement repo
    public Requirement(String reqName) {
        this.reqName = reqName;
    }

    // Bruges af Create Controller, til model
    public Requirement() {
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
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
                "name='" + reqName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
