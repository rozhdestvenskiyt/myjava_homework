package task2;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account referenceAccount = new Account(12345, 999, new BigDecimal("10000.00"), BankType.AUM);

        System.out.println("Добро пожаловать в банкомат!");
        System.out.print("Введите номер карты: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка доступа. Введены некорректные данные.");
            scanner.close();
            return;
        }
        int cardNumber = scanner.nextInt();

        System.out.print("Введите пин-код: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка доступа. Введены некорректные данные.");
            scanner.close();
            return;
        }
        int pin = scanner.nextInt();

        if (cardNumber != referenceAccount.getCardNumber() || pin != referenceAccount.getPin()) {
            System.out.println("Ошибка доступа. Неверный номер карты или пин-код.");
            scanner.close();
            return;
        }

        System.out.println("Авторизация успешна!");
        System.out.println(referenceAccount);

        CashMachine cashMachine = new CashMachine();

        System.out.print("Введите сумму для внесения: ");
        if (!scanner.hasNextBigDecimal()) {
            System.out.println("Некорректная сумма.");
            scanner.close();
            return;
        }
        BigDecimal depositAmount = scanner.nextBigDecimal();
        referenceAccount.balance = cashMachine.deposit(referenceAccount.getBalance(), depositAmount);
        System.out.println("После внесения: " + referenceAccount);

        System.out.print("Введите сумму для снятия: ");
        if (!scanner.hasNextBigDecimal()) {
            System.out.println("Некорректная сумма.");
            scanner.close();
            return;
        }
        BigDecimal withdrawAmount = scanner.nextBigDecimal();
        referenceAccount.balance = cashMachine.withdraw(referenceAccount.getBalance(), withdrawAmount, referenceAccount.getBankType());
        System.out.println("После снятия: " + referenceAccount);

        scanner.close();
    }
}
