package net;

import android.content.Context;
import android.util.Log;

import api.dao.DatabaseMaster;
import rsp.CityRsp;
import rsp.WeatherIconRsp;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import service.HeWeatherApi;

/**
 * Created by Fischer on 2016/9/19.
 */
public class HeWeatherReq {
    private static final String TAG = WeatherReq.class.getSimpleName();
    private static final String BASEURL = "https://api.heweather.com";
    private static final String KEY = "13f40777e9ae47288443e75652d09eeb";

    private Retrofit retrofit;

    private void initRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public HeWeatherReq(){
        initRetrofit();
    }



    public void reqAllIconsToDB(){
        retrofit.create(HeWeatherApi.class).getWeatherIcons("allcond",KEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Action1<WeatherIconRsp>() {
                    @Override
                    public void call(WeatherIconRsp weatherIconRsp) {
                        saveAllToDb(weatherIconRsp);
                    }
                });

    }

    public void reqAllIconsToDbWithCallback(final Callback callback){
        retrofit.create(HeWeatherApi.class).getWeatherIcons("allcond",KEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<WeatherIconRsp>() {
                    @Override
                    public void onNext(WeatherIconRsp weatherIconRsp) {
                        Log.d(TAG,weatherIconRsp.toString());
                        saveAllToDb(weatherIconRsp);
                    }

                    @Override
                    public void onCompleted() {
                        callback.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError();
                    }
                });

    }

    private void saveAllToDb(WeatherIconRsp rsp){
        if("ok".equalsIgnoreCase(rsp.status)) {
            DatabaseMaster.instance().getWeatherIconDaoWrapper().insertAll(rsp.condInfos);
        }
    }

    /**
     * 获取城市列表并插入数据库 （全部城市）
     */
    public void reqAllWorldCitysToDB() {
        reqCitysToDB("allworld");
    }

    public void reqAllChinaCitysToDB(){
        reqCitysToDB("allchina");
    }

    public void reqHotWorldCitysToDB(){
        reqCitysToDB("hotworld");
    }

    /**
     * 获取城市列表并插入数据库
     * @param search 城市列表类型	国内城市：allchina、 热门城市：hotworld、 全部城市：allworld
     */
    public void reqCitysToDB(String search){
        retrofit.create(HeWeatherApi.class).getCityList(search,KEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Action1<CityRsp>() {
                    @Override
                    public void call(CityRsp cityRsp) {
                        Log.d(TAG,cityRsp.toString());
                        saveAllToDb(cityRsp);
                    }
                });

    }
    private void saveAllToDb(CityRsp cityRsp){
        if("ok".equalsIgnoreCase(cityRsp.status)) {
            DatabaseMaster.instance().getCityDaoWrapper().insertAll(cityRsp.cityList);
        }
    }


    public interface Callback{
        public void onComplete();
        public void onError();
    }
}
