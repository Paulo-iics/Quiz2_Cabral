package com.example.quiz2_cabral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox b1,b2, b3, b4, b5, b6, b7, b8;
    EditText c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.checkBox);
        b2 = findViewById(R.id.checkBox2);
        b3 = findViewById(R.id.checkBox3);
        b4 = findViewById(R.id.checkBox4);
        b5 = findViewById(R.id.checkBox5);
        b6 = findViewById(R.id.checkBox6);
        b7 = findViewById(R.id.checkBox7);
        b8 = findViewById(R.id.checkBox8);
        c = findViewById(R.id.editText);
    }

    public void checkBox(View v){
        String data1 = b1.getText().toString();
        String data2 = b2.getText().toString();
        String data3 = b3.getText().toString();
        String data4 = b4.getText().toString();
        String data5 = b5.getText().toString();
        String data6 = b6.getText().toString();
        String data7 = b7.getText().toString();
        String data8 = b8.getText().toString();
        String comment = c.getText().toString();

        FileOutputStream writer = null;
        try{
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            if (b1.isChecked()){
                writer.write(data1.getBytes());
            }if (b1.isChecked()){
                writer.write(data2.getBytes());
            }if (b1.isChecked()){
                writer.write(data3.getBytes());
            }if (b1.isChecked()){
                writer.write(data4.getBytes());
            }if (b1.isChecked()){
                writer.write(data5.getBytes());
            }if (b1.isChecked()){
                writer.write(data6.getBytes());
            }if (b1.isChecked()){
                writer.write(data7.getBytes());
            }if (b1.isChecked()){
                writer.write(data8.getBytes());
            }
            writer.write(comment.getBytes());



        } catch (FileNotFoundException e) {
            Log.d("error", "File not found.");

        } catch (IOException e) {
            Log.d("error", "IO error...");
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File not found.");
            }
        }
        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
    }


    public void nextPage(View v){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
