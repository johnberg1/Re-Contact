package com.example.canbe.re_contact;

/**
 * Created by Berkay on 12.05.2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mshrestha on 7/23/2014.
 */
public class NFCRecieve extends AppCompatActivity {

    private ArrayList<String> messagesReceivedArray = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc_display);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            Parcelable[] rawMessages = intent.getParcelableArrayExtra(
                    NfcAdapter.EXTRA_NDEF_MESSAGES);
            if (rawMessages != null) {
                messagesReceivedArray.clear();
                NdefMessage receivedMessage = (NdefMessage) rawMessages[0];
                NdefRecord[] attachedRecords = receivedMessage.getRecords();

                for (NdefRecord record : attachedRecords) {
                    String string = new String(record.getPayload());
                    //Make sure we don't pass along our AAR (Android Application Record)
                    if (string.equals(getPackageName())) {
                        continue;
                    }
                    messagesReceivedArray.add(string);
                }
                Contact newContact = new Contact();
                newContact.setInfo(messagesReceivedArray);
                DatabaseHelper db = new DatabaseHelper(this);
                db.insertContact(newContact);

                Toast.makeText(this, "Received the contact.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Received Blank Parcel", Toast.LENGTH_LONG).show();
            }
        }
    }
}
