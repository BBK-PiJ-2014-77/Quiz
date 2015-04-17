package Implementations;

import Interfaces.PlayerClient;
import Interfaces.QuizServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by digibrose on 15/04/2015.
 */
public class PlayerClientLauncher{



    public static void main(String[] args) {

        launch(args);

    }


    private static void launch(String[] args) {

        Remote service = null;

        try{
            service = Naming.lookup("//localhost:1099/Interfaces.Quiz");
        } catch (NotBoundException e){
            e.printStackTrace();
            System.out.println("1");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("2");
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("3");
        }
        QuizServer QuizService = (QuizServer) service;

        try{
            int NumberofQuizzes =  QuizService.getQuizzes().size();
            List<QuizImpl> retrievedquizzes = (List<QuizImpl>) QuizService.getQuizzes();
            for (int i = 0; i < NumberofQuizzes; i++) {
                System.out.println(retrievedquizzes.get(i).getName());
            }
        } catch (RemoteException e){
            e.printStackTrace();
            System.out.println("1");
        }


    }
}
