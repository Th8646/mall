package com.wpt.furns.dao;

import com.wpt.furns.entity.Furn;

import java.util.List;

/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 23:42
 */
public interface FurnDAO {
    //返回所有的家具信息集合，分页后续进行优化
    public List<Furn> queryFurns();
}
