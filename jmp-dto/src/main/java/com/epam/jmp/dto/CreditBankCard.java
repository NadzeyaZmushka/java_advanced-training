package com.epam.jmp.dto;

import java.util.Objects;
import java.util.UUID;

import static com.epam.jmp.dto.ApplicationConstants.DEFAULT_LIMIT;

public class CreditBankCard extends BankCard {
    private double creditLimit;

    public CreditBankCard(String number, User user, double creditLimit) {
        super(number, user);
        this.creditLimit = creditLimit;
    }

    public CreditBankCard(User user) {
        super(UUID.randomUUID().toString(), user);
        this.creditLimit = DEFAULT_LIMIT;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditBankCard that = (CreditBankCard) o;
        return Double.compare(creditLimit, that.creditLimit) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(creditLimit);
    }

    @Override
    public String toString() {
        return "CreditBankCard{" +
                "creditLimit=" + creditLimit +
                '}';
    }
}
