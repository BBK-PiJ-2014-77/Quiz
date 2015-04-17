package Implementations;

import Interfaces.SetupClient;

import java.util.Scanner;

/**
 * Created by digibrose on 15/04/2015.
 */
public class SetupClientLauncher {

    public static void main(String[] args) {

        launch();

    }


    public static void launch() {

        SetupClient NewClient = new SetupClientImpl();

        System.out.println("What do you want to do? A to add quiz, E to end quiz");
        Scanner in = new Scanner(System.in);
        String What = in.nextLine();

        if (What.charAt(0) == 'A'){
            NewClient.addQuiz();
        }
        if (What.charAt(0) == 'E'){
            NewClient.endQuiz();
        }
    }
}
