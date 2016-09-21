package api.app.weather.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.HeWeatherReq;
import net.WeatherReq;

import java.util.concurrent.Future;

import api.app.weather.R;
import api.app.weather.adapter.DailyAdapter;
import api.app.weather.adapter.HourlyAdapter;
import api.dao.DatabaseMaster;
import api.dao.WeatherIcon;
import entity.WeatherInfo;
import rsp.WeatherRsp;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    String TAG = MainActivity.class.getSimpleName();

    SwipeRefreshLayout mRefresh;
    TextView mTvCity;
    TextView mTvTmp;
    TextView mTvCond;
    TextView mTvComfortable;
    TextView mTvTime;
    ImageView mIvCondIcon;

    RecyclerView mLvHourly;
    HourlyAdapter mHourlyAdapter;

    RecyclerView mLvDaily;
    DailyAdapter mDailyAdapter;

    RecyclerView mLvComfortable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_weather);
        bindViews();
        bindEvents();
        bindDatas();
        loadNowWeather("chongqing");
    }

    private void bindViews(){
        mRefresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        mTvCond = (TextView) findViewById(R.id.tv_cond);
        mTvTmp = (TextView) findViewById(R.id.tv_tmp);
        mTvCity = (TextView) findViewById(R.id.tv_city);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvComfortable = (TextView) findViewById(R.id.tv_comfortable);
        mIvCondIcon = (ImageView) findViewById(R.id.iv_cond_icon);

        mLvHourly = (RecyclerView) findViewById(R.id.lv_hourly);
        mLvDaily = (RecyclerView) findViewById(R.id.lv_daily);
    }

    private void bindEvents(){
        mRefresh.setOnRefreshListener(this);
    }

    private void bindDatas(){

        mHourlyAdapter = new HourlyAdapter();
        mLvHourly.setItemAnimator(new DefaultItemAnimator());
        mLvHourly.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.HORIZONTAL,false));
        mLvHourly.setClipToPadding(true);
        mLvHourly.setAdapter(mHourlyAdapter);

        mDailyAdapter = new DailyAdapter(this);
        mLvDaily.setItemAnimator(new DefaultItemAnimator());
        mLvDaily.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.HORIZONTAL,false));
        mLvDaily.setClipToPadding(true);
        mLvDaily.setAdapter(mDailyAdapter);
    }

    private void loadNowWeather(String city){
        new WeatherReq().reqWeatherObservable(city)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<WeatherRsp>() {
                    @Override
                    public void call(WeatherRsp weatherRsp) {
                        showNowWeather(weatherRsp);
                    }
                });
    }

    private void showNowWeather(WeatherRsp rsp){

        Log.d(TAG,rsp.toString());

        WeatherInfo info = rsp.datas.get(0);
        mTvCity.setText(info.basic.city);
        mTvTmp.setText(info.now.tmp+"°");
        mTvCond.setText(info.now.cond.txt);
        mTvComfortable.setText(info.aqi.city.aqi+" "+info.aqi.city.qlty);
        mTvTime.setText(info.basic.update.loc);

        mHourlyAdapter.update(info.hourly_forecast);
        mDailyAdapter.update(info.daily_forecast);

        DatabaseMaster.instance().getWeatherIconDaoWrapper()
                .observByCode(info.now.cond.code)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<WeatherIcon>() {
            @Override
            public void call(WeatherIcon weatherIcon) {
                loadCondIcon(weatherIcon.getIcon());
            }
        });

        if(mRefresh.isRefreshing()) {
            mRefresh.setRefreshing(false);
        }
    }

    private void loadCondIcon(String imgurl){
        Glide.with(this).load(imgurl).into(mIvCondIcon);
    }

    @Override
    public void onRefresh() {
        loadNowWeather("chongqing");
    }
}
