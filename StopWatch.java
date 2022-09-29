import java.time.Instant;
import java.time.Duration;
public class StopWatch{
    Instant start;
    Instant end;
    double secondspassed;
    
    public StopWatch(){
    }
    

    public Instant start(){
        start = Instant.now(); 
        return start;
    }//starts the stopwatch and returns the time it started at

    public Instant end(){
        end = Instant.now(); 
        return end;
    }//stops the stopwatch and returns the time that it was stopped
    
    public double timeElapsed(){
        Duration timeElapsed = Duration.between(start, end);
        secondspassed = timeElapsed.toSeconds();
        return secondspassed;
    } //calculates the time between the time the watch was started and when it was stopped

    public void rating(){
        System.out.println("You have spent" + " " + secondspassed + " seconds " + " banking");
        System.out.println("Your session has ended");
    }//this can be used for rating once the program is completed

    public String toString(){
       return String.format("%s",secondspassed);
    }

}
