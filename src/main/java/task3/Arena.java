package task3;

public class Arena {

    private final Hero fighter1;
    private final Hero fighter2;
    private int roundCounter;

    public Arena(Hero fighter1, Hero fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.roundCounter = 0;
    }

    public void startTournament() {
        System.out.println("Арена героев");
        System.out.println(fighter1.getName() + " вступает в бой с " + fighter2.getName());
        

        while (fighter1.isAlive() && fighter2.isAlive()) {
            roundCounter++;
            System.out.println("\nРаунд " + roundCounter);

            Hero attacker;
            Hero defender;

            if (Math.random() < 0.5) {
                attacker = fighter1;
                defender = fighter2;
            } else {
                attacker = fighter2;
                defender = fighter1;
            }

            System.out.println(attacker.getName() + " ходит первым");

            ActionType action = attacker.makeTurn(defender);
            System.out.println(attacker.getName() + " сделал " + action.getRussianName());

            if (!defender.isAlive()) {
                break;
            }

            ActionType defenderAction = defender.makeTurn(attacker);
            System.out.println("игрок [" + defender.getName() + "] сделал: " + defenderAction.getRussianName());

            System.out.println("\nстатус после раунда " + roundCounter + ":");
            printHeroStatus(fighter1);
            printHeroStatus(fighter2);
        }

        System.out.println("\nконец боя");

        if (fighter1.isAlive()) {
            System.out.println("победил " + fighter1.getName());
        } else if (fighter2.isAlive()) {
            System.out.println("победил " + fighter2.getName());
        } else {
            System.out.println("Ничья! Оба героя пали в бою!");
        }
    }

    private void printHeroStatus(Hero hero) {
        String status = hero.getName() + ": HP " + hero.getHealth() + "/" + hero.getMaxHealth();

        if (hero instanceof Mage) {
            Mage mage = (Mage) hero;
            status = status + " | Мана: " + mage.getMana() + "/" + mage.getMaxMana();
        } else if (hero instanceof Warrior) {
            Warrior warrior = (Warrior) hero;
            status = status + " | Броня: " + warrior.getArmor();
        }

        System.out.println(status);
    }
}
