package com.example._01_.pojo;

import lombok.Data;

import java.util.UUID;

/**
 * @author shenjianeng
 * @date 2020/12/17
 */
@Data
public class User {
    private UUID id;
    private String username;
    private String nickname;
    private City city;
}
