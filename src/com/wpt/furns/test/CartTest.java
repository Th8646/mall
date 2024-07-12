package com.wpt.furns.test;/**
 * @author wpt@onlying.cn
 * @date 2024/7/12 11:42
 */

import com.wpt.furns.entity.Cart;
import com.wpt.furns.entity.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @projectName: mall
 * @package: com.wpt.furns.test
 * @className: CartTest
 * @author: wpt
 * @description: TODO
 * @date: 2024/7/12 11:42
 * @version: 1.0
 */
public class CartTest {
    private Cart cart = new Cart();
    @Test
    public void addItem(){
        cart.addItem(new CartItem(1,"沙发",new BigDecimal(10),2,new BigDecimal(20)));
        cart.addItem(new CartItem(2,"小椅子",new BigDecimal(20),2,new BigDecimal(40)));
        cart.addItem(new CartItem(2,"小椅子",new BigDecimal(20),3,new BigDecimal(40)));
        System.out.println(cart);
    }
}
