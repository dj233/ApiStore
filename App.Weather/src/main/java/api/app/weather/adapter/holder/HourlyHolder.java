package api.app.weather.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import api.app.weather.R;

/**
 * Created by Fischer on 2016/9/21.
 */
public class HourlyHolder extends RecyclerView.ViewHolder {

    public TextView mTvTmp,mTvWindDirDegree,mTvWindSpeed,mTvTime;

    public HourlyHolder(View itemView) {
        super(itemView);
        bindViews();


    }

    private void bindViews(){
        mTvTmp = (TextView) itemView.findViewById(R.id.tv_tmp);
        mTvWindDirDegree = (TextView) itemView.findViewById(R.id.tv_wind_dir_degree);
        mTvWindSpeed = (TextView) itemView.findViewById(R.id.tv_wind_speed);
        mTvTime = (TextView) itemView.findViewById(R.id.tv_time);
    }
}
