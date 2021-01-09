package com.example._04_.resolver;

import com.example._04_.pojo.PageResult;
import com.example._04_.pojo.Student;
import com.example._04_.repository.StudentRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shenjianeng
 * @date 2020/12/19
 */
@Component
@RequiredArgsConstructor
public class StudentGraphQLQueryResolver implements GraphQLQueryResolver {

    private final StudentRepository studentRepository;


    public PageResult<Student> findAll(int pageNo, int pageSize) {
        Page<Student> page = studentRepository.findAll(PageRequest.of(pageNo - 1, pageSize));
        PageResult<Student> pageResult = new PageResult<>();
        pageResult.setItems(page.getContent());
        pageResult.setPageNo(pageNo);
        pageResult.setPageSize(page.getSize());
        pageResult.setTotalCount((int) page.getTotalElements());
        return pageResult;
    }

    public Connection<Student> students(int first, String after) {
        String afterToUsed = StringUtils.defaultIfEmpty(after, "0");

        Integer minId = studentRepository.findMinId();
        Integer maxId = studentRepository.findMaxId();

        // 从 after 游标开始,取 first 个数据
        // 这里故意取 first + 1 个数,用来判断是否还有下一页数据
        List<Student> students =
                studentRepository.findByIdGreaterThan(Integer.valueOf(afterToUsed), PageRequest.of(0, first + 1));

        List<Edge<Student>> edges = students.stream()
                .limit(first)
                .map(student -> new DefaultEdge<>(student, new DefaultConnectionCursor(String.valueOf(student.getId()))))
                .collect(Collectors.toList());

        PageInfo pageInfo =
                new DefaultPageInfo(
                        new DefaultConnectionCursor(String.valueOf(minId)),
                        new DefaultConnectionCursor(String.valueOf(maxId)),
                        Integer.parseInt(afterToUsed) > minId,
                        students.size() > first);

        return new DefaultConnection<>(edges, pageInfo);
    }
}
