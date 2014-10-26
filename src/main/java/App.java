import com.thoughtworks.iamcoach.pos.Calculator;
import com.thoughtworks.iamcoach.pos.CartItem;
import com.thoughtworks.iamcoach.pos.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        Calculator calculator = new Calculator();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("**************************LET US GO**************************");
        System.out.println("打印时间 " + dateFormat.format(new Date()));

        List<CartItem> cartItems = scanner.process();
        for (CartItem cartItem : cartItems) {
            System.out.println("购物明细 名称：" + cartItem.getItem().getName() +
                    "  数量：" + cartItem.getCount() + "  单价：" + cartItem.getItem().getPrice() + "元"+
                    "  单位：" + cartItem.getItem().getUnit() + "  小计:" + calculator.getSubtotal(cartItem)+"元");
        }
        System.out.println("总计金额 优惠前：" + calculator.getTotalMoney() + "元   优惠后：" + calculator.getTotalMoneyAfterPromoting() +
                        "元   优惠差价:" + calculator.getSavedMoney() + "元");

    }
}
