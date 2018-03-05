package dk.adventurealley.app.Model.Entities;

public class Requirements {

    private int id;
    private int players;
    private int age;
    private int height;
    private int weight;
    private String rules;

    public Requirements() {

    }

    public Requirements(int id, int players, int age, int height, int weight, String rules) {
        this.id = id;
        this.players = players;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.rules = rules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
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
                ", players=" + players +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", rules='" + rules + '\'' +
                '}';
    }
}
