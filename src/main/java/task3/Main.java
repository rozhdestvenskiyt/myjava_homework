package task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("создание персонажей");

        Hero fighter1 = createHero(scanner, 1);
        Hero fighter2 = createHero(scanner, 2);

        scanner.close();

        Arena arena = new Arena(fighter1, fighter2);
        arena.startTournament();
    }

    private static Hero createHero(Scanner scanner, int number) {
        System.out.println("Боец #" + number);
        System.out.println("Тип персонажа (1-Воин, 2-Маг):");

        System.out.print("Ваш выбор: ");

        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Имя: ");
        String name = scanner.nextLine();

        System.out.print("Максимальное здоровье: ");
        int maxHealth = scanner.nextInt();

        System.out.print("Базовая атака: ");
        int baseAttack = scanner.nextInt();

        if (type == 1) {
            System.out.print("Броня: ");
            int armor = scanner.nextInt();
            scanner.nextLine();
            return new Warrior(name, maxHealth, baseAttack, armor);
        } else {
            System.out.print("Максимальная мана: ");
            int maxMana = scanner.nextInt();
            scanner.nextLine();
            return new Mage(name, maxHealth, baseAttack, maxMana);
        }
    }
}
