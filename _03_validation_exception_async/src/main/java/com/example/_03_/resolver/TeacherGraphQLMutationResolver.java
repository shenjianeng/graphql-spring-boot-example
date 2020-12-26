package com.example._03_.resolver;

import com.example._03_.pojo.Teacher;
import com.example._03_.pojo.TeacherInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @author shenjianeng
 * @date 2020/12/26
 */
@Validated
@Component
public class TeacherGraphQLMutationResolver implements GraphQLMutationResolver {

    public Teacher createTeacher(@Valid TeacherInput input) {
        Teacher teacher = new Teacher();
        teacher.setId(input.getId());
        teacher.setName(input.getName());
        teacher.setAge(input.getAge());
        return teacher;
    }
}