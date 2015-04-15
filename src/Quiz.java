import java.io.Serializable;

/**
 * Created by digibrose on 13/04/2015.
 */
public interface Quiz extends Serializable {

    /**
     * adds a new quesion to the quiz
     * @param question
     */

    void addQuestion(Question question);

    /**
     * gets a question specified by the value of the int
     * @return Question question
     */

    Question getQuestion(int position);

    /**
     * Method to return the name of the quiz
     * @return
     */

    String getName();


}
