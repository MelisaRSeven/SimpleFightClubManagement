public class Boxer extends Fighter {
    public Boxer(String name, int age, double weight, double skillPoint, String type) {
        super(name, age, weight, skillPoint, type);
    }

    @Override
    public double increaseSkill() {
        double temp = this.getSkillPoint();
        temp = (temp * 0.05) + temp;
        temp = this.setSkillPoint(temp);
        return temp;
    }
}
