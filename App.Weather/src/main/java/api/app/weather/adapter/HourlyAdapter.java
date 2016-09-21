package api.app.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import api.app.weather.R;
import api.app.weather.adapter.holder.HourlyHolder;
import entity.weather.HourlyForecast;

/**
 * Created by Fischer on 2016/9/21.
 */
public class HourlyAdapter extends RecyclerView.Adapter<HourlyHolder> {

    private List<HourlyForecast> mHourlyForecastList;

    public HourlyAdapter() {
        this.mHourlyForecastList = new ArrayList<>();
    }

    public void update(List<HourlyForecast> newDatas){
        mHourlyForecastList = newDatas;
        notifyDataSetChanged();
    }

    @Override
    public HourlyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hourly,null);
        return new HourlyHolder(view);
    }

    @Override
    public void onBindViewHolder(HourlyHolder holder, int position) {
        HourlyForecast info = mHourlyForecastList.get(position);
        String time = TextUtils.isEmpty(info.date)?"":info.date.split(" ").length>1?info.date.split(" ")[1]:info.date;
        holder.mTvTime.setText(time);
        holder.mTvTmp.setText(info.tmp+"°");
        holder.mTvWindDirDegree.setText(info.wind.dir+" "+info.wind.sc);
        holder.mTvWindSpeed.setText(info.wind.spd+" kmph");
    }

    @Override
    public int getItemCount() {
        return mHourlyForecastList.size();
    }
}
