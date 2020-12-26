package com.example._03_.exception;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author shenjianeng
 * @date 2020/12/26
 */
@Slf4j
@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        log.info("Handle errors: {}", errors);
        return Collections.singletonList(new GenericGraphQLError("出异常了..."));
    }
}
