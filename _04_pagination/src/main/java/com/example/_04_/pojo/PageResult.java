package com.example._04_.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author shenjianeng
 * @date 2021/1/9
 */
@Data
public class PageResult<T> {
    private List<T> items;
    private int pageNo;
    private int pageSize;
    private int totalCount;
}
