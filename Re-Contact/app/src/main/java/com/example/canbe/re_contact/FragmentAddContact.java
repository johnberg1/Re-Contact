package com.example.canbe.re_contact;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAddContact extends Fragment {

    View view;

    public FragmentAddContact() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(container!= null){
            container.removeAllViews();
        }
        view = inflater.inflate(R.layout.fragment_fragment_add_contact, container, false);
        Button mButton = (Button)view.findViewById(R.id.button4);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View nfc = v.findViewById(R.id.nfc_activity);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
