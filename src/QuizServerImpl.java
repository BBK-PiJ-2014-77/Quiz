import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by digibrose on 15/04/2015.
 */
public class QuizServerImpl extends UnicastRemoteObject implements QuizServer {

    private List<Quiz> QuizList = new LinkedList<Quiz>();

    public QuizServerImpl() throws RemoteException {
    }

    @Override
    public List getQuizzes() {
        return null;
    }

    @Override
    public Quiz launchQuiz(int QuizNumber) {
        Quiz retQuiz = QuizList.get(QuizNumber);
        return retQuiz;
    }

    @Override
    public void setQuiz(Quiz NewQuiz) {

        QuizList.add(NewQuiz);

    }

    @Override
    public Player endQuiz(int QuizNumber) {
        return null;
    }

    @Override
    public void setPlayer(Player newPlayer) {

    }
}
