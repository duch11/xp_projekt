package dk.adventurealley.app.Model.Entities;

public class Requirement {

    private String reqName;
    private String value;

    public Requirement() {
    }

    public Requirement(String reqName, String value) {
        this.reqName = reqName;
        this.value = value;
    }

    public Requirement(String reqName) {
        this.reqName = reqName;
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
                "reqName='" + reqName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}