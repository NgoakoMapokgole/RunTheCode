package com.example.sudoku;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
   private class Cell {
       int value;
       boolean fixed;
       Button bt;

       public Cell(int initvalue, Context THIS, int J, int I,Remove_numbers PP) {
           value = initvalue;
           if (value != 0) fixed = true;
           else fixed = false;
           bt = new Button(THIS);
           if (fixed) {
               bt.setText(String.valueOf(value));
               bt.setTextColor(Color.BLACK);
           }else{
               bt.setTextColor(Color.GRAY);
           }
           if (J<3 && I<3) {
               bt.setBackgroundColor(Color.YELLOW);
           }else if(J<3 && I<6 &&I>=3){
               bt.setBackgroundColor(Color.RED);
           }else if(J<3 && I>=6){
               bt.setBackgroundColor(Color.BLUE);
           }else if(J<6 &&J>=3 && I<3){
               bt.setBackgroundColor(Color.BLUE);
           }else if(J<6 && J>=3 && I<6 &&I>=3){
               bt.setBackgroundColor(Color.YELLOW);
           }else if(J<6 && I>=6 &&J>=3){
               bt.setBackgroundColor(Color.RED);
           }else if(J>=6 && I<3 ){
               bt.setBackgroundColor(Color.RED);
           }else if(J>=6 && I<6 &&I>=3){
               bt.setBackgroundColor(Color.BLUE);
           }else if(J>=6 && I>=6){
               bt.setBackgroundColor(Color.YELLOW);
           }

           bt.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {
                   if (fixed) return;
                    value++;
                    if (value>9)value=1;
                    bt.setText(String.valueOf(value));
                    boolean Checker=true;
                    for (int i=0;i<9;i++){
                        for (int j=0;j<9;j++){
                            if (table[i][j].value==0){Checker=false;}

                        }
                    }
                    if (Checker){
                        int[][] KO=PP.getCompleted();
                        boolean t=true;
                        for (int i=0;i<9;i++){
                            for (int j=0;j<9;j++){
                                if (KO[i][j]==table[i][j].value){t=false;}
                            }
                        }
                        if (t){System.out.println("GAME OVER, YOU WON");}else{System.out.println("Incorrect Values Entered");}
                    }
               }
           });

       }
   }
   Cell[][] table;
   int[][] input;
   TableLayout tl;
   TextView Switched;
   LinearLayout LLay;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String D=intent.getStringExtra("Yes");


       Remove_numbers PJ=new Remove_numbers(D);
        input=PJ.remove();
        table=new Cell[9][9];
        tl=new TableLayout(this);
        for (int i=0;i<9;i++){
            TableRow tr=new TableRow(this);
            for (int j=0;j<9;j++){
                table[i][j]=new Cell(input[i][j],this,j,i,PJ);
                tr.addView(table[i][j].bt);
            }tl.addView(tr);
        }
        setContentView(tl);
        tl.setShrinkAllColumns(true);
        tl.setStretchAllColumns(true);
        Switched=new TextView(this);
        LLay=new LinearLayout(this);
        LLay.setOrientation(LinearLayout.VERTICAL);
        tl.setBackgroundColor(Color.WHITE);
        LLay.addView(Switched);
        Switched.setText("GameOn");
    }
}