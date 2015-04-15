import java.util.LinkedList;
import java.util.List;

/**
 * Created by digibrose on 15/04/2015.
 */
public class QuizImpl implements Quiz {

    List<Question> QuestionList = new LinkedList<Question>();
    String Quizname = null;

    public QuizImpl(String name){

        Quizname = name;

    }

    @Override
    public void addQuestion(Question question) {

    }

    @Override
    public Question getQuestion(int position) {
        return null;
    }

    @Override
    public String getName() {
        return Quizname;
    }
}
