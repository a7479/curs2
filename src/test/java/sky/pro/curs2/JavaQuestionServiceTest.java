package sky.pro.curs2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.curs2.model.Question;
import sky.pro.curs2.service.JavaQuestionService;

public class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();


    @BeforeEach
    public void beforeEach() {

        out.add("вопрос11", "ответ11");
        out.add("вопрос12", "ответ12");
        out.add("вопрос13", "ответ13");
    }


    @Test
    public void addTest() {

        int beforeCount = out.getAll().size();
        Question expected = new Question("вопрос14", "ответ14");
        Assertions.assertEquals(expected, out.add("вопрос14", "ответ14"));
        Assertions.assertEquals(beforeCount + 1, out.getAll().size());


    }

    @Test
    public void removeTest() {

        int beforeCount = out.getAll().size();
        Question expected = new Question("вопрос13", "ответ13");
        Assertions.assertEquals(expected, out.remove("вопрос13", "ответ13"));
        Assertions.assertEquals(beforeCount - 1, out.getAll().size());


    }

    @Test

    public void getAllTest() {
        Question expected = new Question("вопрос7", "ответ7");

        Assertions.assertEquals(13, out.getAll().size());
        Assertions.assertEquals(expected,new Question("вопрос7", "ответ7"));
    }

}
