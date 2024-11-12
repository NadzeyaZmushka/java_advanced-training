package com.epam.jmp;

import com.epam.jmp.bank.impl.BankImpl;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.User;
import com.epam.jmp.service.Service;
import com.epam.jmp.service.impl.ServiceImpl;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        var bank = new BankImpl();
        var service = new ServiceImpl();

        var userIvan = createUser("Ivan", "Smirnov", LocalDate.of(1989, 12,31));
        var userMary = createUser("Mary", "Smirnova", LocalDate.of(1990, 10,11));

        var creditCard = bank.createBankCard(userIvan, BankCardType.CREDIT);
        var debitCard = bank.createBankCard(userMary, BankCardType.DEBIT);

        service.subscribe(creditCard);
        service.subscribe(debitCard);

        var allSubscriptionsByCondition = service.getAllSubscriptionsByCondition(subscription ->
                subscription.getStartDate().isAfter(LocalDate.of(2024, 11, 11)));
        var subscriptionByBankCardNumber = service.getSubscriptionByBankCardNumber(creditCard.getNumber());

        System.out.println("Successfully subscribed user " + userIvan + " with a bank card " + creditCard.getNumber());
        System.out.println("Successfully subscribed user " + userMary + " with a bank card " + debitCard.getNumber());
        System.out.println("Subscription: " + subscriptionByBankCardNumber);
        System.out.println("All users: " + service.getAllUsers());
        System.out.println("Subscriptions: " + allSubscriptionsByCondition);
        System.out.println("Average users age: " + service.getAverageUsersAge());
        System.out.println("Is payable user: " + userIvan + Service.isPayableUser(userIvan));
        System.out.println("Subscription: " + service.getSubscriptionByBankCardNumber("2"));

    }

    private static User createUser(String name, String surname, LocalDate dateOfBirth) {
        return new User(name, surname, dateOfBirth);
    }
}
