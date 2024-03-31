package com.wpt.furns.dao.impl;/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 23:43
 */

import com.wpt.furns.dao.BasicDAO;
import com.wpt.furns.dao.FurnDAO;
import com.wpt.furns.entity.Furn;

import java.util.List;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.dao.impl
 * @className: FurnDAOImpl
 * @author: wpt
 * @description: TODO
 * @date: 2024/3/30 23:43
 * @version: 1.0
 */
public class FurnDAOImpl extends BasicDAO<Furn> implements FurnDAO {

    @Override
    public List<Furn> queryFurns() {
        String sql = "SELECT `id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path` imgPath FROM furn";
        return queryMulti(sql, Furn.class);
    }
}
