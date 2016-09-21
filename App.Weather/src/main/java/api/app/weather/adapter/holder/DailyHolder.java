package api.app.weather.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import api.app.weather.R;

/**
 * Created by Fischer on 2016/9/21.
 */
public class DailyHolder extends RecyclerView.ViewHolder {

    public ImageView mIvCondIconNow,mIvCondIconNext;
    public TextView mTvCondInfo,mTvTmp,mTvWindDirDegree,mTvWindSpeed,mTvTime,mTvAstro;

    public DailyHolder(View itemView) {
        super(itemView);
        bindViews();


    }

    private void bindViews(){
        mIvCondIconNow = (ImageView) itemView.findViewById(R.id.iv_cond_icon_now);
        mIvCondIconNext = (ImageView) itemView.findViewById(R.id.iv_cond_icon_next);
        mTvCondInfo = (TextView) itemView.findViewById(R.id.tv_cond_info);
        mTvTmp = (TextView) itemView.findViewById(R.id.tv_tmp);
        mTvWindDirDegree = (TextView) itemView.findViewById(R.id.tv_wind_dir_degree);
        mTvWindSpeed = (TextView) itemView.findViewById(R.id.tv_wind_speed);
        mTvTime = (TextView) itemView.findViewById(R.id.tv_time);
        mTvAstro = (TextView) itemView.findViewById(R.id.tv_astro);
    }
}
