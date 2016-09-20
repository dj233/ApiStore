package net;

import android.util.Log;

import rsp.WeatherRsp;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import service.WeatherApi;

/**
 * Created by Fischer on 2016/9/18.
 */
public class WeatherReq {

    private static final String TAG = WeatherReq.class.getSimpleName();
    private static final String BASEURL = "http://apis.baidu.com";

    private Retrofit retrofit;

    private void initRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public WeatherReq(){
        initRetrofit();
    }

    public void reqAsy(String city){
        reqWeatherObservable(city)
        .subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<WeatherRsp>() {
            @Override
            public void call(WeatherRsp weatherRsp) {
                print(weatherRsp);
            }
        });
    }

    public Observable<WeatherRsp> reqWeatherObservable(String city){
        WeatherApi api = retrofit.create(WeatherApi.class);
        return api.getWeather(city);
    }

    private void print(WeatherRsp weatherRsp){
        Log.d(TAG, weatherRsp.toString());
    }

}
