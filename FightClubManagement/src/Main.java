public class Main {
    public static void main(String[] args) {
        Fighter fighter00 = new Boxer("The Lightning", 22, 81d, 10.22, "Boxer");
        Fighter fighter01 = new Boxer("Rockhead", 23, 83.05, 15.22, "kickboxer");

        MatchMaker match00 = new MatchMaker(fighter00, fighter01);

        System.out.println(match00);

        //match00.matchType(fighter00, fighter01);
    }

}
