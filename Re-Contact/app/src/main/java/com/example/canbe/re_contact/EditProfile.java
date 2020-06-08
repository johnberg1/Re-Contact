package com.example.canbe.re_contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by canbe on 8.05.2017.
 */

public class EditProfile extends AppCompatActivity {
    String username;
    DatabaseHelper helper = new DatabaseHelper(this);
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
        Intent intent = getIntent();
        username = intent.getStringExtra(ProfilePage.EXTRA_USERNAME);

    }
    public void onSaveClick(View view){
        if (view.getId() == R.id.button3){
            EditText name = (EditText) findViewById(R.id.EPname);
            EditText age = (EditText) findViewById(R.id.EPage);
            EditText phoneNum = (EditText) findViewById(R.id.EPphoneNum);
            EditText email = (EditText) findViewById(R.id.EPmail);
            EditText hobbies = (EditText) findViewById(R.id.EPhobbies);
            EditText job = (EditText) findViewById(R.id.EPjob);
            EditText workplace = (EditText) findViewById(R.id.EPworkplace);

            EditText twitter = (EditText) findViewById(R.id.EPtwitter);



            String namestr = name.getText().toString();
            String agestr = age.getText().toString();
            int phonestr = Integer.parseInt(phoneNum.getText().toString());
            String emailstr = email.getText().toString();
            String hobbiesstr = hobbies.getText().toString();
            String jobstr = job.getText().toString();
            String workplacestr = workplace.getText().toString();
            String twitterstr = twitter.getText().toString();

            Contact contact = new Contact();
            contact.setName(namestr);
            contact.setUname(username);
            contact.setAge(agestr);
            contact.setPhoneNum(phonestr);
            contact.setEmail(emailstr);
            contact.setHobbies(hobbiesstr);
            contact.setJob(jobstr);
            contact.setWorkplace(workplacestr);
            contact.setTwitter(twitterstr);

            helper.update(contact);

            Intent intent = new Intent(this, ProfilePage.class);
            startActivity(intent);
        }
    }
}
