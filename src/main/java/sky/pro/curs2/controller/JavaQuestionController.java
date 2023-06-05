package sky.pro.curs2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.curs2.model.Question;
import sky.pro.curs2.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")

public class JavaQuestionController {


    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;

    }

    @GetMapping("/java/add")
    public Question addQuestion(String question, String answer) {
        return questionService.add(question,answer);
    }

    @GetMapping("/java")
    public Collection<Question> getQuestion() {
        return questionService.getAll();
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(String question, String answer) {
        return questionService.remove(question,answer);
    }


}


