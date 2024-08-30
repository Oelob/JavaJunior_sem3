package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        File rep = new File("/Users/chernykh/IdeaProjects/JavaJunior/JavaJunior_sem4/src/main/java/org/example/rep");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Oleg", 43, 4.5));
        students.add(new Student("Igor", 22, 3.0));
        students.add(new Student("Ivan", 21, 5.0));

        saveStudent(rep, students);
        readStudent(rep);
    }

    public static void saveStudent (File path, List<Student> students) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(new File(path.toURI()), students);
    }

    public static void readStudent(File path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Student> students = objectMapper.readValue(path, objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
        System.out.println(students);
    }

}