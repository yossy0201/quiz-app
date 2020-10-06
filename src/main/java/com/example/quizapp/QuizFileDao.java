package com.example.quizapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//Dao・・・Data access object
public class QuizFileDao {

    private  static final String File_PATH = "quizzes.txt";

    public void write(List<Quiz> quizzes) throws IOException {
    List<String> lines = new ArrayList<>();
    for (Quiz quiz: quizzes) {
        lines.add(quiz.toString());
    }

        Path path = Paths.get(File_PATH);
        // 第一引数path・・・書き込み先のファイルパス(場所)
        // 第二引数line・・・書き込むデータ List<String>
        Files.write(path, lines);
    }
}
