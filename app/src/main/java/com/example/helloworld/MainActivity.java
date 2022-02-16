package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText send_Name;
    private Button send_Submit;
    private Button send_Clear;
    private CheckBox box1, box2, box3, box4, box5;
    private TextView print_len;
    private String prev="Null",curr="Null";
    private String ans = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        curr = "Create";
        String msg = "State of the Activity 1 is "+curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
        send_Name = (EditText) findViewById(R.id.name);
        box1 = (CheckBox)findViewById(R.id.precaution1);
        box2 = (CheckBox)findViewById(R.id.precaution2);
        box3 = (CheckBox)findViewById(R.id.precaution3);
        box4 = (CheckBox)findViewById(R.id.precaution4);
        box5 = (CheckBox)findViewById(R.id.precaution5);
        send_Submit = (Button)findViewById(R.id.submit);
        send_Clear = (Button)findViewById(R.id.clear);
        print_len = (TextView)findViewById(R.id.displaysafe);

        send_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer list_precautions = new StringBuffer();
                if(box1.isChecked()){
                    list_precautions.append("Wearing a Mask when Outside\n\n\n");
                }
                if(box2.isChecked()){
                    list_precautions.append("Washing Hands Frequently\n\n\n");
                }
                if(box3.isChecked()){
                    list_precautions.append("Maintaining 2 Feet Distance\n\n\n");
                }
                if(box4.isChecked()){
                    list_precautions.append("Covering Nose and Mouth while Sneezing and Coughing\n\n\n");
                }
                if(box5.isChecked()){
                    list_precautions.append("Taking Health Diets\n\n\n");
                }
                String name = send_Name.getText().toString();
                String r = list_precautions.toString();
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("list_precautions", r);
                i.putExtra( "name",name);
                startActivityForResult(i, 1);
            }
        });

        send_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_Name.setText("");
                box1.setChecked(false);
                box2.setChecked(false);
                box3.setChecked(false);
                box4.setChecked(false);
                box5.setChecked(false);
                print_len.setText("");
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ans = "";
        print_len.setText("\n\nYou didnot Press Button to Check if Safe or Not\n\n\n\n");
        if (requestCode == 1){
            if (resultCode == RESULT_OK && data!=null) {
                int result = data.getIntExtra("ans",0);
                if (result == 1){
                    ans = ans+"\nCongratulations! You are Safe.";
                }
                else{
                    ans = ans+"\nBe Aware! You are not Safe.";
                }
                print_len.setText(ans);
            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("answer", print_len.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        print_len.setText(savedInstanceState.getString("answer"));
    }
    @Override
    protected void onStart() {
        super.onStart();
        curr = "Start";
        String msg = "State of the Activity 1 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
    @Override
    protected void onResume() {
        super.onResume();
        curr = "Resume";
        String msg = "State of the Activity 1 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
    @Override
    protected void onPause() {
        super.onPause();
        curr = "Pause";
        String msg = "State of the Activity 1 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
    @Override
    protected void onStop() {
        super.onStop();
        curr = "Stop";
        String msg = "State of the Activity 1 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        curr = "Restart";
        String msg = "State of the Activity 1 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        curr = "Destroy";
        String msg = "State of the Activity 1 changed from " + prev + " to " + curr;
        Log.i("Activity_Status",msg);
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        prev = curr;
    }
}

