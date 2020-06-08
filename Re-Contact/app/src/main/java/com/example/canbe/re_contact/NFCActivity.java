package com.example.canbe.re_contact;

/**
 * Created by Berkay on 12.05.2017.
 */

import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.util.ArrayList;


public class NFCActivity extends AppCompatActivity implements NfcAdapter.CreateNdefMessageCallback {

    private TextView data;
    private EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);
        data = (TextView) findViewById(R.id.text_view);
        msg = (EditText) findViewById(R.id.edit_text_field) ;

        NfcAdapter mAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mAdapter == null) {
            msg.setText("Sorry this device does not have NFC.");
            return;
        }

        if (!mAdapter.isEnabled()) {
            Toast.makeText(this, "Please enable NFC via Settings.", Toast.LENGTH_LONG).show();
        }

        mAdapter.setNdefPushMessageCallback(this, this);
    }

    /**
     * Ndef Record that will be sent over via NFC
     * @param nfcEvent
     * @return
     */
    @Override
    public NdefMessage createNdefMessage(NfcEvent nfcEvent) {
        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<String> message = db.getContact(db.getUsername()).getInfo();
        NdefRecord[] records = new NdefRecord[message.size()];

        for (int i = 0; i < message.size(); i++){
            byte[] payload = message.get(i).getBytes(Charset.forName("UTF-8"));

            NdefRecord record = new NdefRecord(
                    NdefRecord.TNF_WELL_KNOWN,  //Our 3-bit Type name format
                    NdefRecord.RTD_TEXT,        //Description of our payload
                    new byte[0],                //The optional id for our Record
                    payload);                   //Our payload for the Record

            records[i] = record;
        }

        return new NdefMessage(records);
    }
}
