package dev.codenmore.tilegame.display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private final String THREAD_TERMINATION_ERROR_MESSAGE = "Error: Failed to terminate the thread";
    private final int TOTAL_NUMBER_OF_BUFFERS_IN_BUFFER_STRATEGY = 3;

    private String title = "";
    private int height, width = 0;
    private boolean running = false;

    private Display display;
    private Thread thread;

    // Defining variables for rendering related tasks
    private Graphics graphics;
    private BufferStrategy bufferStrategy;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    /**
     * Main Purpose:
     * This method will be responsible for setting up everything needed to start the game.
     *
     * TO BE CONTINUED...
     */
    private void initialization() {
        display = new Display(title, width, height);
    }

    /**
     * Main Purpose:
     * This method will be used to update the game status whenever the user performs a particular
     * action.
     *
     * Usage:
     * Will be used in run()
     *
     * TO BE CONTINUED...
     */
    private void updateGameStatus() {

    }

    /**
     * Main Purpose:
     * This method will be responsible for rendering all the changes to the canvas so that the user
     * could see the effect of their actions
     *
     * Usage:
     * will be used in run()
     *
     * TO BE CONTINUED...
     */
    private void render() {
        //check if a buffer exists in the canvas
        bufferStrategy = display.getCanvas().getBufferStrategy();

        if(bufferStrategy == null) {
            display.getCanvas().createBufferStrategy(TOTAL_NUMBER_OF_BUFFERS_IN_BUFFER_STRATEGY);
            return;
        }

        //if the bufferStrategy is not null, then we will start the drawing process
        graphics = bufferStrategy.getDrawGraphics();

        graphics.clearRect(0, 0, width, height);

        //Draw a rectangle in the middle
        graphics.drawRect(width/2, height/2, width, height);

        //Draw a rectangle that collides with the one above
        graphics.drawRect(width/4, height/4, width/2, height/2);

        //Draw a 3d rectangle
        graphics.draw3DRect(width, height, width, height, false);
        graphics.drawRoundRect(width, height, width, height, 2, 2);
        graphics.drawString("Hello World", width*2, height*2);

        //inform the buffer and the canvas that we are done drawing and buffer can get reflected to the canvas
        bufferStrategy.show();
        graphics.dispose();
    }

    public void run() {

        // initialize the game
        initialization();

        // while loop to run the game until it ends
        while(running) {
            updateGameStatus();
            render();
        }

        stop();
    }

    public synchronized void start() {
        // If the game is running, do not initialize another thread
        if(running) {
            return;
        }

        //create a new thread and set running as true
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        // If the game is not running, then do not attempt to terminate the thread
        if(!running) {
            return;
        }

        try {
            running = false;
            thread.join();
        } catch (InterruptedException e) {
            System.err.println(THREAD_TERMINATION_ERROR_MESSAGE);
        }
    }
}
