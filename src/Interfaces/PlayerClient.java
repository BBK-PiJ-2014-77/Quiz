package Interfaces;

/**
 * Class to act as the player client
 */
public interface PlayerClient {

    /**
     * Method to get the list of quizzes
     */

    void GetQuizzes(QuizServer QuizService);

/**
 * Gets the quiz and allows player to play it then returns the score
 */

    int PlayQuiz(Quiz ChosenQuiz);


}
