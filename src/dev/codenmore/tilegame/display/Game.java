package dev.codenmore.tilegame.display;

public class Game implements Runnable{

    private final String THREAD_TERMINATION_ERROR_MESSAGE = "Error: Failed to terminate the thread";

    private String title = "";
    private int length, width = 0;
    private boolean running = false;

    private Display display;
    private Thread thread;

    public Game(String title, int width, int length) {
        this.title = title;
        this.width = width;
        this.length = length;
    }

    /**
     * Main Purpose:
     * This method will be responsible for setting up everything needed to start the game.
     *
     * TO BE CONTINUED...
     */
    private void initialization() {
        display = new Display(title, width, length);
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
    private void updateCanvas() {

    }

    public void run() {

        // initialize the game
        initialization();

        // while loop to run the game until it ends
        while(running) {
            updateGameStatus();
            updateCanvas();
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
