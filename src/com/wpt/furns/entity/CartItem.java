package com.wpt.furns.entity;/**
 * @author wpt@onlying.cn
 * @date 2024/7/12 11:16
 */

import java.math.BigDecimal;

/**
 * @projectName: mall
 * @package: com.wpt.furns.entity
 * @className: CartItem
 * @author: wpt
 * @description: 表示购物车的一项，某个家具数据
 * @date: 2024/7/12 11:16
 * @version: 1.0
 */
public class CartItem {
    //  定义属性
    private Integer id; //  家居id
    private String name; //  家居名
    private BigDecimal price; //  价格
    private Integer count; // 购买数量
    private BigDecimal totalPrice;// 总价

    public CartItem() {
    }

    public CartItem(Integer id, String name, BigDecimal price, Integer count, BigDecimal total_price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

