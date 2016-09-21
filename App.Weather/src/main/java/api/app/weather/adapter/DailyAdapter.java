package api.app.weather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import api.app.weather.R;
import api.app.weather.adapter.holder.DailyHolder;
import api.dao.DatabaseMaster;
import api.dao.WeatherIcon;
import entity.weather.DailyForecast;
import entity.weather.HourlyForecast;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Fischer on 2016/9/21.
 */
public class DailyAdapter extends RecyclerView.Adapter<DailyHolder> {

    private Context mContext;
    private List<DailyForecast> mDailyForecastList;

    public DailyAdapter(Context context) {
        this.mContext = context;
        this.mDailyForecastList = new ArrayList<>();
    }

    public void update(List<DailyForecast> newDatas){
        mDailyForecastList = newDatas;
        notifyDataSetChanged();
    }

    @Override
    public DailyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily,null);
        return new DailyHolder(view);
    }

    @Override
    public void onBindViewHolder(final DailyHolder holder, int position) {
        DailyForecast info = mDailyForecastList.get(position);
        holder.mTvCondInfo.setText(info.cond.txt_d+"转"+info.cond.txt_n);
        holder.mTvTime.setText(info.date);
        holder.mTvTmp.setText(info.tmp.min+"°/"+info.tmp.max+"°");
        holder.mTvWindDirDegree.setText(info.wind.dir+" "+info.wind.sc);
        holder.mTvWindSpeed.setText(info.wind.spd+" kmph");
        holder.mTvAstro.setText(info.astro.sr+" - "+info.astro.ss);

        DatabaseMaster.instance().getWeatherIconDaoWrapper()
                .observByCode(info.cond.code_d)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<WeatherIcon>() {
                    @Override
                    public void call(WeatherIcon weatherIcon) {
                        Glide.with(mContext).load(weatherIcon.getIcon()).into(holder.mIvCondIconNow);
                    }
                });
        DatabaseMaster.instance().getWeatherIconDaoWrapper()
                .observByCode(info.cond.code_n)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<WeatherIcon>() {
                    @Override
                    public void call(WeatherIcon weatherIcon) {
                        Glide.with(mContext).load(weatherIcon.getIcon()).into(holder.mIvCondIconNext);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return mDailyForecastList.size();
    }
}
