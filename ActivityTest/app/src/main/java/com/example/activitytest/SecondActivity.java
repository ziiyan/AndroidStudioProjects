package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity", "Task id is " + getTaskId());
        setContentView(R.layout.second_layout);
        Button button2 = (Button) findViewById((R.id.button_2));
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public void onBackPressed() {
//        Intent intent = new Intent();
//        intent.putExtra("data_return", "Hello FirstActivity");
//        setResult(RESULT_OK, intent);
//        finish();
//    }
}
