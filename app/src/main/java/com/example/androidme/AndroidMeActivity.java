package com.example.androidme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.androidme.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        // Create the fragments only if there was no fragments stored before
        if (savedInstanceState == null) {
            // Getting the different instances of the BodyPartFragment fragment for the different
            // body parts
            BodyPartFragment headFragment = new BodyPartFragment();
            BodyPartFragment bodyFragment = new BodyPartFragment();
            BodyPartFragment legsFragment = new BodyPartFragment();

            // Setting the images and imageId for the particular fragments
            headFragment.setImages(AndroidImageAssets.getHeads());
            int headIndex = getIntent().getIntExtra("headIndex", 0);
            headFragment.setImageId(headIndex);

            bodyFragment.setImages(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            bodyFragment.setImageId(bodyIndex);

            legsFragment.setImages(AndroidImageAssets.getLegs());
            int legsIndex = getIntent().getIntExtra("legsIndex", 0);
            legsFragment.setImageId(legsIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();

            // Adding the fragments to the FragmentManager
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .add(R.id.body_container, bodyFragment)
                    .add(R.id.legs_container, legsFragment)
                    .commit();
        }
    }
}