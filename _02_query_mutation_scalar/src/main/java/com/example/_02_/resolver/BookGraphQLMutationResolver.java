package com.example._02_.resolver;

import com.example._02_.pojo.Book;
import com.example._02_.pojo.BookInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author shenjianeng
 * @date 2020/12/19
 */
@Component
public class BookGraphQLMutationResolver implements GraphQLMutationResolver {

    public Book createBook(int id, String name, Date createTime) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setCreateTime(createTime);
        return book;
    }


    public Book create(BookInput input) {
        Book book = new Book();
        book.setId(input.getId());
        book.setName(input.getName());
        return book;
    }
}
