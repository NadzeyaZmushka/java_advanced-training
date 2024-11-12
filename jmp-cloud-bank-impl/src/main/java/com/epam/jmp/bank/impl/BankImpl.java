package com.epam.jmp.bank.impl;

import com.epam.jmp.bank.Bank;
import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.CreditBankCard;
import com.epam.jmp.dto.DebitBankCard;
import com.epam.jmp.dto.User;

import java.util.function.Function;

import static com.epam.jmp.dto.ApplicationConstants.INVALID_TYPE_ERROR_MESSAGE;

public class BankImpl implements Bank {

    private final Function<User, BankCard> creditCardProvider = CreditBankCard::new;
    private final Function<User, BankCard> debitCardProvider = DebitBankCard::new;

    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        switch (cardType) {
            case DEBIT:
                return debitCardProvider.apply(user);
            case CREDIT:
                return creditCardProvider.apply(user);
            default:
                throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE + cardType);
        }
    }
}
