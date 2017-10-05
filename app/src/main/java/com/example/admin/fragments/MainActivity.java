package com.example.admin.fragments;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements YellowFragment.OnFragmentInteractionListener{

    private static final String BLUE_FRAG_TAG = "BlueFragTag";
    private static final String YELLOW_FRAG_TAG = "YellowFrag";
    private static final String GREEN_FRAG_TAG = "GreenFrag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addFragment(View view) {

        switch( view.getId() ) {
            case R.id.btnAddFragment:

                //fragment transaction objects let you add fragments to activities.
                //This should only be done in activities.
                getSupportFragmentManager().beginTransaction()
                        .add( R.id.flLayout, new BlueFragment(), BLUE_FRAG_TAG)
                        .addToBackStack( BLUE_FRAG_TAG)
                        .commit();
                        //where to put it, what to put, what to call it.
                        //addToBackStack is optional.

                break;
            case R.id.btnAddGreenFragment:

                GreenFragment greenFragment = GreenFragment.newInstance( "first", "second" );

                getSupportFragmentManager().beginTransaction()
                        .add( R.id.flLayout, greenFragment, GREEN_FRAG_TAG )
                        .addToBackStack( GREEN_FRAG_TAG )
                        .commit();

                break;
            case R.id.btnAddYellowFragment:

                YellowFragment yellowFragment = YellowFragment.newInstance( "String", "Data" );
                getSupportFragmentManager().beginTransaction()
                        .add( R.id.flLayoutYellow, yellowFragment, YELLOW_FRAG_TAG )
                        .commit();

                break;
            case R.id.btnAddTextToYellowFragment:

                YellowFragment fragment = (YellowFragment) getSupportFragmentManager()
                        .findFragmentByTag( YELLOW_FRAG_TAG );

                fragment.setText( "Text" );

                RedFragment frag2 = (RedFragment) getSupportFragmentManager().findFragmentById( R.id.fRed );

                frag2.showToast( "Toast" );

                break;
            case R.id.btnRemoveBlueFragment:

                BlueFragment blueFragment = (BlueFragment) getSupportFragmentManager()
                        .findFragmentByTag( BLUE_FRAG_TAG );

                getSupportFragmentManager().beginTransaction().remove( blueFragment ).commit();

                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this, "yellow frag", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}

/*
Fragments are used in android to act like a sub activity. used when you have a re-usable part of the
UI. It can be saved in a fragment and used in multiple activities. Cannot exist on it's own.
Fragments without UI are headless fragments. Just contain behavior.

Phone app. Click on Email, open details of the email. List of emails are shown in fragment. Contents
of email are another fragment. Same app on tablet could load both fragments on the screen at the
same time.

In addition to the activity life cycle methods, fragments have 5 more.

 */