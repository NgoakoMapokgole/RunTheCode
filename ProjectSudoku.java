import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class ProjectSudoku{
	public static void main(String[] args){
	Scanner Input=new Scanner (System.in);
	int Level;
	
	System.out.println("Which grid do you want 9,16,25,36,49");
	Level=Input.nextInt();
	
	int[][] Grids=new int[Level][Level];
	int[] SelectionP=new int[Level];
	
	for (int i=0;i<Level;i++){SelectionP[i]=i+1;}
	for (int j=0;j<Level;j++){
		int StandIn=Level;
		
		for (int k=0;k<Level;k++){
			if (j==0){
				Random Rando=new Random();
				
				int Picker=Rando.nextInt(StandIn);
				Grids[j][k]=SelectionP[Picker];
				int Y=Level;
				
				for (int low=Picker;low<Y-1;low++){
					
					SelectionP[low]=SelectionP[low+1];
					
				System.out.println(Arrays.toString(SelectionP)+Picker)  ;
				}
				Y-=1;
				StandIn=StandIn-1;
			}else{ 
					Random Rando=new Random();
					for (int CounterH=0;CounterH<Level;CounterH++){
						int[] Vert=new int[Level];
						int[] Hori=new int[Level];
						int[] Block=new int[Level]; 
						for (int CounterV=0;CounterV<j;CounterV++){
							Vert[CounterV]=Grids[CounterV][CounterH];
						}
						int Counts=1;
						System.out.println(Arrays.toString(Vert));
						do {
							
							int Num=Rando.nextInt(Level);
							boolean FactCheck=true;
							
							for (int i=0;i<Vert.length;i++){
								if (Num==Vert[i] ){
									
								FactCheck=false;
								}
							}
							if (FactCheck){
							Vert[Counts]=Num;
							Counts=Counts+1;
							Grids[Counts][CounterH]=Num;
							}
							System.out.println(Arrays.toString(Vert));
							
						}while (Vert[Level-1]>0 );
					}
				}
	
			}
		
	
	
		
		
	}
	}
}

