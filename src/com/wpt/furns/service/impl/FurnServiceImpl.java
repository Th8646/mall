package com.wpt.furns.service.impl;/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 23:57
 */

import com.wpt.furns.dao.BasicDAO;
import com.wpt.furns.dao.FurnDAO;
import com.wpt.furns.dao.impl.FurnDAOImpl;
import com.wpt.furns.entity.Furn;
import com.wpt.furns.service.FurnService;

import java.util.List;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.service.impl
 * @className: FurnServiceImpl
 * @author: wpt
 * @description: TODO
 * @date: 2024/3/30 23:57
 * @version: 1.0
 */
public class FurnServiceImpl implements FurnService {
    private FurnDAO furnDAO = new FurnDAOImpl();
    @Override
    public List<Furn> queryFurns() {
       return furnDAO.queryFurns();
    }
}
