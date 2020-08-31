/**
File Name:	U2A5_TicTacEvent
Programmer:	Sneha Patel
Date:		May 28, 2020
Description:	This program uses two dimensional arrays to simulate a tic-tac-toe
                game. This file contains methods that tell program what to do when
                each button is clicked. This file also determines the winner, if any,
                of the game. This file is associated with the TicTacEvent file.
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/*
* creates a class that will respond to mouse and keyboard input by "listening"
*/
public class TicTacEvent implements ItemListener, ActionListener, Runnable {

    TicTac gui; // creates an object to the Tic Tac file, to associate the game board file with the event file
    Thread playing;
    ImageIcon a = new ImageIcon("x.jpg"); // assigns x image to variable
    ImageIcon b = new ImageIcon("o.jpg"); // assigns o image to variable
    ImageIcon back = new ImageIcon("cardback.jpg "); // assigns cardback image to variable
    int clicks = 0; // variable used to keep trace of number of clicks to determine which player's turn it is
    int win = 0; // variable to keep trace of if there is a winner
    int check [][]= new int[3][3]; // array that keeps track of each button to determine if it shows cardback, a x or an o
    int numofwins[] = new int [3]; // array that keeps track of num of wins bu x and o, and the number of ties
    
    /*
    * method that associates the two files to be used together
    */
    public TicTacEvent(TicTac in) {
        gui = in;
        
        // for loop that initializes the array to 0 at each index, to show that each button currently shows cardback image
        for (int row = 0; row <= 2; row++) {
            for (int col = 0; col <= 2; col++) {
                check[row][col] = 0; // initializing array to 0
            }
        }
    }

