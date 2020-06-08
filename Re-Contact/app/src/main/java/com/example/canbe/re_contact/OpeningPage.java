package com.example.canbe.re_contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OpeningPage extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "asdf";

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_page);
        //final EditText username = (EditText) findViewById(R.id.editText);
        //final EditText password = (EditText) findViewById(R.id.editText2);
        //Button login = (Button) findViewById(R.id.button);
        //Button signup = (Button) findViewById(R.id.button2);
        //login.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {

           // }
       // });
    }
    public void openProfilePage(View view) {

        EditText editText = (EditText) findViewById(R.id.editText);
        String username = editText.getText().toString();

        EditText a = (EditText) findViewById(R.id.editText2);
        String pass = a.getText().toString();

        String password = helper.searchPassword(username);
        if (pass.equals(password))
        {
            Intent intent = new Intent(this, ProfilePage.class);
            intent.putExtra(EXTRA_MESSAGE, username);
            startActivity(intent);
        }
        else
        {
            Toast temp = Toast.makeText(OpeningPage.this, "Username and Password don't match!", Toast.LENGTH_SHORT);
            temp.show();
        }


    }

    public void openSignupPage(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
