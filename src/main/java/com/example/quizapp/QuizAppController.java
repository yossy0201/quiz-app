package com.example.quizapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizAppController {
    // クラス Quiz
    private List<Quiz> quizzes = new ArrayList<>();
    private QuizFileDao quizFileDao = new QuizFileDao();


    @GetMapping("/show")
    public List<Quiz> show() {
        return quizzes;
    }

    @PostMapping("/create")
    public void create(@RequestParam String question, @RequestParam boolean answer) {
        Quiz quiz = new Quiz(question, answer);
        quizzes.add(quiz);
    }
    @GetMapping("/check")
    public String check(@RequestParam String  question, @RequestParam boolean answer) {
     //   回答が正しいかどうかチェックして、結果を返却する
        for (Quiz quiz: quizzes) {
            //もしクイズが見つかったら
            if (quiz.getQuestion().equals(question)) {
                // 登録されているanswerと回答として渡ってきたanswerが一致している場合、正解と返却する
                if (quiz.isAnswer() == answer) {
                    //正解と返却する
                    return  "正解 ! ";
                } else {
                    //もし一致していなければ不正解と返却する
                    return "不正解 !";
                }
            }
        }
        //クイズが見つからない場合は、問題がありませんと返却する
        return "問題がありません";
    }

    @PostMapping("/save")
    public String save() {
        try {
            quizFileDao.write(quizzes);
            return "ファイルに保存しました";
        } catch (IOException e) {
            e.printStackTrace();
            return "ファイルの保存に失敗しました";
        }
    }
}