    /*
    * method that tells the program what to do when a button is clicked
    */
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand(); // takes the button name as input from the button that is clicked
        // if statements check which button is clicked
        if (command.equals("Play")) { // checks if the Play button is clicked
            startPlaying(); // runs the startPlaying method
        }
        if (command.equals("Reset")) {// checks if the Reset button is clicked
            reset(); // runs the reset method
        }
        if (command.equals("1")) { // checks if button 1 is clicked
            b1(); // runs the b1 method
        }
        if (command.equals("2")) { // check if button 2 is clicked
            b2(); // runs the b2 method
        }
        if (command.equals("3")) { // check if button 3 is clicked
            b3(); // runs the b3 method
        }
        if (command.equals("4")) { // check if button 4 is clicked
            b4(); // runs the b4 method
        }
        if (command.equals("5")) { // check if button 5 is clicked
            b5(); // runs the b5 method
        }
        if (command.equals("6")) { // check if button 6 is clicked
            b6(); // runs the b6 method
        }
        if (command.equals("7")) { // check if button 7 is clicked
            b7(); // runs the b7 method
        }
        if (command.equals("8")) { // check if button 8 is clicked
            b8(); // runs the b8 method
        }
        if (command.equals("9")) { // check if button 9 is clicked
            b9(); // runs the b9 method
        }
        // outputs the scoreboard to the blank1 textarea
        gui.blank1.setText ("\n\n\n  Num of X Wins: " + numofwins[0] + "\n  Num of O Wins: " + numofwins[1] + "\n  Num of Ties: " + numofwins[2]);
    }

    /*
    * method that tells the program what to do when button 1 is clicked
    */
    void b1() {
        clicks = clicks + 1; // keeps track of the number of boxes that were chosen
        
        if ((clicks % 2) == 1) { // checks if the number of clicks is odd
            gui.boxes[0][0].setIcon(a); // sets button to X image
            check[0][0] = 1; // declares this square to be taken by X
        } else { // if number of clicks is even
            gui.boxes[0][0].setIcon(b); // sets button to O image
            check[0][0] = 2; // declares this square to be taken by O
        }
        winner(); // runs the winner method to check for winner
    }
    
    /*
    * method that tells the program what to do when button 2 is clicked
    */
    void b2() {
        clicks = clicks + 1; // keeps track of the number of boxes that were chosen
        
        if ((clicks % 2) == 1) { // checks if the number of clicks is odd
            gui.boxes[0][1].setIcon(a); // sets button to X image
            check[0][1] = 1; // declares this square to be taken by X
        } else { // if number of clicks is even
            gui.boxes[0][1].setIcon(b); // sets button to O image
            check[0][1] = 2; // declares this square to be taken by O
        }
        winner(); // runs the winner method to check for winner
    }

    /*
    * method that tells the program what to do when button 3 is clicked
    */
    void b3() {
        clicks = clicks + 1; // keeps track of the number of boxes that were chosen
        
        // if number of clicks is odd, then sets button icon to X and declares square to be taken by X 
        if ((clicks % 2) == 1) {
            gui.boxes[0][2].setIcon(a);
            check[0][2] = 1;
        } else { // if number of clicks is even, then sets button icon to O and declares square to be taken by O
            gui.boxes[0][2].setIcon(b);
            check[0][2] = 2;
        }
        winner(); // runs the winner method to check for winner
    }

    /*
    * method that tells the program what to do when button 4 is clicked
    */
    void b4() {
        clicks = clicks + 1; // keeps track of the number of boxes that were chosen
        
        // if number of clicks is odd, then sets button icon to X and declares square to be taken by X
        if ((clicks % 2) == 1) {
            gui.boxes[1][0].setIcon(a);
            check[1][0] = 1;
        } else { // if number of clicks is even, then sets button icon to O and declares square to be taken by O
            gui.boxes[1][0].setIcon(b);
            check[1][0] = 2;
        }
        winner(); // runs the winner method to check for winner
    }

    /*
    * method that tells the program what to do when button 5 is clicked
    */
    void b5() {
        clicks = clicks + 1; // keeps track of the number of boxes that were chosen
        
        // if number of clicks is odd, then sets button icon to X and declares square to be taken by X
        if ((clicks % 2) == 1) {
            gui.boxes[1][1].setIcon(a);
            check[1][1] = 1;
        } else { // if number of clicks is even, then sets button icon to O and declares square to be taken by O
            gui.boxes[1][1].setIcon(b);
            check[1][1] = 2;
        }
        winner(); // runs the winner method to check for winner
    }

    /*
    * method that tells the program what to do when button 6 is clicked
    */
    void b6() {
        clicks = clicks + 1; // keeps track of the number of boxes that were chosen
        
        // if number of clicks is odd, then sets button icon to X and declares square to be taken by X
        if ((clicks % 2) == 1) {
            gui.boxes[1][2].setIcon(a);
            check[1][2] = 1;
        } else { // if number of clicks is even, then sets button icon to O and declares square to be taken by O
            gui.boxes[1][2].setIcon(b);
            check[1][2] = 2;
        }
        winner(); // runs the winner method to check for winner
    }

    /*
    * method that tells the program what to do when button 7 is clicked
    */
    void b7() {
        clicks = clicks + 1; // keeps track of the number of boxes that were chosen
        
        // if number of clicks is odd, then sets button icon to X and declares square to be taken by X
        if ((clicks % 2) == 1) {
            gui.boxes[2][0].setIcon(a);
            check[2][0] = 1;
        } else { // if number of clicks is even, then sets button icon to O and declares square to be taken by O
            gui.boxes[2][0].setIcon(b);
            check[2][0] = 2;
        }
        winner(); // runs the winner method to check for winner
    }

    /*
    * method that tells the program what to do when button 8 is clicked
    */
    void b8() {
        clicks = clicks + 1; // keeps track of the number of boxes that were chosen
        
        // if number of clicks is odd, then sets button icon to X and declares square to be taken by X
        if ((clicks % 2) == 1) {
            gui.boxes[2][1].setIcon(a);
            check[2][1] = 1;
        } else { // if number of clicks is even, then sets button icon to O and declares square to be taken by O
            gui.boxes[2][1].setIcon(b);
            check[2][1] = 2;
        }
        winner(); // runs the winner method to check for winner
    }

    /*
    * method that tells the program what to do when button 9 is clicked
    */
    void b9() {
        clicks = clicks + 1; // keeps track of the number of boxes that were chosen
        
        
        // if number of clicks is odd, then sets button icon to X and declares square to be taken by X
        if ((clicks % 2) == 1) {
            gui.boxes[2][2].setIcon(a);
            check[2][2] = 1;
        } else { // if number of clicks is even, then sets button icon to O and declares square to be taken by O
            gui.boxes[2][2].setIcon(b);
            check[2][2] = 2;
        }
        winner(); // runs the winner method to check for winner
    }

    /*
    * method to check for winner
    */
    void winner() {
        /**
         * for loop checks each row for winner
         */
        for (int x = 0; x <= 2; x++) {
            if ((check[x][0] == check[x][1]) && (check[x][0] == check[x][2])) { // check if all three squares in a row are taken by same player
                if (check[x][0] == 1) { // checks if the player is X
                    JOptionPane.showMessageDialog(null, "X is the winner"); // creates a pop up box that declared X as the winner
                    win = 1; // sets win variable to 1, indicating a winner has been declared
                    numofwins[0] += 1; // increases the number of times X wins the game by 1
                } else if (check[x][0] == 2) { // checks if the player is O
                    JOptionPane.showMessageDialog(null, "O is the winner"); // creates a pop up box that declared O as the winner
                    win = 1; // sets win variable to 1, indicating a winner has been declared
                    numofwins[1] += 1; // increases the number of times O wins the game by 1
                }
            }
        }
        /**
         * for loop checks each column for winner
         */
        for (int x = 0; x <= 2; x++) { 
            if ((check[0][x] == check[1][x]) && (check[0][x] == check[2][x])) { // check if all three squares in a row are taken by same player
                if (check[0][x] == 1) { // checks if the player is X
                    JOptionPane.showMessageDialog(null, "X is the winner"); // creates a pop up box that declared X as the winner
                    win = 1; // sets win variable to 1, indicating a winner has been declared
                    numofwins[0] += 1; // increases the number of times X wins the game by 1
                } else if (check[0][x] == 2) { // checks if the player is O
                    JOptionPane.showMessageDialog(null, "O is the winner"); // creates a pop up box that declared O as the winner
                    win = 1; // sets win variable to 1, indicating a winner has been declared
                    numofwins[1] += 1; // increases the number of times O wins the game by 1
                }
            }
        }
        // checks if either of the two diagonals are taken by the same player
        if (((check[0][0] == check[1][1]) && (check[0][0] == check[2][2]))
                || ((check[2][0] == check[1][1]) && (check[1][1] == check[0][2]))) {
            if (check[1][1] == 1) { // checks if the player is X
                JOptionPane.showMessageDialog(null, "X is the winner"); // creates a pop up box that declared X as the winner
                win = 1; // sets win variable to 1, indicating a winner has been declared
                numofwins[0] += 1; // increases the number of times X wins the game by 1
            } else if (check[1][1] == 2) { // checks if the player is O
                JOptionPane.showMessageDialog(null, "O is the winner"); // creates a pop up box that declared O as the winner
                win = 1; // sets win variable to 1, indicating a winner has been declared
                numofwins[1] += 1; // increases the number of times O wins the game by 1
            }
        }
        
        // checks if all squares have been declared and if no winner has been declared
        if ((clicks == 9) && (win == 0)) {
            JOptionPane.showMessageDialog(null, "The game is a tie"); // creates a pop up box that declares a tie
            numofwins[2] += 1; // increases the number of ties by 1
        }
        
        // outputs the scoreboard to the blank1 textarea
        gui.blank1.setText ("\n\n\n  Num of X Wins: " + numofwins[0] + "\n  Num of O Wins: " + numofwins[1] + "\n  Num of Ties: " + numofwins[2]);
    }

    /*
    * method that tells the program what to do when Play button is clicked
    */
    void startPlaying() {
        playing = new Thread(this); // executes the program by referencing this current object
        playing.start(); // starts the game
        gui.play.setEnabled(false); // disables the play button
    }
    
    /*
    * method that tells the program what to do when Reset button is clicked
    */
    void reset() {
        clicks = 0; // resets clicks to 0
        win = 0; // resets wins to 0
        
        // for loop that resets each game button back to flipped 
        for (int x = 0; x <= 2; x++) {
           for (int y = 0; y <= 2; y++) {
               gui.boxes[x][y].setIcon(back); // sets the game button back to the cardback image
               check[x][y] = 0; // resets the check button to 0, to show that each button currently shows cardback image
           }
        }
    }

    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
