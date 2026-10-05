package task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface WithdrawalOperations {

    BigDecimal withdraw(BigDecimal balance, BigDecimal amount, BankType bankType);

    default BigDecimal applyCommission(BigDecimal amount, BankType bankType) {
        if (amount == null || bankType == null) {
            return BigDecimal.ZERO;
        }
        return amount.multiply(bankType.getCommissionRate()).setScale(2, RoundingMode.HALF_UP);
    }
}
