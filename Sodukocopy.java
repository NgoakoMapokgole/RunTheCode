import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Point;

public class Sodukocopy{

    public static int checker(int row, ArrayList<Integer> rows){
        Random rand = new Random();
        while(rows.contains(row)){
            row = rand.nextInt(3);
        }
        return row;
    }
    public static void main(String[] args){
        int[][] sodukorandom = {
                                {0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0}, 
                                {0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0}, 
                                {0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0}, 
                                {0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0}, 
                                {0,0,0,0,0,0,0,0,0}, 
                              };

        Random rand = new Random();
        ArrayList<Point> points = new ArrayList<Point>();

        for(int v = 1 ; v <= 9; v++){

            ArrayList<Integer> columns = new ArrayList<Integer>();
            ArrayList<Integer> rows = new ArrayList<Integer>();
            
            int min = 3;
            int max = 5;

            for(int i= 0; i < 3; i++){
                    int column ;
                    int row ;

                    if(rows.size() == 0 ){

                        column = rand.nextInt(min);
                        row = rand.nextInt(3);
                        Point point = new Point(row,column);
                        
                    
                            while(points.contains(point)){
                                    row = rand.nextInt(3);
                                    int coordinates = checker(row,rows);
                                    column = rand.nextInt(min);
                                    row = coordinates;
                                    point = new Point(row,column);
                                    //System.out.println("nn"+point);
                                    //System.out.println("nn"+rows);
                            }
                        

                        sodukorandom[row][column] = v;
                        columns.add(column);
                        rows.add(row);
                        points.add(point);
                    }

                    else if(rows.size() > 0){
            
                        column = rand.nextInt((max - min)+1) + min;
                        row = rand.nextInt(3);
                        
                        int coordinates = checker(row, rows);
                        row = coordinates;

                        Point point = new Point(row,column);
                        int catchinfinite = 0;
                        while(points.contains(point)){
                                row = rand.nextInt(3);
                                coordinates = checker(row,rows);
                                column = rand.nextInt((max - min)+1) + min;
                                row = coordinates;
                                point = new Point(row,column);
                                //System.out.println("xx"+point);
                                //System.out.println("xx"+rows); 
                                catchinfinite = catchinfinite + 1;
                                if(catchinfinite == 15){
                                    break;
                                }
                        }

                        sodukorandom[row][column] = v;
                        columns.add(column);
                        rows.add(row);
                        points.add(point);

                        max = max + 3;
                        min = min + 3;
                    }
                    //System.out.println(points);
            }
        }
        

        for(int i = 0; i < sodukorandom.length ;i++){
                for(int a = 0; a < sodukorandom[i].length; a++){
                    if(a == 2 || a == 5){
                        System.out.print(sodukorandom[i][a]+"|"+" ");
                    }
                    else{
                        System.out.print(sodukorandom[i][a]+"|");
                    }
                }

                System.out.println();
                if(i == 2 || i == 5){
                    System.out.println("--------------------");
                }
        }
    }
}
