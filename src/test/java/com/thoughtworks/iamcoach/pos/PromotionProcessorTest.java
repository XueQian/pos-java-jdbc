package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.iamcoach.pos.FileProcessor.readFile;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PromotionProcessorTest {

    @Test
    public void should_return_an_promotion_object_with_one_parament() {
        PromotionProcessor promotionProcessor = mock(PromotionProcessor.class);
        List<Promotion> promotions = new ArrayList<Promotion>();
        promotions.add(0, new Promotion("IE00000"));
        when(promotionProcessor.halfProcess()).thenReturn(promotions);
        assertThat(promotionProcessor.halfProcess()).isEqualTo(promotions);

    }

    @Test
    public void should_return_an_promotion_object_with_two_parament() {
        PromotionProcessor promotionProcessor = mock(PromotionProcessor.class);
        List<Promotion> promotions = new ArrayList<Promotion>();
        promotions.add(0, new Promotion("IE00000", 80));
        when(promotionProcessor.discountProcess()).thenReturn(promotions);
        assertThat(promotionProcessor.discountProcess()).isEqualTo(promotions);

    }

    @Test
    public void should_return_buy_two_get_one_free_promotion_list() {
        PromotionProcessor promotionProcessor = new PromotionProcessor();
        assertThat(promotionProcessor.freeProcess().get(2).getBarcode()).isEqualTo("ITEM000005");

    }

    @Test
    public void should_return_second_half_price_promotion_list() {
        PromotionProcessor promotionProcessor = new PromotionProcessor();
        assertThat(promotionProcessor.halfProcess().get(2).getBarcode()).isEqualTo("ITEM000005");

    }

    @Test
    public void should_return_discount_promotion_list() {
        PromotionProcessor promotionProcessor = new PromotionProcessor();
        assertThat(promotionProcessor.discountProcess().get(2).getBarcode()).isEqualTo("ITEM000005");
        assertThat(promotionProcessor.discountProcess().get(1).getDiscount()).isEqualTo(85);

    }

}
