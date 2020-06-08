package com.example.canbe.re_contact;


import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMyProfile extends Fragment {


    public FragmentMyProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(container != null){
            container.removeAllViews();
        }
        // Inflate the layout for this fragment
        DatabaseHelper helper = new DatabaseHelper(getActivity());
        View view = inflater.inflate(R.layout.fragment_fragment__my_profile,container, true);
        TextView textView = (TextView) view.findViewById(R.id.DisplayName);
        textView.setText(helper.getName());

        TextView age = (TextView) view.findViewById(R.id.DisplayAge);
        age.setText(helper.getAge());

        TextView phoneNum = (TextView) view.findViewById(R.id.DisplayPhoneNum);
        phoneNum.setText("" + helper.getPhoneNum());

        TextView job = (TextView) view.findViewById(R.id.DisplayJob);
        job.setText(helper.getJob() + "," + helper.getWorkplace());

        TextView email = (TextView) view.findViewById(R.id.DisplayEmail);
        email.setText(helper.getEmail());

        TextView hobbies = (TextView) view.findViewById(R.id.DisplayHobbies);
        hobbies.setText(helper.getHobbies());

        TextView facebook = (TextView) view.findViewById(R.id.DisplayFacebook);
        facebook.setText(helper.getFacebook());

        TextView twitter = (TextView) view.findViewById(R.id.DisplayTwitter);
        twitter.setText(helper.getTwitter());
        return inflater.inflate(R.layout.fragment_fragment__my_profile, container, false);
    }

}
