package com.example._02_.resolver;

import com.example._02_.pojo.Book;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

/**
 * @author shenjianeng
 * @date 2020/12/19
 */
@Component
public class BookGraphQLQueryResolver implements GraphQLQueryResolver {

    public DataFetcherResult<Book> getBookById(int id) {
        if (id <= 0) {
            return DataFetcherResult
                    .<Book>newResult()
                    .error(new GenericGraphQLError("id 不能为负数"))
                    .build();
        }

        Book book = new Book();
        book.setId(id);
        book.setName("这边书没有书名");
        return DataFetcherResult
                .<Book>newResult()
                .data(book)
                .build();
    }
}
