package com.wpt.furns.test;/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 23:59
 */

import com.wpt.furns.entity.Furn;
import com.wpt.furns.service.FurnService;
import com.wpt.furns.service.impl.FurnServiceImpl;
import org.junit.jupiter.api.Test;

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
    public void queryFurns(){
        List<Furn> furns = furnService.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }
}
