package com.epam.jmp;

import com.epam.jmp.bank.Bank;
import com.epam.jmp.bank.impl.BankImpl;
import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.DebitBankCard;
import com.epam.jmp.dto.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.time.LocalDate;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testCreateBankCard()
    {
        Bank bank = new BankImpl();
        BankCard card = bank.createBankCard(new User("name", "surname", LocalDate.now()), BankCardType.DEBIT);
        assertTrue(card instanceof DebitBankCard);
    }
}
