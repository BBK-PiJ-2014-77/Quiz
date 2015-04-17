package Implementations;

import Interfaces.Question;
import Interfaces.Quiz;

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
        QuestionList.add(question);
    }

    @Override
    public Question getQuestion(int position) {
        return QuestionList.get(position);
    }

    @Override
    public String getName() {
        return Quizname;
    }

    @Override
    public int returnQuestionNumber() {
        return QuestionList.size();
    }
}
