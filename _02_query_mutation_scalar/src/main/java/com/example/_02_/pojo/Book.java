package com.example._02_.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author shenjianeng
 * @date 2020/12/19
 */
@Data
public class Book {
    private int id;
    private String name;
    private Long totalPageSize = Long.MAX_VALUE;
    private Date createTime;
}
