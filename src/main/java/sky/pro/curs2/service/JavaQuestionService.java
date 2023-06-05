package sky.pro.curs2.service;

import org.springframework.stereotype.Service;
import sky.pro.curs2.model.Question;
import sky.pro.curs2.QuestionService;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService {


    private final Set <Question> questions = new HashSet<>();

    public JavaQuestionService() {

        questions.add(new Question("вопрос1","ответ1"));
        questions.add(new Question("вопрос2","ответ2"));
        questions.add(new Question("вопрос3","ответ3"));
        questions.add(new Question("вопрос4","ответ4"));
        questions.add(new Question("вопрос5","ответ5"));
        questions.add(new Question("вопрос6","ответ6"));
        questions.add(new Question("вопрос7","ответ7"));
        questions.add(new Question("вопрос8","ответ8"));
        questions.add(new Question("вопрос9","ответ9"));
        questions.add(new Question("вопрос10","ответ10"));

    }

    @Override
    public Question add(String question, String answer) {

        Question temp=new Question(question,answer);

        questions.add(temp);

        return temp;
    }


    @Override
    public Question remove(String question, String answer) {

        Question temp=new Question(question,answer);

        questions.remove(temp);

        return temp;

    }

    @Override
    public Collection<Question> getAll() {

        return Collections.unmodifiableSet (questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return getAll().stream()
                .skip(random.nextInt(getAll().size()))
                .findFirst()
                .orElseThrow();



        }
}
