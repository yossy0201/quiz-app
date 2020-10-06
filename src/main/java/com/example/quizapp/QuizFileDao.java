package com.example.quizapp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//Dao・・・Data access object
public class QuizFileDao {

    private  static final String File_PATH = "quizzes.txt";

    public void write(List<Quiz> quizzes) {

        Path path = Paths.get(File_PATH)
        Files.write(path, );
    }
}
