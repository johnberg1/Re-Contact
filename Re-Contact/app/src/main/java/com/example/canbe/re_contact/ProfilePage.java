package com.example.canbe.re_contact;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by canbe on 30.04.2017.
 */

public class ProfilePage extends AppCompatActivity {
    final static String EXTRA_USERNAME = "username";
    private String[] titles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    DatabaseHelper helper = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        Intent intent = getIntent();
        String username = intent.getStringExtra(OpeningPage.EXTRA_MESSAGE);




        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        final FragmentMyProfile fragment_myProfile = new FragmentMyProfile();
        ft.replace(R.id.content_frame, fragment_myProfile);
        ft.commit();
        mTitle = "My Profile";
        getSupportActionBar().setTitle(mTitle);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open,
                R.string.drawer_close) {

            // drawer kapatıldığında tetiklenen method
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            // drawer açıldığında tetiklenen method
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("Re-Contact");
                invalidateOptionsMenu();
            }


        };
        // Açılıp kapanmayı dinlemek için register
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        // Navigationdaki Drawer için listview adapteri
        ArrayAdapter adapter = new ArrayAdapter(getBaseContext(),
                R.layout.drawer_list_item, getResources().getStringArray(R.array.menu));

        // adapteri listviewe set ediyoruz
        mDrawerList.setAdapter(adapter);

        // actionbar home butonunu aktif ediyoruz
        getSupportActionBar().setHomeButtonEnabled(true);

        // navigationu tıklanabilir hale getiriyoruz
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view,int position, long id) {

                // itemleri arraya tekrar aldık
                String[] menuItems = getResources().getStringArray(R.array.menu);

                // dinamik title yapmak için actionbarda tıklananın titlesi görünecek
                mTitle = menuItems[position];

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();

                // fragmenti contente yerleştirme.
                if(position==0){
                    FragmentMyProfile fragment_myProfile = new FragmentMyProfile();
                    ft.replace(R.id.content_frame, fragment_myProfile);
                    ft.commit();
                }else if(position==1){
                    FragmentMyContacts fragmentMyContacts = new FragmentMyContacts();
                    ft.replace(R.id.content_frame, fragmentMyContacts);
                    ft.commit();
                }else if(position==2){
                    FragmentAddContact fragmentAddContact = new FragmentAddContact();
                    ft.replace(R.id.content_frame, fragmentAddContact);
                    ft.commit();
                }
                mDrawerLayout.closeDrawer(mDrawerList);

            }
        });
    }
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //draweri sadece swipe ederek açma yerine sol tepedeki butona basarak açmak için
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void openEditProfile(View view) {
        Intent intent = new Intent(this, EditProfile.class);

        intent.putExtra(EXTRA_USERNAME, helper.getUsername());
        startActivity(intent);
    }



}