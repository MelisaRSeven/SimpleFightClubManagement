public abstract class Fighter {
    private String name;
    private int age;
    private double weight;
    private double skillPoint;
    private String type;

    public Fighter(String name, int age, double weight, double skillPoint, String type) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.skillPoint = skillPoint;
        this.type = type;
        print();
    }

    public abstract double increaseSkill();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSkillPoint() {
        return skillPoint;
    }

    public double setSkillPoint(double skillPoint) {
        this.skillPoint = skillPoint;
        return skillPoint;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void print() {
        System.out.println("\nName : " + getName());
        System.out.println("Age : " + getAge());
        System.out.println("Weight : " + getWeight());
        System.out.println("Skill Point : " + getSkillPoint());
        System.out.println("Type : " + getType());
    }
}
