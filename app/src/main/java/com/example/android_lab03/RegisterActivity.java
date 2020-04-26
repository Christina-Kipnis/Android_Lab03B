package com.example.android_lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private String MALE = "Mr.";
    private String FEMALE = "Miss/ Mrs.";
    private String genderStr = "";

    private EditText editFirstName;
    private EditText editLastName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle("Register");
        editFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editLastName = (EditText) findViewById(R.id.editTextLastName);
    }

    public void setGender(View view) {
        switch(view.getId()){
            case R.id.radioButtonMale:
                genderStr = MALE;
                break;
            case R.id.radioButtonFemale:
                genderStr = FEMALE;
                break;
        }//switch
    }//setGender


    public void updateMainPage(View view) {
        String firstNameTemp = editFirstName.getText().toString();
        String lastNameTemp = editLastName.getText().toString();

        //Check if strings are empty
        if(TextUtils.isEmpty(firstNameTemp) || TextUtils.isEmpty(lastNameTemp) || TextUtils.isEmpty(genderStr))
        {
            Toast.makeText(getApplicationContext(), "The strings cannot be empty", Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent updateIntent = new Intent();
            updateIntent.putExtra("firstName", firstNameTemp);
            updateIntent.putExtra("lastName", lastNameTemp);
            updateIntent.putExtra("gender", genderStr);

            setResult(RESULT_OK, updateIntent);
            finish();
        }
    }

}
