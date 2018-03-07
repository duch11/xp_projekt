package dk.adventurealley.app.Model.Entities;

public class Requirements {

    private String reqName;
    private String value;

    public Requirements() {
    }

    public Requirements(String reqName, String value) {
        this.reqName = reqName;
        this.value = value;
    }

    public Requirements(String reqName) {
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
        return "Requirements{" +
                "reqName='" + reqName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}