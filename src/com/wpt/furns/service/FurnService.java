package com.wpt.furns.service;

import com.wpt.furns.entity.Furn;

import java.util.List;

/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 23:55
 */
public interface FurnService {
    public List<Furn> queryFurns();

    public int addFurn(Furn furn);
    public int deleteFurnById(int id);
}
