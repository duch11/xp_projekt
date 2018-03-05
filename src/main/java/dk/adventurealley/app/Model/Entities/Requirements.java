package dk.adventurealley.app.Model.Entities;

public class Requirements {

    private int id;
    private String players;
    private String age;
    private String height;
    private String weight;
    private String rules;

    public Requirements() {

    }

    public Requirements(int id, String players, String age, String height, String weight, String rules) {
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

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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
                ", players='" + players + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", rules='" + rules + '\'' +
                '}';
    }
}
