package com.example.quiz2_cabral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    TextView sub, com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FileInputStream reader = null;
        sub = findViewById(R.id.textView10);

        try {
            int token;
            reader = openFileInput("data1.txt");
            String msg = "";
            while ((token=reader.read()) !=-1){
                msg= msg+(char)token;
            }

            reader.close();
            try{
                String[] list = msg.split(",");
                sub.setText(list[0]);
            }catch (Exception E){
                Log.d("error", "Empty Checkbox.");
            }

            /*String list[] = msg.split(" ");
            ((TextView) (findViewById(R.id.editText2))).setText(list[0]);
            ((TextView) (findViewById(R.id.editText2))).setText(list[1]);
            ((TextView) (findViewById(R.id.editText2))).setText(list[2]);
            ((TextView) (findViewById(R.id.editText2))).setText(list[3]);
            ((TextView) (findViewById(R.id.editText2))).setText(list[4]);
            ((TextView) (findViewById(R.id.editText2))).setText(list[5]);
            ((TextView) (findViewById(R.id.editText2))).setText(list[6]);
            ((TextView) (findViewById(R.id.editText2))).setText(list[7]);*/
        } catch (IOException e) {
            Log.d("error", "IO error...");
        }
    }
    public void send(View v){
        Toast.makeText(this, "Request Sent...", Toast.LENGTH_LONG).show();
    }
    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
