package com.epam.jmp.service.impl;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;
import com.epam.jmp.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.epam.jmp.dto.ApplicationConstants.NO_SUBSCRIPTION_ERROR_MESSAGE;


public class ServiceImpl implements Service {

    private final Map<String, Subscription> subscriptions = new HashMap<>();
    private final List<User> users = new ArrayList<>();

    @Override
    public void subscribe(BankCard bankCard) {
        var subscription = new Subscription(bankCard.getNumber(), LocalDate.now());
        subscriptions.put(bankCard.getNumber(), subscription);
        users.add(bankCard.getUser());
    }

    @Override
    public Subscription getSubscriptionByBankCardNumber(String cardNumber) {
        return Optional.ofNullable(subscriptions.get(cardNumber))
                .orElseThrow(() -> new SubscriptionNotFoundException(NO_SUBSCRIPTION_ERROR_MESSAGE + cardNumber));
    }

    @Override
    public List<User> getAllUsers() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> filterCondition) {
        return subscriptions.values().stream()
                .filter(filterCondition)
                .collect(Collectors.toList());
    }
}
