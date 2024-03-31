package com.wpt.furns.test;/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 23:49
 */

import com.wpt.furns.dao.FurnDAO;
import com.wpt.furns.dao.impl.FurnDAOImpl;
import com.wpt.furns.entity.Furn;
import org.junit.jupiter.api.Test;

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
    public void queryFurn(){
        List<Furn> furns = furnDAO.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }
}
