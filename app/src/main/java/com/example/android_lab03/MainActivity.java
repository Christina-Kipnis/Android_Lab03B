package com.example.android_lab03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REGISTER_ACTIVITY_REQUEST_CODE = 0;
    private TextView mainText;
    private Button mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.mainTextView);
        mainButton = (Button) findViewById(R.id.registerButton);

    }


    public void registerFunc(View view) {
        Intent registerIntent = new Intent(this, RegisterActivity.class);
        startActivityForResult(registerIntent, REGISTER_ACTIVITY_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String gender = data.getStringExtra("gender");
        String firstName = data.getStringExtra("firstName");
        String lastName = data.getStringExtra("lastName");

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REGISTER_ACTIVITY_REQUEST_CODE && resultCode==RESULT_OK){
            mainText.setText("Welcome back " + gender + " " + firstName + ", " + lastName);
            mainButton.setText("again...");
        }
    }
}
