package com.example.me.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText choice1, choice2;
    String choice;
    Button roll, send, timerBtn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Context context = this;

        timerBtn = (Button) findViewById(R.id.timer);
        choice1 = (EditText) findViewById(R.id.choice1);
        choice2 = (EditText) findViewById(R.id.choice2);
        result = (TextView) findViewById(R.id.result);
        roll = (Button) findViewById(R.id.roll);

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNext();
            }
        });

        Toast.makeText(this, "Welcome!", Toast.LENGTH_LONG).show();

        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String messageText = "Hello there! I am testing my new app :D";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, messageText);
                String chooserTitle = getString(R.string.chooser);
                Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
                startActivity(chosenIntent);
            }
        });

        timerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TimerActivity.class);
                startActivity(intent);
            }
        });

    }

    public void roll() {
        Random rand = new Random();
        int num = rand.nextInt(2) + 1;

        switch(num) {
            case 1:
                choice = choice1.getText().toString();
                break;
            case 2:
                choice = choice2.getText().toString();
                break;
            default:
                choice = choice1.getText().toString();
                break;
        }

        result.setText(choice);
        Toast.makeText(this, "You have got " + choice + "!", Toast.LENGTH_LONG).show();
    }

//    void timer() {
//
//        new CountDownTimer(2000, 1000) {
//
//            public void onTick ( long millisUntilFinished){
//                result.setText("" + millisUntilFinished / 1000);
//            }
//
//            public void onFinish() {
//                roll();
//            }
//
//        }.start();
//
//    }

    void gotoNext() {
        Intent intent = new Intent(this, Result.class);
        ArrayList list = new ArrayList();
        list.add(choice);
        intent.putExtra("data", list);
        this.startActivity(intent);
        finish();
    }

}
