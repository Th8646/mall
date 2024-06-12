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

    @Override
    public int addFurn(Furn furn) {
        String sql = "INSERT INTO furn(`id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path`) " +
                "VALUES(NULL, ?, ?, ?, ?, ?, ?)";
        return update(sql, furn.getName(), furn.getMaker(),
                furn.getPrice(), furn.getSales(), furn.getSales(), furn.getImgPath());
    }

    @Override
    public int deleteFurnById(int id) {
        String sql = "DELETE FROM furn WHERE id = ?";
        return update(sql, id);
    }

    @Override
    public Furn queryFurnById(int id) {
        String sql = "SELECT `id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path` imgPath FROM furn WHERE id=?";
        return querySingle(sql, Furn.class, id);
    }

    @Override
    public int getTotalRow() {
        String sql = "SELECT COUNT(*) FROM `furn`";
        return ((Number) queryScalar(sql)).intValue();
    }

    @Override
    public List<Furn> getPageItems(int begin, int pageSize) {
        String sql = "SELECT `id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path` imgPath " +
                "FROM furn limit ?,?";
        return queryMulti(sql, Furn.class, begin, pageSize);
    }

    @Override
    public int updateFurn(Furn furn) {
        String sql = "UPDATE `furn` SET `name` = ? , `maker` = ?, `price` = ? , " +
                "`sales` = ? , `stock` = ? , `img_path` = ? " +
                "WHERE id = ? ";
        return update(sql, furn.getName(), furn.getMaker(), furn.getPrice(),
                furn.getSales(), furn.getStock(), furn.getImgPath(), furn.getId());
    }


}
