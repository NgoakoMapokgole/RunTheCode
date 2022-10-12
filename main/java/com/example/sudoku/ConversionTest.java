package com.example.sudoku;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class ConversionTest{

	public static int GridNumber=9;


	public static int[][] Complete(){
	int[][] Grid=new int[GridNumber][GridNumber];
	Random Rando=new Random();
	int [][]ConfirmV=new int[GridNumber][GridNumber];//flips the board to move in a vertical manner
	int [][] BB=new int[(int) Math.sqrt(GridNumber)][(int)Math.sqrt(GridNumber)];//three variables for the subblock
	int [][] ListsBlock=new int[GridNumber][GridNumber];//list of the list of subblock
	int [][][] BlockCounter=new int [(int)Math.sqrt(GridNumber)][(int)Math.sqrt(GridNumber)][GridNumber];//stores the list of subblock in a simplified manner
	int Fatal=0;
	
	int row=0;
	while (row<GridNumber){
		int hhh=0;
		int column=0;
			while (column<GridNumber){
				for (int h=0;h<GridNumber;h++){
		for (int t=0;t<GridNumber;t++){
			ConfirmV[t][h]=Grid[h][t];
			}
	}
				int kol=0;
	int pp=0;
	for (int iou=0;iou<GridNumber;iou++){
		int pac=0;
		while (pac<(int)Math.sqrt(GridNumber)){// separates the horizontal list of the board so that we can build subblocks
		for (int i=0;i<GridNumber;i+=(int)Math.sqrt(GridNumber)){
			for (int k=0;k<(int)Math.sqrt(GridNumber);k++){
				BB[pac][k]=Grid[iou][i+k];}
			pac++;
		}
		
		for (int h=0;h<(int)Math.sqrt(GridNumber);h++){//stores the saved variablesin a simple to use loop
			for (int innerCounter=0;innerCounter<3;innerCounter++){
				ListsBlock[h+pp][kol+innerCounter]=BB[h][innerCounter];		
			}
		}
		
		kol+=Math.sqrt(GridNumber);//subblock values' counter
		if (kol==GridNumber ){
		kol=0;}//resets the counter if the value has reached maximum capacity of the array
		
		if (iou==2 ||iou==5){pp+=(int)Math.sqrt(GridNumber);}//This separates values in subblock form
		}
		
	}
	int yq=0;
	for (int y=0;y<Math.sqrt(GridNumber);y++){
		for (int p=0;p<(int)Math.sqrt(GridNumber);p++){
			BlockCounter[y][p]=ListsBlock[yq];
			yq+=1;//This variable helps with storing values of the sub-block
		}
	}int jj=0;
				boolean Looper=true;
				int LoopCounter=0;
				if (Grid[row][column]==0){
					
					int mo=0;// This Value helps to store values in the subblock after the value has been generated to check repearting variables
					if (row%(int)Math.sqrt(GridNumber)==1 &&column <(int)Math.sqrt(GridNumber)){mo=(int)Math.sqrt(GridNumber);}
					else if (row%(int)Math.sqrt(GridNumber)==1 &&column>=(int)Math.sqrt(GridNumber) && column<(int)Math.sqrt(GridNumber)){mo=0;}
					else if (row%(int)Math.sqrt(GridNumber)==1 && column<(int)Math.sqrt(GridNumber)){mo=-(int)Math.sqrt(GridNumber);}
					else if (row%(int)Math.sqrt(GridNumber)==2 && column<3){mo=2*(int)Math.sqrt(GridNumber);}
					else if (row%(int)Math.sqrt(GridNumber)==2 && column>=(int)Math.sqrt(GridNumber)&&column<2*(int)Math.sqrt(GridNumber)){mo=(int)Math.sqrt(GridNumber);}
					else if (row%(int)Math.sqrt(GridNumber)==2 && column<3){mo=0;}
					else if (row%(int)Math.sqrt(GridNumber)==0){mo=0;}

					while (Looper){//this generates the value and checks if the value is already in a subblock,Vertical or horizontal list

						int Picker=1+Rando.nextInt(9);
						boolean Truther=true;
						
						for (int i =0;i<GridNumber;i++){
							if (Picker==Grid[row][i] || Picker==ConfirmV[column][i] || Picker==BlockCounter[row/(int)Math.sqrt(GridNumber)][column/(int)Math.sqrt(GridNumber)][i]){ Truther=false;
						}}
					
						
						
						if (Truther){// if not found in the lists mentioned, Truther will be true, saving the values on the board, subblock and Vertical list
							Looper=false;//stops the while loop
							Grid[row][column]=Picker;
							
							
						}
						LoopCounter+=1;// This helps us to see if the while loop has looped many times, indicating invalid generation
						if (LoopCounter>1000){
							for (int y=0;y<=column;y++){
								Grid[row][y]=0;
								ConfirmV[y][row]=0;
						
							}
							
							column=-1;
							Fatal++;
							jj=Picker;
							
							break;}
					}
					if(Fatal>=100000){//this restarts the grid given that we generated an imporsible board
						return Complete();
						
					}					
				}column++;
			}
		row++;}
	return Grid;
	}
	

}



//todo: revision of variable names

