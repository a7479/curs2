package sky.pro.curs2;

import org.springframework.stereotype.Service;
import sky.pro.curs2.model.Question;

import java.util.Collection;

@Service
public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
