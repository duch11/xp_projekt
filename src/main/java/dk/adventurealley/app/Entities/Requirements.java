package dk.adventurealley.app.Entities;

/**
 * Created by Ejer on 05-03-2018.
 */
public class Requirements {
    private String name;
    private String value;

    public Requirements(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Requirements() {
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
        return "Requirements{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
