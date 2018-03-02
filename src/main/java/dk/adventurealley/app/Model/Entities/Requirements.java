package dk.adventurealley.app.Model.Entities;

public class Requirements {

    private int id;
    private int age;
    private int height;
    private int weight;
    private String equipment;
    private String rules;

    public Requirements() {

    }

    public Requirements(int id, int age, int height, int weight, String equipment, String rules) {
        this.id = id;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.equipment = equipment;
        this.rules = rules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "Requirements{" +
                "id=" + id +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", equipment='" + equipment + '\'' +
                ", rules='" + rules + '\'' +
                '}';
    }
}
