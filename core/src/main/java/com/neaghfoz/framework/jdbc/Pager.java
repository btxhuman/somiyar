package com.neaghfoz.framework.jdbc;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-7-29
 * Time: 上午8:37
 */
public class Pager<T> {
    private Integer currentPage;

    private Integer pageSize;

    private Integer totalRows; //总共有多少条数据

    private Integer totalPages; //总共有多少页

    private Collection<T> pageData; //存放列表数据

    public Pager() {
        super();
    }

    public <T> Pager(Integer currentPage, Integer pageSize) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public <T> Pager(String currentPage, Integer pageSize) {
        try {
            this.currentPage = Integer.valueOf(currentPage);
        } catch (Exception e) {
            this.currentPage = 1;
        }
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Collection getPageData() {
        return pageData;
    }

    public void setPageData(Collection pageData) {
        this.pageData = pageData;
    }
}
