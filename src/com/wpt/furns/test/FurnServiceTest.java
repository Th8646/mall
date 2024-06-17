package com.wpt.furns.test;/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 23:59
 */

import com.wpt.furns.entity.Furn;
import com.wpt.furns.entity.Page;
import com.wpt.furns.service.FurnService;
import com.wpt.furns.service.impl.FurnServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.test
 * @className: FurnServiceTest
 * @author: wpt
 * @description: TODO
 * @date: 2024/3/30 23:59
 * @version: 1.0
 */
public class FurnServiceTest {

    private FurnService furnService = new FurnServiceImpl();

    @Test
    public void queryFurns() {
        List<Furn> furns = furnService.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }

    @Test
    public void add() {
        Furn furn = new Furn(3, "可爱的沙发--", "蚂蚁家居",
                new BigDecimal(999.99), 100, 10, "assets/images/product-image/default.jpg");
        furnService.addFurn(furn);
    }

    @Test
    public void del() {
        int i = furnService.deleteFurnById(44);
        System.out.println(i);
    }

    @Test
    public void queryFurnById() {
        Furn furn = furnService.queryFurnById(99);
        System.out.println(furn);
    }

    @Test
    public void updateFurn() {
        Furn furn = new Furn(3, "可爱的沙发", "蚂蚁家居",
                new BigDecimal(999.99), 100, 10, "assets/images/product-image/default.jpg");
        System.out.println(furnService.updateFurn(furn));
    }

    @Test
    public void page() {
        Page<Furn> page = furnService.page(1, 3);
        System.out.println("page = " + page);
    }

    @Test
    public void pageByName(){
        Page<Furn> furns = furnService.pageByName(2, 3, "沙发");
        System.out.println(furns);
    }

}
