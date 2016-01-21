package com.knode.johnny.golfscorecard.ui;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.knode.johnny.golfscorecard.R;
import com.knode.johnny.golfscorecard.adapters.Scoreboard;
import com.knode.johnny.golfscorecard.model.Hole;

public class MainActivity extends ListActivity {
    private Hole[] mHoles = new Hole[18];
    private Scoreboard mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int strokes  =0;
        for( int i = 0 ; i < mHoles.length; i++){
            mHoles[i] = new Hole ("Hole " + (i + 1) + " : ", strokes);
        }

        mListAdapter = new Scoreboard(this , mHoles);
        setListAdapter(mListAdapter);
    }
}
