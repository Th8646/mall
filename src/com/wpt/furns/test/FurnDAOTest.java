package com.wpt.furns.test;/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 23:49
 */

import com.wpt.furns.dao.FurnDAO;
import com.wpt.furns.dao.impl.FurnDAOImpl;
import com.wpt.furns.entity.Furn;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.test
 * @className: FurnDAOTest
 * @author: wpt
 * @description: TODO
 * @date: 2024/3/30 23:49
 * @version: 1.0
 */
public class FurnDAOTest {
    private FurnDAO furnDAO = new FurnDAOImpl();

    @Test
    public void queryFurn() {
        List<Furn> furns = furnDAO.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }

    @Test
    public void add() {
        Furn furn = new Furn(null, "可爱的沙发", "蚂蚁家居",
                new BigDecimal(999.99), 100, 10, "assets/images/product-image/default.jpg");
        int i = furnDAO.addFurn(furn);
        System.out.println("执行结果是：" + i);
    }

    @Test
    public void getTotalRow() {
        System.out.println(furnDAO.getTotalRow());
    }

    @Test
    public void getPageItems() {
        List<Furn> pageItems = furnDAO.getPageItems(0, 3);
        for (Furn pageItem : pageItems) {
            System.out.println(pageItem);
        }
    }
    @Test
    public void getTotalRowByName(){
        System.out.println(furnDAO.getTotalRowByName("沙发"));
    }

    @Test
    public void getPageItemsByName(){
        List<Furn> furns = furnDAO.getPageItemsByName(0, 3, "沙发");
        System.out.println(furns);
    }
}
