package com.example.canbe.re_contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by canbe on 6.05.2017.
 */

public class SignUp extends AppCompatActivity{
    DatabaseHelper helper = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Intent intent = getIntent();

    }
    public void onSignUpClick(View view){
        if(view.getId() == R.id.button3){
            EditText name = (EditText) findViewById(R.id.SUname);
            EditText email = (EditText) findViewById(R.id.SUmail);
            EditText uname = (EditText) findViewById(R.id.SUuname);
            EditText password = (EditText) findViewById(R.id.SUpassword);
            EditText password2 = (EditText) findViewById(R.id.SUpassword2);
            EditText age = (EditText) findViewById(R.id.SUage);
            EditText job = (EditText) findViewById(R.id.SUjob);
            EditText workplace = (EditText) findViewById(R.id.SUworkplace);
            EditText hobbies = (EditText) findViewById(R.id.SUhobbies);
            //EditText facebook = (EditText) findViewById(R.id.SUfacebook);
            EditText twitter = (EditText) findViewById(R.id.SUtwitter);
            EditText phoneNum = (EditText) findViewById(R.id.SUphone);


            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String passwordstr = password.getText().toString();
            String password2str = password2.getText().toString();
            String agestr = age.getText().toString();
            String jobstr = job.getText().toString();
            String workplacestr = workplace.getText().toString();
            String hobbiesstr = hobbies.getText().toString();
          //  String facebookstr = facebook.getText().toString();
            String twitterstr = twitter.getText().toString();
            int num = Integer.parseInt(phoneNum.getText().toString());

            if(!passwordstr.equals(password2str))
            {
                Toast pass = Toast.makeText(SignUp.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else if (helper.isUsernameUsed(unamestr)){
                Toast pass = Toast.makeText(SignUp.this, "Username is already taken!", Toast.LENGTH_SHORT);
                pass.show();
            }

            else
            {
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPassword(passwordstr);
                c.setHobbies(hobbiesstr);
               // c.setFacebook(facebookstr);
                c.setTwitter(twitterstr);
                c.setAge(agestr);
                c.setJob(jobstr);
                c.setWorkplace(workplacestr);
                c.setPhoneNum(num);

                helper.insertContact(c);
                Intent intent = new Intent(this, OpeningPage.class);
                startActivity(intent);
            }


        }
    }
}
