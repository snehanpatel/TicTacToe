/**
File Name:	U2A5_TicTac
Programmer:	Sneha Patel
Date:		May 28, 2020
Description:	This program uses two dimensional arrays to simulate a tic-tac-toe
                game. This file contains the program to create the application and
                to setup up the game board and buttons. This file is associated
                with the TicTacEvent file.
 */

import java.awt.*;
import javax.swing.*;

public class TicTac extends JFrame {
    TicTacEvent tictac = new TicTacEvent(this); // creates an object to the TicTacEvent file, which joins the two programs and allow them to work with each other
    
    JPanel row1 = new JPanel(); // creates the outline box for the buttons
    JButton boxes[][] = new JButton [3][3]; // creates a 2D array of nine buttons, 3 rows and 3 columns
    JButton play = new JButton ("Play"); // creates a play button
    JButton reset = new JButton ("Reset"); // creates a reset button
    JTextArea blank1 = new JTextArea(); // creates a textarea to output instructions and the scoreboard
    JOptionPane win = new JOptionPane("Winner"); // creates a popup box that will declare the winner
    ImageIcon back = new ImageIcon("cardback.jpg "); // assigns cardback image to variable
    
    /*
    * creates method to draw the tic-tac-toe game board
    */
    public TicTac() {
        super("Tic Tac Toe"); // creates the outer frame with the title "Tic Tac Toe"
        setSize(600, 650); // sets the size of the outer frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets the program to quit running when the application is closed
        
        // FlowLayout arranges the buttons from left to right, horizontally centered with a 5 pixel gap between them, and this layout is assigned to a variable
        FlowLayout layout = new FlowLayout();
        setLayout(layout); // sets the layout to the FlowLayout defined by the variable
        
        // declaring variables to store the button number
        int name = 0;
        String newname;
        
        // GridLayput arranges the buttons in a rectangular grid, where all cells are of equal size, and assigns layout to variable
        GridLayout layout1 = new GridLayout(4, 3, 10, 10);
        row1.setLayout(layout1); // sets layout of row1 as the GridLayout defined by the variable
        
        // loop to create and add the buttons to the GridLayout's first three rows
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                name = name + 1; // increases number of button by 1 each time
                newname = Integer.toString(name); // converts number from int data type to string
                boxes[x][y] = new JButton(newname); // created a new button with the respective number
                boxes[x][y].setIcon(back); // sets button icon to the cardback image
                row1.add(boxes[x][y]); // adds the buttons to the GridLayout
            }
        }
        
        row1.add(play); // adds the play button to the last row of the GridLayout
        row1.add(blank1); // adds the textarea to the last row of the GridLayout
        row1.add(reset); // adds the reset button to the last row of the GridLayout
        add(row1); // adds the GridLayout to the FlowLayout
                
        play.addActionListener(tictac); // makes the Play button ready to handle mouse clicks
        reset.addActionListener(tictac); // makes the Reset button ready to handle mouse clicks
        // for loop that makes each game button ready to handle mouse clicks
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                boxes[x][y].addActionListener(tictac);
            }
        }
        
        blank1.setText("\n\n\n\nPress the \"Play\" Button to start"); // displaying instructions in the textarea
        
        setVisible(true); // shows the FlowLayout on the screen
    }
    
    public static void main(String[] arguments) {
        TicTac frame = new TicTac(); // runs the screen layout class
    } 
}