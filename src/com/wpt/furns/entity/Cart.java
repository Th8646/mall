package com.wpt.furns.entity;/**
 * @author wpt@onlying.cn
 * @date 2024/7/12 11:21
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Set;

/**
 * @projectName: mall
 * @package: com.wpt.furns.entity
 * @className: Cart
 * @author: wpt
 * @description: 购物车，含有多个CartItem的HashMap
 * @date: 2024/7/12 11:21
 * @version: 1.0
 */
public class Cart {
    // 定义属性
    private HashMap<Integer, CartItem> items = new HashMap<>();
    // 购物车商品的总数量


    public HashMap<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(HashMap<Integer, CartItem> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        int totalCount = 0;
        // 遍历HashMap
        Set<Integer> keys = items.keySet();
        for (int id : keys) {
            totalCount += ((CartItem) items.get(id)).getCount();
        }
        return totalCount;
    }




    // 添加家居到cart
    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());//传入的cartItem的值
        if (null == item) {//当前购物车没有这个cartItem
            items.put(cartItem.getId(), cartItem);
        } else {//购物车中有对应的cartItem，增加count，修改total_price
            item.setCount(item.getCount() + cartItem.getCount());
            item.setTotal_price(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }


    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
