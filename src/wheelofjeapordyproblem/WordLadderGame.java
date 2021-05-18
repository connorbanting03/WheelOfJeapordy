/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeapordyproblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Connor_Banting
 */
public class WordLadderGame {

    public WordLadderGame() {
    }

    /*
    ** This method run's the final jeopordy challange for the winning player only
     */
    public int runGame(String winPlayer, int p) {
        System.out.println("----------------------");
        System.out.println("Welcome " + winPlayer + " to final Jeapordy");
        System.out.println("This final jeapordy challange is called word ladder");
        System.out.println("Each word follows the last except, one letter of the previous word is changed");
        System.out.println("----------------------");
        Scanner s = new Scanner(System.in);
        ArrayList<String> wordLaddergen = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("WordLadder copy.txt"));
            String txt = br.readLine();
            while (txt != null) {
                wordLaddergen.add(txt);
                txt = br.readLine();

            }

        } catch (Exception ex) {

            System.out.println("Son of a biscuit (catch triggered in wordLadder)");
        }

        ArrayList<String> Prompts = new ArrayList<String>();
        ArrayList<String> Answers = new ArrayList<String>();

      //This loop splits the file read in into Prompts and expected answers
        for (int d = 0; d < wordLaddergen.size(); d++) {
            String[] split = wordLaddergen.get(d).split(";");
            Prompts.add(split[0]);
            Answers.add(split[1]);

        }
        String[] placeHolders = new String[Answers.size()];
        int LongestWord = 0;
        //This loop is for formatting purpopes, this will find the length of the longest word, and create placeHolders for the unanswered words
        for (int z = 0; z < Prompts.size(); z++) {

            if (Prompts.get(z).length() > LongestWord) {

                LongestWord = Prompts.get(z).length();
            }
            placeHolders[z] = "----";
        }
//This code fills spaces to make every prompt the same length. Ex "Travis Scott" being the longest word will change "Kai" to "Kai         "
        for (int w = 0; w < Prompts.size(); w++) {

            while (Prompts.get(w).length() < LongestWord) {

                Prompts.set(w, Prompts.get(w) + " ");

            }

        }
        //Defines the amount of lives you have and CorrectAnswers variable,
        int CorrectAnswers = 0;
        int Lives = 3;
        boolean didWin = false;
        boolean answerCorrect = false;
        String guess;
//This while loop will check for reasons to end the game. so if Lives is less than or equal to zero end or if CorrectAnswers == all the answers then end
        while (CorrectAnswers != Answers.size() && Lives > 0) {
            showScreen(Prompts, placeHolders);
            answerCorrect = false;
            System.out.println("--------------------");
            System.out.println("Drop a guess");
            System.out.println(Lives + " Lives left");
            System.out.println("--------------------");
            guess = s.nextLine();

            for (int y = 0; y < Answers.size(); y++) {

                if (guess.equalsIgnoreCase(Answers.get(y))) {
                    placeHolders[y] = guess;
                    Answers.set(y, "complicated code that you wont ever guess");
                    answerCorrect = true;
                    break;
                }

            }
            if (answerCorrect) {
                System.out.println("Correct");
                Lives = 3;
                CorrectAnswers++;
            } else {
                Lives--;
                System.out.println("Wrong " + Lives + " Lives remaining");
            }

        }

        showScreen(Prompts, placeHolders);
        return ((CorrectAnswers * 100) + p);

    }
/*
    ** Method inside WordLadderGame to show the Screen after every user guess, right or wrong
    */
    public static void showScreen(ArrayList<String> d, String[] y) {

        for (int i = 0; i < d.size(); i++) {

            System.out.println("------------------------------------------------");
            System.out.println("| " + d.get(i) + " | " + y[i] + " |");

        }

    }

}
