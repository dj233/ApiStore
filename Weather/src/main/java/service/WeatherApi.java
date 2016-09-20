package service;

import rsp.WeatherRsp;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Fischer on 2016/9/18.
 */
public interface WeatherApi {

    @Headers("apikey:44a3f2d1f0ec6fb6d70b18e1f3c467e8")
    @GET("/heweather/weather/free")
    Observable<WeatherRsp> getWeather(@Query("city") String city);
}
