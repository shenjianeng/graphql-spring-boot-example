package com.example._02_.resolver;

import com.example._02_.pojo.Author;
import com.example._02_.pojo.Book;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author shenjianeng
 * @date 2020/12/19
 */
@Slf4j
@Component
public class BookGraphQLResolver implements GraphQLResolver<Book> {

    public Author author(Book book) {
        log.info("book id :{} query author info", book.getId());
        Author author = new Author();
        author.setId(UUID.randomUUID());
        author.setName(String.format("我是[%s]的作者", book.getName()));
        return author;
    }
}
