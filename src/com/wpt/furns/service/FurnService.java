package com.wpt.furns.service;

import com.wpt.furns.entity.Furn;
import com.wpt.furns.entity.Page;

import java.util.List;

/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 23:55
 */
public interface FurnService {
    public List<Furn> queryFurns();

    public int addFurn(Furn furn);

    public int deleteFurnById(int id);

    public Furn queryFurnById(int id);

    /**
     * 根据传入的Furn对象进行修改
     *
     * @param furn
     * @return
     */
    public int updateFurn(Furn furn);

    /**
     * 根据传入的begin 和 pageSize返回对应的Page对象
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Furn> page(int pageNo, int pageSize);

    /**
     * 根据传入的 pageNo 和 pageSize/name返回对应的Page对象
     * @param pageNo
     * @param pageSize
     * @param name
     * @return
     */
    public Page<Furn> pageByName(int pageNo, int pageSize,String name);
}
