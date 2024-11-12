package com.epam.jmp;

import com.epam.jmp.bank.Bank;
import com.epam.jmp.bank.impl.BankImpl;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.User;
import com.epam.jmp.service.Service;
import com.epam.jmp.service.impl.ServiceImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.time.LocalDate;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    private final Bank bank = new BankImpl();
    private final Service service = new ServiceImpl();

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testSubscribe() {
        var bankCard = bank.createBankCard(new User("name", "surname", LocalDate.of(1991, 12, 12)),
                BankCardType.CREDIT);
        service.subscribe(bankCard);
        assertNotNull(service.getSubscriptionByBankCardNumber(bankCard.getNumber()));
    }
}
