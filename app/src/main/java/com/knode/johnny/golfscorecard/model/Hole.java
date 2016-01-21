package com.knode.johnny.golfscorecard.model;

/**
 * Created by Johnny on 20/01/2016.
 */
public class Hole {

    private int mScore;
    private String mHole;

    public Hole(String holeNo, int strokeCount){
        mHole = holeNo;
        mScore = strokeCount;
    }
    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }

    public String getmHole() {
        return mHole;
    }

    public void setmHole(String mHole) {
        this.mHole = mHole;
    }



}
