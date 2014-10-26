package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void should_return_a_lowest_promotion() {

        Calculator calculator = new Calculator();

        Item item = new Item("ITEM000005", "鸡翅", 10, "块");
        CartItem cartItem = new CartItem(item, 5);
        assertThat(calculator.getSubtotal(cartItem)).isEqualTo(40.0);
    }

    @Test
    public void should_return_total_money_before_promot() {

        Calculator calculator = new Calculator();
        assertThat(calculator.getTotalMoney()).isEqualTo(286);
    }

    @Test
    public void should_return_a_no_promotion_price() {

        Calculator calculator = new Calculator();

        Item item = new Item("ITEM000002", "苹果", 10, "个");
        CartItem cartItem = new CartItem(item, 5);
        assertThat(calculator.getSubtotal(cartItem)).isEqualTo(50);
    }

    @Test
    public void should_return_total_money_after_promotion() {
        Calculator calculator = new Calculator();
        assertThat(calculator.getTotalMoneyAfterPromoting()).isEqualTo(207.35);
    }

    @Test
    public void should_return_saved_money() {
        Calculator calculator = new Calculator();
        assertThat(calculator.getSavedMoney()).isEqualTo(78.65);
    }

}

