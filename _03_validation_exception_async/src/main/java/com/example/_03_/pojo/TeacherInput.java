package com.example._03_.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

/**
 * @author shenjianeng
 * @date 2020/12/26
 */
@Data
public class TeacherInput {

    @Min(value = 1, message = "id错误")
    private int id;

    @Length(min = 2, max = 10, message = "名称过长")
    private String name;

    @Range(min = 1, max = 100, message = "年龄不正确")
    private int age;
}
