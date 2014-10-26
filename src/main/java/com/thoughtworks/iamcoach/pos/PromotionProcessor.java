package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.List;

public class PromotionProcessor {

    public List<Promotion> freeProcess() {
        return this.process("buy_two_get_one_free_promotion.txt");
    }

    public List<Promotion> halfProcess() {
        return this.process("second_half_price_promotion.txt");
    }

    public List<Promotion> discountProcess() {

        List<Promotion> promotions = new ArrayList<Promotion>();
        List<String> promotionList = FileProcessor.readFile("discount_promotion.txt");

        for (String aPromotionList : promotionList) {
            String[] stringPromotion = aPromotionList.split(":");
            Promotion promotion = new Promotion(stringPromotion[0], Double.parseDouble(stringPromotion[1]));
            promotions.add(promotion);
        }

        return promotions;
    }

    private List<Promotion> process(String fileName) {

        List<Promotion> promotions = new ArrayList<Promotion>();
        List<String> promotionList = FileProcessor.readFile(fileName);

        for (String aPromotionList : promotionList) {
            Promotion promotion = new Promotion(aPromotionList);
            promotions.add(promotion);
        }
        return promotions;
    }
}
