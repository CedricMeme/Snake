package clocks;

public class GameClock extends Thread{
    public static boolean running = true;

    public void run(){
        while(running){
            try {
                sleep(200);
            }catch (InterruptedException e){
        }
    }

}
