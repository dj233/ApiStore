package api.app.weather.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import net.HeWeatherReq;
import net.WeatherReq;

import java.util.concurrent.Future;

import api.app.weather.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import entity.WeatherInfo;
import rsp.WeatherRsp;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;
    @BindView(R.id.tv_city)
    TextView mTvCity;
    @BindView(R.id.tv_tmp)
    TextView mTvTmp;
    @BindView(R.id.tv_cond)
    TextView mTvCond;
    @BindView(R.id.iv_cond_icon)
    ImageView mIvCondIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_weather);

        ButterKnife.bind(this);

        loadNowWeather("chongqing");
    }

    private void loadNowWeather(final String city){
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
        WeatherInfo info = rsp.datas.get(0);
        mTvCity.setText("重庆");
        mTvTmp.setText(info.now.tmp);
        mTvCond.setText(info.now.cond.txt);

//        Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                info.now.cond.code
//            }
//        })
    }
}
