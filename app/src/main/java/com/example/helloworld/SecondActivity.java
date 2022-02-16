package com.example.helloworld;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView received_msg;
    private Button safe_submit;
    private TextView welcome_msg;
    String prev = "Null", curr = "Null";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        curr = "Create";
        String msg = "State of the Activity 2 is "+curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(SecondActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
        welcome_msg = (TextView)findViewById(R.id.welcome);
        received_msg = (TextView)findViewById(R.id.selectedprecautions);
        Intent intent = getIntent();
        String print = intent.getStringExtra("list_precautions");
        String name = intent.getStringExtra("name");
        String display = "Hello "+ name +"! These are the precautions Selected By you.\n\n\n\n";
        welcome_msg.setText(display);
        received_msg.setText(print);
        safe_submit = (Button)findViewById(R.id.safe);
        safe_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] sen = print.split("\n\n\n");
                int ans;
                if (sen.length == 5){
                    ans = 1;
                }
                else{
                    ans = 0;
                }
                Intent result_intent = new Intent();
                result_intent.putExtra("ans", ans);
                setResult(RESULT_OK,result_intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        curr = "Start";
        String msg = "State of the Activity 2 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(SecondActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
    @Override
    protected void onResume() {
        super.onResume();
        curr = "Resume";
        String msg = "State of the Activity 2 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(SecondActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
    @Override
    protected void onPause() {
        super.onPause();
        curr = "Pause";
        String msg = "State of the Activity 2 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(SecondActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
    @Override
    protected void onStop() {
        super.onStop();
        curr = "Stop";
        String msg = "State of the Activity 2 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(SecondActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        curr = "Restart";
        String msg = "State of the Activity 2 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(SecondActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        curr = "Destroy";
        String msg = "State of the Activity 2 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(SecondActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
}
