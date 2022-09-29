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
    }

    public Instant end(){
        end = Instant.now(); 
        return end;
    }
    
    public double timeElapsed(){
        Duration timeElapsed = Duration.between(start, end);
        secondspassed = timeElapsed.toSeconds();
        return secondspassed;
    }

    public void rating(){
        while(secondspassed < 20 ){
            Duration timeElapsed = Duration.between(start, end);
            secondspassed = timeElapsed.toSeconds();
            end();
            if(secondspassed == 10.0){
                System.out.println("You have spent" + " " + secondspassed + " seconds " + " banking");
            }
        }

        System.out.println("Your session has ended");
    }

    public String toString(){
       return String.format("%s",secondspassed);
    }

}