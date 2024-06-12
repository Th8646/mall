package com.wpt.furns.service.impl;/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 23:57
 */

import com.wpt.furns.dao.BasicDAO;
import com.wpt.furns.dao.FurnDAO;
import com.wpt.furns.dao.impl.FurnDAOImpl;
import com.wpt.furns.entity.Furn;
import com.wpt.furns.entity.Page;
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

    @Override
    public int addFurn(Furn furn) {
        return furnDAO.addFurn(furn);
    }

    @Override
    public int deleteFurnById(int id) {
        return furnDAO.deleteFurnById(id);
    }

    @Override
    public Furn queryFurnById(int id) {
        return furnDAO.queryFurnById(id);
    }

    @Override
    public int updateFurn(Furn furn) {
        return furnDAO.updateFurn(furn);
    }

    @Override
    public Page<Furn> page(int pageNo, int pageSize) {
        //先创建page对象，根据实际情况填充属性
        Page<Furn> page = new Page<>();
//        public static final Integer PAGE_SIZE = 3;
//        private Integer pageNo;              // 显示第几页
//        private Integer pageSize = PAGE_SIZE;       // 每页显示几条记录
//        private Integer pageTotalCount;    // 共有多少页，需要计算得到
//        private Integer totalRow;         // 数据库中共有多少记录
//        private List<T> items;           // 表示当前页要显示的数据集合
//        private String url;             // 分页导航字符串

        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        int totalRow = furnDAO.getTotalRow();
        page.setTotalRow(totalRow);

        // pageTotalCount = 数据库总记录数 / pageSize 向上取整
        int pageTotalCount = totalRow / pageSize;
        if (totalRow % pageSize > 0) {
            pageTotalCount += 1;
        }
        page.setPageTotalCount(pageTotalCount);

        // 计算数据库查询的起始索引 begin
        int begin = (pageNo - 1) * pageSize;
        List<Furn> pageItems = furnDAO.getPageItems(begin, pageSize);
        page.setItems(pageItems);


        return page;

    }

}
