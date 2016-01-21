package com.knode.johnny.golfscorecard.adapters;

import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.knode.johnny.golfscorecard.R;
import com.knode.johnny.golfscorecard.model.Hole;

/**
 * Created by Johnny on 20/01/2016.
 */
public class Scoreboard extends BaseAdapter {

    private final Context mContext;
    private final Hole[] mHoles;

    public  Scoreboard (Context context, Hole[] holes){
        mContext = context;
        mHoles = holes;

    }

    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int position) {
        return mHoles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null)
        {
         convertView = LayoutInflater.from(mContext).
                 inflate(R.layout.scoreboard_list_item, null); //this populates the view if the it is null
         holder = new ViewHolder();
         holder.holeNumber = (TextView) convertView.findViewById(R.id.holeNumberItem);
         holder.strokeCount = (TextView) convertView.findViewById(R.id.scoreItem);
         holder.minusButton = (Button) convertView.findViewById(R.id.minusButton);
         holder.plusButton = (Button) convertView.findViewById(R.id.plusButton);

            convertView.setTag(holder);//
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();// get the holder from the convertView if it's null
        }


        holder.holeNumber.setText(mHoles[position].getmHole());
        holder.strokeCount.setText(mHoles[position].getmScore()+"");
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedStrokeCount = mHoles[position].getmScore() - 1;
                if (updatedStrokeCount < 0) updatedStrokeCount = 0;
                mHoles[position].setmScore(updatedStrokeCount);
                holder.strokeCount.setText(updatedStrokeCount + "");
            }
        });
        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedStrokeCount = mHoles[position].getmScore() + 1;
                mHoles[position].setmScore(updatedStrokeCount);
                holder.strokeCount.setText(updatedStrokeCount+"");
            }
        });
        return convertView;
    }

    private static class ViewHolder {

        TextView holeNumber;
        TextView strokeCount;
        Button minusButton;
        Button plusButton;
    }
}
