/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeapordyproblem;

import java.io.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Connor_Banting
 */
public class WheelOfJeapordyProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//calls hostCreatorClass constutor to create the host, with parameters of String and int
        hostCreatorClass host1 = new hostCreatorClass("Tony", 1);
        //This calls the rIntroduction method inside the hostCreatorClass file
        System.out.println(host1.rIntroduction());
        Scanner s = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Would you like to enable grader mode?");
        System.out.println("This will allow you to type I after a question is asked and it will spit out the correct answer, say yes or any word that contains y");
        System.out.println("------------------");
        String gradermodeAsk = s.nextLine();
        boolean graderMode = false;
        if (gradermodeAsk.contains("y") || gradermodeAsk.contains("Y")) {
            graderMode = true;

        }
        System.out.println("What score would you like to play too, type a number , for reference the wheel can land on 100-1000");

        int winCount = Integer.parseInt(s.nextLine());

        ArrayList<String> questions = new ArrayList<String>();

        questions = fileRead();
        ArrayList<String> backUpQuestions = questions;
        Wheel mainWheel = new Wheel(12);
        System.out.println("------------------");

        System.out.println("How many player's are there?");
        int playerAmount = Integer.parseInt(s.nextLine());
        boolean onePlayerMode = false;
        boolean twoPlayerMode = false;
        boolean threePlayerMode = false;
        boolean fourPlayerMode = false;
        boolean playerCheck = true;
        boolean turnLost = false;
        String player2name = "";
        String player3name = "";
        String player4name = "";
        String player1name = "";
        ArrayList<String> playerNameHolder = new ArrayList<String>();
        ArrayList<PlayerMaker> playerHolder = new ArrayList<PlayerMaker>();
        while (playerCheck) {
            {
                if (playerAmount >= 1 && playerAmount <= 4) {

                    if (playerAmount == 1) {
                        System.out.println("What's Player 1's name");
                        player1name = s.nextLine();
                        player2name = "";
                        player3name = "";
                        player4name = "";
                        playerNameHolder.add(player1name);

                        onePlayerMode = true;
                    } else if (playerAmount == 2) {
                        System.out.println("What's Player 1's name");
                        player1name = s.nextLine();
                        System.out.println("What's Player 2's name");
                        player2name = s.nextLine();
                        playerNameHolder.add(player1name);
                        playerNameHolder.add(player2name);
                        player3name = "";
                        player4name = "";

                        twoPlayerMode = true;
                    } else if (playerAmount == 3) {
                        System.out.println("What's Player 1's name");
                        player1name = s.nextLine();
                        System.out.println("What's Player 2's name");
                        player2name = s.nextLine();
                        System.out.println("What's Player 3's name");
                        player3name = s.nextLine();
                        playerNameHolder.add(player1name);
                        playerNameHolder.add(player2name);
                        playerNameHolder.add(player3name);
                        player4name = "";
                        threePlayerMode = true;

                    } else if (playerAmount == 4) {
                        System.out.println("What's Player 1's name");
                        player1name = s.nextLine();
                        System.out.println("What's Player 2's name");
                        player2name = s.nextLine();
                        System.out.println("What's Player 3's name");
                        player3name = s.nextLine();
                        System.out.println("What's Player 4's name");
                        player4name = s.nextLine();
                        playerNameHolder.add(player1name);
                        playerNameHolder.add(player2name);
                        playerNameHolder.add(player3name);
                        playerNameHolder.add(player4name);

                        fourPlayerMode = true;
                    }
                    playerCheck = false;
                } else {
                    System.out.println("Invalid Entry, try agian How many player's are there?");

                    playerAmount = Integer.parseInt(s.nextLine());

                }
                PlayerMaker Player1 = new PlayerMaker(player1name);
                PlayerMaker Player2 = new PlayerMaker(player2name);
                PlayerMaker Player3 = new PlayerMaker(player3name);
                PlayerMaker Player4 = new PlayerMaker(player4name);

                for (int q = 0; q < playerNameHolder.size(); q++) {

                    if (q == 0) {
                        playerHolder.add(Player1);
                    } else if (q == 1) {
                        playerHolder.add(Player2);
                    } else if (q == 2) {
                        playerHolder.add(Player3);
                    } else if (q == 3) {
                        playerHolder.add(Player4);

                    }
                }

            }
        }
        boolean[] modeCheck = {onePlayerMode, twoPlayerMode, threePlayerMode, fourPlayerMode};

        int highestScore = 0;
        int keepTrackofTurn = 1;
        //runs main game
        while (highestScore < winCount) {

            if (questions.size() <= 1) {
                questions = backUpQuestions;
            }

            getTurn(keepTrackofTurn, playerHolder);
//this arraylist will hold all the questions that will be printed
            Collections.shuffle(questions);

            //Using recursion to check if i messed up writing the files
            questions = mistakecheck(questions);

            String splitFunction = questions.get(0);
            //this array will always have the same length, because I am reading in the questions
            //this means i can read define the strings with objectCreator at it's exact index without worrying about array out of bounds index errors
            String objectCreator[] = splitFunction.split(";");
            questions.remove(0);
            String Category1 = objectCreator[0];
            String Question1 = objectCreator[1];
            String Answer1 = objectCreator[2];
            String WrongAnswer11 = objectCreator[3];
            String WrongAnswer12 = objectCreator[4];
            String WrongAnswer13 = objectCreator[5];
            String rightansweridenification = objectCreator[6];
            //Creation of cQuestion method
            WOJobjectmaker cQuestion = new WOJobjectmaker(Category1, Question1, Answer1, WrongAnswer11, WrongAnswer12, WrongAnswer13, rightansweridenification);
            //int d will pick a number between 0-3, this will determine the order Answer1 and WrongAnswer1-3 will be displayed
            //int d is not definded twice because i have a function q, that will reprint the questions
            //if I define d from 0-3 in the method is will rewrite the answers in a different order
            int d = (int) (Math.random() * 4);

            System.out.println("Tony:Type S to spin the wheel");
            while (!(s.nextLine().toLowerCase().equals("s"))) {
                System.out.println("Tony:Type S to spin the wheel");
                String placeHolder = s.nextLine();
            }
            int wheelResult = mainWheel.wheelSpin();
//if WheelResult lands on 1100 or 1200 that computer will bankrupt the user that called on it or double there next question
            if (wheelResult == 1100) {
                System.out.println("------------------");
                System.out.println(host1.hostBankruptComment());
                System.out.println("------------------");
                if (playerHolder.get(keepTrackofTurn - 1).getMoney() >= 0) {
                    playerHolder.get(keepTrackofTurn - 1).setMoney(0);
                } else {
                    System.out.println("Tony: Your score is below zero, so nothing will change");
                }
                System.out.println("Tony:I do feel bad, so I will spin it agian for you");

                while (wheelResult == 1100) {
                    wheelResult = mainWheel.wheelSpin();
                    System.out.println("Tony:The wheel landed on " + wheelResult);
                }

            } else if (wheelResult == 1200) {
                System.out.println(host1.timesTwoComment());
                wheelResult = mainWheel.wheelSpin();
                System.out.println("Tony:The wheel landed on " + wheelResult);
                System.out.println("Tony:Your next question is now worth " + (2 * wheelResult));
                wheelResult *= 2;
            } else {
                System.out.println("Tony:The wheel landed on " + wheelResult);
            }

            //This is the sequence that allows you to answer and checks if your right or not
            if (!turnLost) {
                System.out.println(host1.rQuestion());
                cQuestion.askQuestion(d);
                String answer = s.nextLine();
                while (!(answer.toUpperCase().equals("A") || answer.toUpperCase().equals("B") || answer.toUpperCase().equals("C") || answer.toUpperCase().equals("D"))) {
                    if (answer.equalsIgnoreCase("I") && graderMode) {
                        System.out.println(cQuestion.RightAns());
                        answer = s.nextLine();

                    } else {
                        System.out.println("Tony:Invalid Entry, try agian");
                        System.out.println("type Q to see question agian");
                        answer = s.nextLine();
                    }

                    if (answer.equalsIgnoreCase("Q")) {
                        cQuestion.askQuestion(d);
                        answer = s.nextLine();
                    }

                }

                if (answer.toUpperCase().equals(cQuestion.getanswerID())) {
                    System.out.println(host1.hostoResponce(true));
                    if (keepTrackofTurn == 1) {
                        playerHolder.get(0).setMoney(wheelResult);
                        keepTrackofTurn++;
                    } else if (keepTrackofTurn == 2) {
                        playerHolder.get(1).setMoney(wheelResult);
                        keepTrackofTurn++;
                    } else if (keepTrackofTurn == 3) {
                        playerHolder.get(2).setMoney(wheelResult);
                        keepTrackofTurn++;

                    } else if (keepTrackofTurn == 4) {
                        playerHolder.get(3).setMoney(wheelResult);
                        keepTrackofTurn++;
                    }

                } else {

                    System.out.println(host1.hostoResponce(false));
                    if (keepTrackofTurn == 1) {
                        playerHolder.get(0).setMoney(wheelResult * -1);
                        keepTrackofTurn++;
                    } else if (keepTrackofTurn == 2) {
                        playerHolder.get(1).setMoney(wheelResult * -1);
                        keepTrackofTurn++;
                    } else if (keepTrackofTurn == 3) {
                        playerHolder.get(2).setMoney(wheelResult * -1);
                        keepTrackofTurn++;

                    } else if (keepTrackofTurn == 4) {
                        playerHolder.get(3).setMoney(wheelResult * -1);
                        keepTrackofTurn++;
                    }
                }

                if (turnLost) {
                    keepTrackofTurn++;
                    turnLost = false;
                }

            }
            //this gets information for end of turn and all other stats
            String getNumbers = getNumbersneeded(playerHolder);

            String[] numbers = getNumbers.split(";");

            int[] numbers1 = new int[numbers.length];

            numbers1[0] = Integer.parseInt(numbers[0]);
            numbers1[1] = Integer.parseInt(numbers[1]);
            numbers1[2] = Integer.parseInt(numbers[2]);
            numbers1[3] = Integer.parseInt(numbers[3]);

            String findHighestVandID = getHighScore(playerHolder, modeCheck);
            String[] IDandVal = findHighestVandID.split(";");
            highestScore = Integer.parseInt(IDandVal[0]);
            String winPlayer = IDandVal[1];
            //Once everybody has gone in a turn the turnTracker is reset here and information about the round is shown
            keepTrackofTurn = endRound(keepTrackofTurn, modeCheck, playerHolder, winPlayer, highestScore);

        }
