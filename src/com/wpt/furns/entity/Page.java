package com.wpt.furns.entity;/**
 * @author wpt@onlying.cn
 * @date 2024/4/22 20:06
 */

import java.util.List;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.entity
 * @className: Page
 * @author: wpt
 * @description: 分页数据模型，包含分页显示相关的各种信息
 * @date: 2024/4/22 20:06
 * @version: 1.0
 */
public class Page<T> {// 分页模型对应的数据不确定，使用泛型
    public static final Integer PAGE_SIZE = 4;
    private Integer pageNo;              // 显示第几页
    private Integer pageSize = PAGE_SIZE;       // 每页显示几条记录
    private Integer pageTotalCount;    // 共有多少页，需要计算得到
    private Integer totalRow;         // 数据库中共有多少记
    // 录
    private List<T> items;           // 表示当前页要显示的数据集合
    private String url;             // 分页导航字符串

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
