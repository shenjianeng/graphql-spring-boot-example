//package com.example._04_;
//
//import com.example._04_.pojo.Student;
//import graphql.relay.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author shenjianeng
// * @date 2021/1/9
// */
//public class ConnectionDemo {
//
//
//    public static void main(String[] args) {
//        List<Student> students = createStudents();
//        List<Edge<Student>> edges = buildEdgeStudents(students);
//        PageInfo pageInfo = new DefaultPageInfo();
//        Connection<Student> connection = new DefaultConnection<>(edges, pageInfo);
//    }
//
//    static List<Student> createStudents() {
//        List<Student> students = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Student student = new Student();
//            student.setId(i);
//            student.setName("student-" + i);
//            students.add(student);
//        }
//        return students;
//    }
//
//    static List<Edge<Student>> buildEdgeStudents(List<Student> students) {
//        return students.stream()
//                .map(student -> new DefaultEdge<>(student, () -> String.valueOf(student.getId())))
//                .collect(Collectors.toList());
//    }
//}
