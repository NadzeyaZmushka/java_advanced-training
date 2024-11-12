package com.epam.jmp.dto;

import java.util.Objects;
import java.util.UUID;

import static com.epam.jmp.dto.ApplicationConstants.DEFAULT_BALANCE;

public class DebitBankCard extends BankCard {
    private double balance;

    public DebitBankCard(String number, User user, double balance) {
        super(number, user);
        this.balance = balance;
    }

    public DebitBankCard(User user) {
        super(UUID.randomUUID().toString(), user);
        this.balance = DEFAULT_BALANCE;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DebitBankCard that = (DebitBankCard) o;
        return Double.compare(balance, that.balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), balance);
    }

    @Override
    public String toString() {
        return "DebitBankCard{" +
                "balance=" + balance +
                '}';
    }
}
