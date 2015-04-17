package Implementations;

import Interfaces.Question;

/**
 * Created by digibrose on 15/04/2015.
 */
public class QuestionImpl implements Question {

    String Quest = null;
    String[] Answers = null;
    int Correct;

    @Override
    public String getQuestion() {
        return Quest;
    }

    @Override
    public String[] getAnswers() {
        return Answers;
    }

    @Override
    public int CorrectValue() {
        return Correct;
    }

    @Override
    public void addQuestion(String Question) {
        Quest = Question;
    }

    @Override
    public void addAnswers(String[] Answers, int correct) {
        this.Answers = Answers;
        this.Correct = correct;
    }
}
