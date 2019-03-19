public class MatchMaker implements CompareForMatch {
    private static double tempForSkill;

    @Override
    public int compareAges(int age00, int age01) {
        if(age00 < 25 && age01 < 25) {
            return 1;
        }else if(age00 >= 25 && age01 >= 25) {
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public int compareWeights(double weight00, double weight01) {
        if(weight00 < 25 && weight01 < 25) {
            return 1;
        }else if(weight00 >= 25 && weight01 >= 25) {
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public int compareTypes(String type00, String type01) {                       // ıf boxer - boxer return 0
        if(type00.equalsIgnoreCase("boxer")) {                        // if boxer - kickboxer return 1
            if(type01.equalsIgnoreCase("boxer")) {
                return 0;
            }else if(type01.equalsIgnoreCase("kickboxer")) {          //if kickboxer - kickboxer return 2
                return 1;
            }else {
                System.out.println("Invalid pick! (00)");                         // if kickboxer - boxer return 3
            }
        }else if(type00.equalsIgnoreCase("kickboxer")) {
            System.out.println("It is a KickBox match ");
            if(type01.equalsIgnoreCase("kickboxer")) {
                return 2;
            }else if(type01.equalsIgnoreCase("boxer")) {
                return 3;
            }
        }
        return 4;
    }

    @Override
    public int compareSkills(double skill00, double skill01) {
        if(skill00 > skill01) {
            return 0;               //fighter00 wins
        }else if(skill00 < skill01) {
            return 1;               //fighter01 wins
        }else {
            return 2;               //draw
        }
    }

    public static double decreaseSkill(int which, double skill) {
        if(which == 0) {
            skill = skill - (skill * 0.15);
        }else if(which == 1) {
            skill = skill - (skill * 0.25);
        }
        return skill;
    }

    public MatchMaker(Fighter fighter00, Fighter fighter01) {
        if(compareAges(fighter00.getAge(), fighter01.getAge()) == 1) {
            if(compareWeights(fighter00.getWeight(), fighter01.getWeight()) == 1) {
                if(compareTypes(fighter00.getType(), fighter01.getType()) == 0 || compareTypes(fighter00.getType(), fighter01.getType()) == 1) {
                    System.out.println("It is a Box match between " + fighter00.getName() + " and " + fighter01.getName() + " !");
                    tempForSkill = fighter01.getSkillPoint();
                    tempForSkill = decreaseSkill(0, tempForSkill);                 //0 if decrease kickboxer
                                                                                                //1 if decrease boxer
                    if(compareSkills(fighter00.getSkillPoint(), tempForSkill) == 0) {
                        System.out.println(fighter00.getName() + " has win the match!");
                        fighter01.setSkillPoint(fighter01.increaseSkill());
                        System.out.println("\n New skill point for " + fighter01.getName() + " is " + fighter01.getSkillPoint());
                    }else if(compareSkills(fighter00.getSkillPoint(), tempForSkill) == 1) {
                        System.out.println(fighter01.getName() + " has win the match!");
                        fighter00.setSkillPoint(fighter00.increaseSkill());
                        System.out.println("\n New skill point for " + fighter00.getName() + " is " + fighter00.getSkillPoint());
                    }else if(compareSkills(fighter00.getSkillPoint(), tempForSkill) == 2) {
                        System.out.println("It's draw...");
                    }
                }else if(compareTypes(fighter00.getType(), fighter01.getType()) == 2 || compareTypes(fighter00.getType(), fighter01.getType()) == 3) {
                    System.out.println("It is a KickBox match between " + fighter00.getName() + " and " + fighter01.getName() + " !\n");
                        tempForSkill = fighter01.getSkillPoint();
                        tempForSkill = decreaseSkill(1, tempForSkill);                 //0 if decrease kickboxer
                                                                                                //1 if decrease boxer
                    if(compareSkills(fighter00.getSkillPoint(), tempForSkill) == 0) {
                        System.out.println(fighter00.getName() + " has win the match!\n");
                    }else if(compareSkills(fighter00.getSkillPoint(), tempForSkill) == 1) {
                        System.out.println(fighter01.getName() + " has win the match!\n");
                    }else if(compareSkills(fighter00.getSkillPoint(), tempForSkill) == 2) {
                        System.out.println("It's draw...");
                    }
                }
            }
        }
    }
}
