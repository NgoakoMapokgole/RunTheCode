package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnPlay;

    private RadioGroup rpgLevel;
    private RadioButton rbtnSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btnPlay=(Button) findViewById(R.id.btnPlay);

        rpgLevel=(RadioGroup)findViewById(R.id.rgpLevel);
    btnPlay.setOnClickListener(new View.OnClickListener() {


        @Override
        public void onClick(View v) {
            String Yes=new String();
            int Selected=rpgLevel.getCheckedRadioButtonId();
            rbtnSelected=(RadioButton)findViewById(Selected);
            if (rbtnSelected.getText()==null){
System.out.println("Please select the level you want");
                return;
            }
            Yes=rbtnSelected.getText().toString();
            openMainActivity2(Yes);
        }
    });
    }
   public void openMainActivity2(String Yes){
        Intent intent=new Intent(this,MainActivity2.class);
        intent.putExtra("Yes",Yes);

        startActivity(intent);
   }
}