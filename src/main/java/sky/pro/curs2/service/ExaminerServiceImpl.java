package sky.pro.curs2.service;

import org.springframework.stereotype.Service;
import sky.pro.curs2.ExaminerService;
import sky.pro.curs2.model.Question;
import sky.pro.curs2.QuestionService;
import sky.pro.curs2.exception.QuestionStorageIsFullException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class ExaminerServiceImpl implements ExaminerService {


    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if (amount>questionService.getAll().size()) {

            throw new QuestionStorageIsFullException();
        }

        return Stream.generate(questionService::getRandomQuestion)
                .distinct()
                .limit(amount)
                .collect(Collectors.toUnmodifiableSet());


    }
}
