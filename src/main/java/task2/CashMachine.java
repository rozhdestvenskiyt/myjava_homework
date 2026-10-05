package task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashMachine implements WithdrawalOperations, DepositOperations {

    @Override
    public BigDecimal deposit(BigDecimal balance, BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return balance;
        }
        return balance.add(amount).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal withdraw(BigDecimal balance, BigDecimal amount, BankType bankType) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return balance;
        }
        BigDecimal commission = applyCommission(amount, bankType);
        BigDecimal totalAmount = amount.add(commission).setScale(2, RoundingMode.HALF_UP);
        if (totalAmount.compareTo(balance) > 0) {
            System.out.println("Недостаточно средств на счете.");
            return balance;
        }
        return balance.subtract(totalAmount).setScale(2, RoundingMode.HALF_UP);
    }
}
