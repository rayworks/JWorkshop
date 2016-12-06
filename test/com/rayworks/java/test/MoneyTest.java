package com.rayworks.java.test;

import com.rayworks.java.unittest.Money;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParameters;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sean on 12/6/16.
 * <p/>
 * https://blogs.oracle.com/jacobc/entry/parameterized_unit_tests_with_junit
 */
@RunWith(Parameterized.class)
public class MoneyTest {

    private int amount;
    private String currency;

    /**
     * Constructor.
     * The JUnit test runner will instantiate this class once for every
     * element in the Collection returned by the method annotated with
     *
     * @Parameters.
     */
    public MoneyTest(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    /***
     * Test data generator.
     * @return
     */
    @Parameters
    public static final Object[] getMoney() {
        return new Object[]{
                new Object[]{10, "USD"},
                new Object[]{20, "EUR"}
        };
    }

    @org.junit.Test
    public void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(amount, currency);

        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());

        /*assertEquals(10, money.getAmount());
        assertEquals("USD", money.getCurrency());

        money = new Money(20, "EUR");
        assertEquals(20, money.getAmount());
        assertEquals("EUR", money.getCurrency());*/
    }
}