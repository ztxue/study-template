package com.example.blog.result;


import lombok.Getter;
import lombok.Setter;

/**
 * @author: sunping
 * @description: 分页类
 * @date: 2020/5/20
 */
@Getter
@Setter
public class PageBean {
    private Long pageSize = 10L;
    private Long currentPage = 1L;
    /**
     * 总条数
     */
    private Long allRows;
    /**
     * 总页数
     */
    private Long allPages;

    public PageBean() {

    }

    public PageBean(Long pageSize, Long allRows, Long currentPage) {
        if (pageSize == null) {
            pageSize = 10L;
        }
        if (currentPage == null) {
            currentPage = 1L;
        }
        if (currentPage == 0) {
            currentPage = 1L;
        }
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.allRows = allRows;
        this.allPages = allRows / pageSize;
        if (allRows % pageSize != 0) {
            this.allPages++;
        }
        if (currentPage > allPages) {
            this.currentPage = this.allPages;
        }
        if (currentPage <= 0) {
            this.currentPage = 1L;
        }
    }


}
