package com.wpt.furns.dao;

import com.wpt.furns.entity.Furn;

import java.util.List;

/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 23:42
 */
public interface FurnDAO {
    // 返回所有的家具信息集合，分页后续进行优化
    public List<Furn> queryFurns();

    public int addFurn(Furn furn);

    /**
     * 根据id删除db中对应的家居
     *
     * @param id
     * @return 受影响的行数
     */
    public int deleteFurnById(int id);

    public Furn queryFurnById(int id);

    // page的那些属性是可以直接从数据库直接获取的，就把相关任务放在DAO层
    public int getTotalRow();

    /**
     * 根据传入的begin和PageSize，返回对应的Page对象
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Furn> getPageItems(int begin, int pageSize);

    /**
     * 将传入的furn对象，更新到数据库，根据id
     * @param furn
     * @return
     */
    public int updateFurn(Furn furn);
    // 处理Page模型中可以直接从数据库获取的属性

    public int  getTotalRowByName(String name);

    /**
     * 根据begin，pageSize和名字获取要显示的家居信息
     * @param begin
     * @param pageSize
     * @param name
     * @return
     */
    public List<Furn> getPageItemsByName(int begin, int pageSize,String name);
}
