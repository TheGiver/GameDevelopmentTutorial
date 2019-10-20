package dev.codenmore.tilegame.display;

import javax.swing.*;

public class Display {

    //Define a JFrame
    private JFrame frame;

    //Setting the title, width and height of the window
    private String title;
    private int width, height;

    //Creating a constructor of the display class
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        //initialize the window when the constructor is called in another class
        createWindow();
    }

    /**
     * This function is responsible for creating a window object, setting the title
     * and the dimensions of the window.
     *
     * The function is also responsible for making sure that the program properly
     * closes when the user clicks on the exit button.
     */
    private void createWindow() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
