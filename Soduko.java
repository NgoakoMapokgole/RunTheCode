import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Soduko{
    public static void main(String[] args){
        int[][] sodukorandom = new int[9][9];// creates a 9 by 9 grid with zeros
        Random rand = new Random();  


            // This is the outer loop which assigns v a value from 1 to 9
            ArrayList<Integer> columns = new ArrayList<Integer>();// the value of all occupied columns will be stored in here for each value
            ArrayList<Integer> rows = new ArrayList<Integer>();//the value for all occupied rows will be stored in here for each value

 
        for(int v = 0; v <= 9; v++){
            int n = 3;
            int x = 5;
            for(int i = 0; i < 3 ;i++){//loop2
                /* The following loop goes from row one to row three putting the value
                of v into the the rows ensuring that the value does not appear multiple
                times in one row and columns( example: the value of v the first time is one) 
                */
                int column ;
                int row ;

                if(columns.size() == 0 || rows.size() == 0 ){
                    /* this will only be excuted only on the firt-time of the loop2 because on
                    the first time both the columns list and the row lists are empty
                    we need the lists to have values in order to compare
                    */

                    /*gets a random value between 0 and 3 for the row and also gets a random 
                    value between 0 and 3 for the column because want to add the valueZZZ
                    column = rand.nextInt(n);
                    row = rand.nextInt(3);
    
                    sodukorandom[row][column] = v;//inserts the value v into the specified location ([row][column])
                    columns.add(column);
                    rows.add(row);
                }

                else if(columns.size() > 0 || rows.size() > 0){
                    /* on the second and third tim of loop2 this will be executed
                    */

                    /*
                    gets a random value between 0 and 3 for the row and also gets a random 
                    value between 3 and 5 for the column because we want to add the value v in the second
                    3 by 3 box
                    */
                    column = rand.nextInt((x - n) + 1) + n;
                    row = rand.nextInt(3);

                    /* checks if the value which was generated for the row and for the column
                    already has a value to avoid the repition of the value on the same row or the same
                    row*/

                    while(columns.contains(column) || rows.contains(row)){
                        column = rand.nextInt((x - n) + 1) + n;
                        row = rand.nextInt(3);
                    }
            
                    sodukorandom[row][column] = v;
                    /* store the value of the column and row in the respective lists so that they
                    can be later used for checking if the value is already in that row*/
                    columns.add(column);
                    rows.add(row);

                    x = x + 3;
                    n = n + 3;
                }
            }
            int w = 3;
            int y = 5;
            for(int i = 0; i < 3 ;i++){//loop3
                /* The following loop goes from row 4 to row 6 putting the value
                of v into the the rows ensuring that the value does not appear multiple
                times in one row and columns( example: the value of v the first time is one) 
                */
                int column ;
                int row ;

                if(columns.size() == 3 || rows.size() == 3 ){
                    column = rand.nextInt((y-w)+1)+w;
                    row = rand.nextInt((5-3) + 1) + 3;
                    sodukorandom[row][column] = v;
                    columns.add(column);
                    rows.add(row);
                }

                else if(columns.size() > 3 || rows.size() > 3){
                    column = rand.nextInt((y - w) + 1) + w;
                    row = rand.nextInt((5-3)+ 1) + 3;
                    while(columns.contains(column) || rows.contains(row)){
                        column = rand.nextInt((y - w) + 1) + w;
                        row = rand.nextInt((5-3) + 1) + 3;
                    }

                    sodukorandom[row][column] = v;
                    columns.add(column);
                    rows.add(row);
                    y = y + 3;
                    w = w + 3;
                }
            }

            int k = 3;
            int r = 5;
            for(int i = 0; i < 3 ;i++){//loop4
                /* The following loop goes from row 7 to row 9 putting the value
                of v into the the rows ensuring that the value does not appear multiple
                times in one row and columns( example: the value of v the first time is one) 
                */
                int column ;
                int row ;

                if(columns.size() == 6 || rows.size() == 6 ){
                    column = rand.nextInt((r-k)+1)+k;
                    row = rand.nextInt((8-6)+ 1) + 6;
                    sodukorandom[row][column] = v;
                    columns.add(column);
                    rows.add(row);
                }

                else if(columns.size() > 6 || rows.size() > 6){
                    column = rand.nextInt((r - k) + 1) + k;
                    row = rand.nextInt((8-6)+ 1) + 6;
                    while(columns.contains(column) || rows.contains(row)){
                        column = rand.nextInt((r - k) + 1) + k;
                        row = rand.nextInt((8-6) + 1) + 6;
                    }

                    sodukorandom[row][column] = v;
                    columns.add(column);
                    rows.add(row);
                    r = r + 3;
                    k = k + 3;
                }
            }
           // System.out.println("\n");
           // System.out.println(columns);
           // System.out.println(rows);
        }
        

        // the following block draws the soduko board and enters the value for each position on the board
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
    



