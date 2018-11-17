package com.telran;

import com.telran.model.Student;
import com.telran.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        //1. Entity lifecycle
        //2. Flush mode

        //Transient

        //1
        Student student = new Student();
        student.setName("David");

        //Managed
        studentRepository.save(student);

        //1 -> to SQL

        //student.id = 1

        //2
        student.setName("John");

        studentRepository.flush();
        //2 -> SQL

        //Removed
        //3
        studentRepository.delete(student);

        //Synchronize entity with ITS database record (row)
        studentRepository.flush();
        //3 -> SQL

        System.out.println();

    }
}
