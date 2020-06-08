package com.example.canbe.re_contact;


import android.database.DataSetObserver;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMyContacts extends Fragment{

    DatabaseHelper db;
    ArrayList<String> userNames, tmp;
    View view;
    ExpandableListView lw;
    HashMap<String , List<String>> userProfiles;
    ContactListAdapter adapter;

    public FragmentMyContacts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(container!= null){
            container.removeAllViews();
        }
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_fragment_my_contacts, container, false);
        lw = (ExpandableListView) view.findViewById(R.id.list);
        db = new DatabaseHelper(this.getActivity());

        userNames = db.getAllUsername();
        userProfiles = new HashMap();

        for(int i = 0; i < userNames.size(); i++ ){
            tmp = db.getContact(userNames.get(i)).getInfo();
            if(tmp.get(9).equals("false")) {
                userProfiles.put(userNames.get(i), tmp);
            }
        }

        adapter = new ContactListAdapter(this.getActivity(), userNames, userProfiles);
        if(!userProfiles.isEmpty()){
            lw.setAdapter(adapter);
        }
        return view;
    }
}
