package com.example._01_;

import com.example._01_.pojo.City;
import com.example._01_.pojo.User;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class HelloWorld {

    static Collection<User> userList() {
        User user1 = new User();
        user1.setId(UUID.randomUUID());
        user1.setUsername("coder小黑");
        user1.setNickname("coder小黑没有昵称");
        user1.setCity(City.hangzhou);
        return Collections.singletonList(user1);
    }

    public static void main(String[] args) throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:schema.graphqls");
        String schema = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        RuntimeWiring runtimeWiring =
                RuntimeWiring.newRuntimeWiring()
                        .type(TypeRuntimeWiring
                                .newTypeWiring("Query")
                                .dataFetcher("userList",
                                        (DataFetcher<Collection<User>>) environment -> userList()))
                        .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = build.execute("query{\n" +
                "  userList{\n" +
                "    id\n" +
                "    username\n" +
                "  }\n" +
                "}");

        // {userList=[{id=486a181e-eec7-4001-a9d9-65e94a004f8c, username=coder小黑}]}
        System.out.println(executionResult.getData().toString());
    }
}