// Once somebody breaks the amount to win, getHighScore will figure out who do it and and send them to final jeopordy
        String findHighestVandID = getHighScore(playerHolder, modeCheck);
        String[] IDandVal = findHighestVandID.split(";");
        highestScore = Integer.parseInt(IDandVal[0]);
        String winPlayer = IDandVal[1];
        System.out.println("------------------");
        System.out.println("Congrats " + winPlayer + " You won with " + highestScore);
        System.out.println("------------------");
//This will initate the wordladder in a different class for struture reasons and because my main is big
        WordLadderGame d = new WordLadderGame();
//This sends the correct player and then adds the result to highestScore
        int returnWin = d.runGame(winPlayer, highestScore);
        highestScore += returnWin;
        //This writes to the records file the user that won and there score
        try {
            FileWriter fw = new FileWriter("Records.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(winPlayer + " " + highestScore);
            bw.close();

        } catch (Exception ex) {

            System.out.println("Catch triggered for fileWriter");
        }
        System.out.println(winPlayer + ", You won with " + highestScore + " check records file to see your score ");
        System.out.println("------------------");
        System.out.println("Would you like to see Records");
        System.out.println("------------------");
        String sortCall = s.nextLine();
//If user types yes than it will call this method to print out the top 5 all time scores
        if (sortCall.contains("y") || sortCall.contains("Y")) {
            highscoreFile();
        }

    }

    /*
**Method to check winningScore out of x people playing
     */
    public static String getHighScore(ArrayList<PlayerMaker> d, boolean[] x) {
        int[] trackHigh = new int[4];
        int highvReturn = d.get(0).getMoney();
        String playerWinning = "Player 1";
        for (int k = 0; k < trackHigh.length; k++) {
            if (k < d.size()) {
                trackHigh[k] = d.get(k).getMoney();
            } else {
                trackHigh[k] = 0;
            }

        }

        for (int t = 1; t < trackHigh.length; t++) {

            if (trackHigh[t] > highvReturn) {

                highvReturn = trackHigh[t];

            }

        }

        if (highvReturn == trackHigh[0]) {
            playerWinning = d.get(0).getName();
        }

        if (highvReturn == trackHigh[1] && (x[1] || x[2] || x[3])) {
            playerWinning = d.get(1).getName();
        }
        if (highvReturn == trackHigh[2] && (x[2] || x[3])) {
            playerWinning = d.get(2).getName();
        }
        if (highvReturn == trackHigh[3] && x[3]) {
            playerWinning = d.get(3).getName();
        }
        String bigReturn = Integer.toString(highvReturn) + ";" + playerWinning;

        return bigReturn;
    }

    /*
    ** Reads in files based on user input or randomly
     */
    public static ArrayList<String> fileRead() {
        Scanner d = new Scanner(System.in);
        ArrayList<Integer> selections = new ArrayList<Integer>();

        String[] options = {"Iron Man", "Thor", "SpiderMan", "Captain America", "Black Panther", "Wanda", "Luke Skywalker", "Anakin Skywalker", "General StarWars1", "General StarWars2"};
        String[] files = {"IronMan.txt", "Thor.txt", "SpiderMan.txt", "CaptainAmerica.txt", "BlackPanther.txt", "Wanda.txt", "Luke.txt", "Anakin.txt", "GeneralStarWars1.txt", "GeneralStarWars2.txt"};
        while (selections.size() != 6) {
            System.out.println("Select One Catogry or Click R for random");
            int CorresondingNumber = 0;
            for (String s : options) {

                System.out.println(CorresondingNumber + ": " + s);
                CorresondingNumber++;
            }
            String selection = d.nextLine();
            if (selection.equalsIgnoreCase("r")) {
                while (selections.size() != 6) {
                    int catagoryPick = (int) (Math.random() * 10);
                    int checker = 0;
                    for (int h : selections) {
                        if (h == catagoryPick) {

                            checker++;
                        }

                    }
                    if (checker == 0) {
                        selections.add(catagoryPick);
                    }

                }

            } else {
                if (Integer.parseInt(selection) < 10 && Integer.parseInt(selection) >= 0) {
                    selections.add(Integer.parseInt(selection));
                    options[Integer.parseInt(selection)] = "";

                }

            }

        }

        ArrayList<String> questions1 = new ArrayList<String>();
        for (Integer x : selections) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(files[x]));

                String txt = br.readLine();

                while (!(txt == null)) {
                    questions1.add(txt);

                    txt = br.readLine();

                }

            } catch (Exception ex) {
                System.out.println(files[x]);

            }
        }

        return questions1;

    }

    /*
    ** This counts the ";" to if theres enough and if theres not remvoe it and call on it agian
     */
    public static ArrayList<String> mistakecheck(ArrayList<String> s) {

        int commaCount = 0;
        char[] coloncommaChecker = s.get(0).toCharArray();

        for (char c : coloncommaChecker) {
            if (c == ';') {

                commaCount++;
            }

        }

        if (!(commaCount == 6)) {

            s.remove(0);

            mistakecheck(s);
        }

        return s;

    }

    public static String getNumbersneeded(ArrayList<PlayerMaker> d) {
        String returnWord = "";
        if (d.size() == 1) {
            returnWord += d.get(0).getMoney();
            returnWord += ";";
            returnWord += "0";
            returnWord += ";";
            returnWord += "0";
            returnWord += ";";
            returnWord += "0";
        } else if (d.size() == 2) {
            returnWord += d.get(0).getMoney();
            returnWord += ";";
            returnWord += d.get(1).getMoney();
            returnWord += ";";
            returnWord += "0";
            returnWord += ";";
            returnWord += "0";
        } else if (d.size() == 3) {
            returnWord += d.get(0).getMoney();
            returnWord += ";";
            returnWord += d.get(1).getMoney();
            returnWord += ";";
            returnWord += d.get(2).getMoney();
            returnWord += ";";
            returnWord += "0";
        } else if (d.size() == 4) {
            returnWord += d.get(0).getMoney();
            returnWord += ";";
            returnWord += d.get(1).getMoney();
            returnWord += ";";
            returnWord += d.get(2).getMoney();
            returnWord += ";";
            returnWord += d.get(3).getMoney();
        }
        return returnWord;
    }

    /*
    ** at the end of each round this will print stats from the round and let the user know whos winning
     */
    public static int endRound(int y, boolean[] a, ArrayList<PlayerMaker> d, String wP, int hS) {

        if (a[0] && y == 2) {
            y = 1;
            System.out.println("------------------");
            System.out.println(d.get(0).getName() + " Currently has: " + d.get(0).getMoney());
            System.out.println("------------------");

        } else if (a[1] && y == 3) {
            y = 1;
            System.out.println(d.get(0).getName() + " Currently has: " + d.get(0).getMoney());
            System.out.println("------------------");
            System.out.println(d.get(1).getName() + " Currently has: " + d.get(1).getMoney());
            System.out.println("------------------");
            System.out.println("The leading player is " + wP + " with: " + hS);
            System.out.println("------------------");
            System.out.println("New Round!");
            System.out.println("------------------");

        } else if (a[2] && y == 4) {
            y = 1;
            System.out.println(d.get(0).getName() + " Currently has: " + d.get(0).getMoney());
            System.out.println("------------------");
            System.out.println(d.get(1).getName() + " Currently has: " + d.get(1).getMoney());
            System.out.println("------------------");
            System.out.println(d.get(2).getName() + " Currently has: " + d.get(2).getMoney());

            System.out.println("------------------");
            System.out.println("The leading player is " + wP + " with: " + hS);
            System.out.println("------------------");
            System.out.println("New Round!");
            System.out.println("------------------");

        } else if (a[3] && y == 5) {
            y = 1;
            System.out.println(d.get(0).getName() + " Currently has: " + d.get(0).getMoney());
            System.out.println("------------------");
            System.out.println(d.get(1).getName() + " Currently has: " + d.get(1).getMoney());
            System.out.println("------------------");
            System.out.println(d.get(2).getName() + " Currently has: " + d.get(2).getMoney());
            System.out.println("------------------");
            System.out.println(d.get(3).getName() + " Currently has: " + d.get(3).getMoney());

            System.out.println("------------------");
            System.out.println("The leading player is " + wP + " with: " + hS);
            System.out.println("------------------");
            System.out.println("New Round!");
            System.out.println("------------------");

        }

        return y;
    }

    /*
    ** This is used at the start of each turn to tell users who's turn it is
     */
    public static void getTurn(int keepTrackofTurn1, ArrayList<PlayerMaker> players) {

        if (keepTrackofTurn1 == 1) {
            System.out.println(players.get(0).getName() + "'s turn");
        }
        if (keepTrackofTurn1 == 2) {
            System.out.println(players.get(1).getName() + "'s turn");;
        }
        if (keepTrackofTurn1 == 3) {
            System.out.println(players.get(2).getName() + "'s turn");

        }
        if (keepTrackofTurn1 == 4) {
            System.out.println(players.get(3).getName() + "'s turn");
        }
    }

    public static void getTopscores() {
        ArrayList<String> scoresAndnames = new ArrayList<String>();

        try {
            BufferedReader br2 = new BufferedReader(new FileReader("Records.txt"));
            String txt = br2.readLine();
            while (txt != null) {
                scoresAndnames.add(txt);
                txt = br2.readLine();
            }

        } catch (Exception ex) {

            System.out.println("Sorting fileRead failure");
        }

    }

    /*
    ** prints top 5 scores 
     */
    public static void highscoreFile() {
        Scanner d = new Scanner(System.in);
        ArrayList<String> highScorefile = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Records.txt"));
            String s = br.readLine();

            while (s != null) {

                highScorefile.add(s);
                s = br.readLine();

            }

        } catch (Exception ex) {

            System.out.println("Failure reading highScoreFile");
        }

        int[] Scores = new int[highScorefile.size()];
        String[] winnerNames = new String[highScorefile.size()];
        for (int x = 0; x < highScorefile.size(); x++) {

            String splitString[] = highScorefile.get(x).split(" ");
            Scores[x] = Integer.parseInt(splitString[1]);
            winnerNames[x] = splitString[0];

        }
        System.out.println("What would you like to see");
        System.out.println("Type S to search for a player");
        System.out.println("Type L to see all players from low to high");
        System.out.println("Type H to see all players from high to low");
        System.out.println("Type A to see all top 5 players");
        int Scores1[] = Scores;
        String winnerNames1[] = winnerNames;
      
        
        String userinput = d.nextLine();
      
        while (!userinput.equalsIgnoreCase("Q")) {
            Scores = Scores1;
            winnerNames = winnerNames1;
            
            if (userinput.equalsIgnoreCase("A")) {
                int tempForScore;
                String tempForNames = "";
                int HighID = 0;
                for (int y = 0; y < Scores.length; y++) {
                    tempForScore = Scores[y];

                    for (int z = y; z < Scores.length; z++) {

                        if (tempForScore < Scores[z]) {
                            HighID = z;

                            tempForScore = Scores[z];
                            tempForNames = winnerNames[z];

                        }

                    }
                    Scores[HighID] = Scores[y];
                    Scores[y] = tempForScore;
                    winnerNames[HighID] = winnerNames[y];
                    winnerNames[y] = tempForNames;

                }
                int x = 0;
                if (winnerNames.length > 5) {

                    x = 5;
                } else {

                    x = winnerNames.length;
                }

                for (int p = 0; p < x; p++) {

                    System.out.println(winnerNames[p] + " " + Scores[p]);
                }
            }

            else if (userinput.equalsIgnoreCase("H")) {
                int tempForScore;
                String tempForNames = "";
                int HighID = 0;
                for (int y = 0; y < Scores.length; y++) {
                    tempForScore = Scores[y];

                    for (int z = y; z < Scores.length; z++) {

                        if (tempForScore < Scores[z]) {
                            HighID = z;

                            tempForScore = Scores[z];
                            tempForNames = winnerNames[z];

                        }

                    }
                    Scores[HighID] = Scores[y];
                    Scores[y] = tempForScore;
                    winnerNames[HighID] = winnerNames[y];
                    winnerNames[y] = tempForNames;

                }
             

                for (int p = 0; p < winnerNames.length; p++) {

                    System.out.println(winnerNames[p] + " " + Scores[p]);
                }
            }
            
                   else if (userinput.equalsIgnoreCase("L")) {
                int tempForScore;
                String tempForNames = "";
                int lowID = 0;
                
                for (int y = 0; y < Scores.length; y++) {
                    tempForScore = Scores[y];

                    for (int z = y; z < Scores.length; z++) {

                        if (tempForScore > Scores[z]) {
                            lowID = z;

                            tempForScore = Scores[z];
                            tempForNames = winnerNames[z];

                        }

                    }
                    Scores[lowID] = Scores[y];
                    Scores[y] = tempForScore;
                    winnerNames[lowID] = winnerNames[y];
                    winnerNames[y] = tempForNames;

                }
             

                for (int p = 0; p < winnerNames.length; p++) {

                    System.out.println(winnerNames[p] + " " + Scores[p]);
                }
            }
             else if (userinput.equalsIgnoreCase("S")) {
                int tempForScore;
                String tempForNames = "";
                int HighID = 0;
                for (int y = 0; y < Scores.length; y++) {
                    tempForScore = Scores[y];

                    for (int z = y; z < Scores.length; z++) {

                        if (tempForScore < Scores[z]) {
                            HighID = z;

                            tempForScore = Scores[z];
                            tempForNames = winnerNames[z];

                        }

                    }
                    Scores[HighID] = Scores[y];
                    Scores[y] = tempForScore;
                    winnerNames[HighID] = winnerNames[y];
                    winnerNames[y] = tempForNames;

                }
             System.out.println("Who would you like to search for");
             String name = d.nextLine();
             int flag1 = 0;
             for(int y =0; y<winnerNames.length;y++){
             if(name.equalsIgnoreCase(winnerNames[y])){
             System.out.println(winnerNames[y] + " "+ Scores[y]);
             flag1++;
             }
                 
             
             }
             if(!(flag1>0)){
             System.out.println("User not found");
             }
              
            }
            System.out.println("What would you like to see");
        System.out.println("Type S to search for a player");
        System.out.println("Type L to see all players from low to high");
        System.out.println("Type H to see all players from high to low");
        System.out.println("Type Q to end program");
        System.out.println("Type A to see all top 5 players");
        userinput = d.nextLine();  
        }

    }

}
