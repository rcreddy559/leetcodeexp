package com.pros;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class StudentsMarksDemo {
    static Random random = new Random();
    static String[] subjects = { "Biology", "Chemistry", "English", "Geography", "Math", "History",
            "Computer Science" };
    static String[] names = { "Divija", "Jyothiesh", "Gnanasree", "Sohith", "Lakshmi" };

    static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            List<Subject> subject = new ArrayList<>();
            for (String s : subjects) {
                subject.add(new Subject(s, random.nextInt(61) + 40));
            }
            students.add(new Student(names[i], subject));
        }
        System.out.println(students);
        return students;
    }

    static void print(List<Student> students) {
        for (Student student : students) {
            System.out.println("Name: "+student.getName());
            for (Subject subject : student.getSubjects()) {
                if(subject.equals(subject))
                System.out.printf("%s:%d\n", subject.getSubjectName(), subject.getSubjectMarks());
            }
            System.out.println("--------------------");
        }
    }
    
    static void findMax(List<Student> students) {
    
       Optional<Student> maxMathStudent = students.stream()
               .max(Comparator.comparingInt(std -> std.getSubjects()
                            .stream().filter(sub -> sub.getSubjectName().equals("Math"))
                            .findFirst().get().getSubjectMarks()));
                            
       System.out.println("============  Student who has max marks in Math subject============");
        
        maxMathStudent.ifPresentOrElse(s -> {
           System.out.println(s.getName());
           s.getSubjects().forEach(sub -> {
            System.out.println(sub.getSubjectName()+" : "+sub.getSubjectMarks());
           });
        }, ()-> System.out.println("No Studnet has Math subject"));
   }
    
    public static void main(String[] args) {
        List<Student> students = getStudents();
        print(students);
        findMax(students);
    }
}

@Setter
@Getter
@AllArgsConstructor
class Student {
    private String name;
    private List<Subject> subjects;
}

@Setter
@Getter
@AllArgsConstructor
class Subject {
    private String subjectName;
    private Integer subjectMarks;
}