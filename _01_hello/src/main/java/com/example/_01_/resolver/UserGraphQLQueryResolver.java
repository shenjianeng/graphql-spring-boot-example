package com.example._01_.resolver;

import com.example._01_.pojo.City;
import com.example._01_.pojo.User;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

/**
 * @author shenjianeng
 * @date 2020/12/16
 */
@Component
public class UserGraphQLQueryResolver implements GraphQLQueryResolver {

    public Collection<User> userList() {
        User user1 = new User();
        user1.setId(UUID.randomUUID());
        user1.setUsername("coder小黑");
        user1.setNickname("coder小黑没有昵称");
        user1.setCity(City.hangzhou);

        User user2 = new User();
        user2.setId(UUID.randomUUID());
        user2.setUsername("今晚打老虎");
        user2.setNickname("爱老虎油");
        user2.setCity(City.shanghai);
        return Arrays.asList(user1, user2);
    }
}
