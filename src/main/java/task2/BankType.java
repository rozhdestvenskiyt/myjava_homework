package task2;

import java.math.BigDecimal;

public enum BankType {
    NEO("НеоКредит Банк", new BigDecimal("0.01")),
    AUM("Арум Финтех", new BigDecimal("0.02")),
    VTA("Вектор Альянс Банк", new BigDecimal("0.00"));

    public final String russianName;
    public final BigDecimal commissionRate;

    BankType(String russianName, BigDecimal commissionRate) {
        this.russianName = russianName;
        this.commissionRate = commissionRate;
    }

    public String getRussianName() {
        return russianName;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }
}
