import java.util.Random;
import java.util.Arrays;

public class ProjectAttempt1{
	public static void main(String[] args){
		int[][] Grid=new int [9][9];
		int [] L=new int[9];
		Random Rando=new Random();
		int count=0;
			
			do {
		int Value=Rando.nextInt(10);
			boolean Truther=true;
			for (int i =0;i<9;i++){
				if (Value==L[i]) Truther=false;
			}
			if (Truther){
				L[count]=Value;
				count+=1;
			}
			
	}while (count<9);
	int[] Hori=new int [9];
		int[] Vert=new int [9];
	
		int j=0;
		while (j<3){
		for (int i=0;i<9;i=i+3){
			Grid[j][0]=L[i];
			Grid[j][1]=L[i+1];
			Grid[j][2]=L[i+2];
			Vert[j]=L[i];
			
			j+=1;
			
		}}
		
		
		Hori=Grid[0];
		int ll=3;
		do {
		int Value=Rando.nextInt(1,10);
			boolean Truther=true;
			for (int i =0;i<9;i++){
				if (Value==Hori[i]) Truther=false;
			}
			if (Truther){
				
				Hori[ll]=Value;
				ll+=1;
				 
				
			}
			
	}while (ll<9);
	
	System.out.println(Arrays.toString(Hori));
	ll=3;
	do {
		int Value=Rando.nextInt(1,10);
			boolean Truther=true;
			for (int i =0;i<9;i++){
				if (Value==Vert[i]) Truther=false;
			}
			if (Truther){
				//System.out.println(Value);
				Vert[ll]=Value;
				ll+=1;
				 
				
			}
			
	}while (ll<9);
	for (int m=0;m<9;m++){
		Grid[m][0]=Vert[m];
	}
	
	int []ConfirmH=new int[9];
	int []ConfirmV=new int[9];
	int []ConfirmB=new int[9];
	
	int [][] BB=new int[3][3];
	int [][][] BH=new int [3][3][9];
	
	int g=0 ;
	int y=0;
	int lol=0;

	
	for (int h=0;h<9;h++){
		ConfirmH=Grid[h];
		int kok=0;
		int yoy=0;
		for (int t=0;t<9;t++){
	
			ConfirmV[t]=Grid[h][t];
			if (yoy<3 && kok<3){
			BB[kok][yoy]=ConfirmV[t];}
		if (t==2||t==5){
				kok+=1;
				yoy=0;
		}else{yoy+=1;}
		if (h==2||h==5){
				lol+=1;
				
		}
		
		
		
		//	System.out.println(Arrays.toString(ConfirmB));
		}
		
	
		
		
		System.out.println(Arrays.toString(BH[0][0]));
		
	}
	
	
		
		/*for (int h=0;h<9;h++){
			for (int y=0;y<9;y++){
				Hori=Grid[y];
				
				
				
				Grid[y]=Hori;
			}
			Vert=Grid[h];
			int lo=1;
			while (lo<5){
				int Value=Rando.nextInt(9);
				boolean Truther=true;
				for (int i =0;i<9;i++){
					if (Value==Vert[i]) Truther=false;
				}
				if (Truther){
					Vert[lo]=Value;
					lo+=1;
				}System.out.println(lo);
			}
			Grid[h]=Vert;
			
		}*/for (int i=0;i<9;i++){for (int k=0;k<9;k++){
		System.out.print(Grid[i][k]);}System.out.println("");}
	}
	
}

