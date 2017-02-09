package edu.wpi.alcowatch.alcowatch;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.wpi.alcowatch.alcowatch.User.Profile;

public class ProfileActivity extends AppCompatActivity {

    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


    }

    public void openEmergencyContactSelectionMenu(View view)
    {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent,1 );
    }

    public void setMale(View view)
    {
        gender = "male";
    }

    public void setFemale(View view)
    {
        gender = "female";
    }

    public void submitProfile(View view)
    {
        //Validate that all form inputs have acceptable inputs;

        EditText heightInput = (EditText) findViewById(R.id.profileHeightInput);
        EditText weightInput = (EditText) findViewById(R.id.profileWeightInput);
        EditText ageInput = (EditText) findViewById(R.id.profileAgeInput);

        if (heightInput.getText().toString() == "" || weightInput.getText().toString() == "" || ageInput.getText().toString() == "" || gender == "") {
            Toast invalidCredentials = new Toast(this);

            Toast.makeText(this,R.string.invalid_credentials,Toast.LENGTH_LONG);
            invalidCredentials.show();

            return;
        }

        Profile p = new Profile(gender, Integer.parseInt(ageInput.getText().toString()), Integer.parseInt(weightInput.getText().toString()), Integer.parseInt(heightInput.getText().toString()));
        
    }


}
