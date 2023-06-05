package sky.pro.curs2;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.curs2.exception.QuestionStorageIsFullException;
import sky.pro.curs2.model.Question;
import sky.pro.curs2.service.ExaminerServiceImpl;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void beforeEach() {
        Mockito.when(questionService.getAll()).thenReturn(
                Set.of(new Question("вопрос1", "ответ1"),
                        new Question("вопрос2", "ответ2"),
                        new Question("вопрос3", "ответ3"),
                        new Question("вопрос4", "ответ4"),
                        new Question("вопрос5", "ответ5"),
                        new Question("вопрос6", "ответ6"),
                        new Question("вопрос7", "ответ7"),
                        new Question("вопрос8", "ответ8"),
                        new Question("вопрос9", "ответ9"),
                        new Question("вопрос10", "ответ10")));


    }


    @Test
    public void shouldThrowExceptionWhenStorageFull() {


        Assertions.assertThatExceptionOfType(QuestionStorageIsFullException.class)
                .isThrownBy(() -> out.getQuestions(11));
    }


}
