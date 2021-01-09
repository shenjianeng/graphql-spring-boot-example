package com.example._04_.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author shenjianeng
 * @date 2021/1/9
 */
@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

}
