package com.example.sudoku;

import java.util.*;
import java.util.Random.*;

public class Remove_numbers {
	private  int [][] board;
	private  String Level;

	
	public Remove_numbers(String Level){
		ConversionTest Test=new ConversionTest();
		this.board=Test.Complete();
		this.Level=Level;
	}
	public int[][] getCompleted(){
		return this.board;
	}
	
    public int[][] remove() {
        Random random = new Random();
		int remove1;
        int remove2;
		int x=0;
		if (this.Level.equals("Easy")){
			 x=20;
		}else if (this.Level.equals("Medium")){
			x=40;
		}else{x=50;}
        while (x > 0) {
            remove1 = random.nextInt(9);
            remove2 = random.nextInt(9);
            if (this.board[remove1][remove2] != 0) {
                this.board[remove1][remove2] = 0;
                x--;
            }
        }

        return this.board;
    }


}

