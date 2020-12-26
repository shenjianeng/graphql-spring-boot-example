package com.example._03_.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.kickstart.spring.error.ErrorContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * @author shenjianeng
 * @date 2020/12/26
 */
@Component
public class CustomExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public GraphQLError constraintViolationExceptionHandler(ConstraintViolationException ex, ErrorContext ctx) {
        return GraphqlErrorBuilder.newError()
                .message(ex.getMessage())
                .locations(ctx.getLocations())
                .path(ctx.getPath())
                .build();
    }
}
