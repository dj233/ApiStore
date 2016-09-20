package service;

import retrofit2.http.Query;
import rsp.CityRsp;
import rsp.WeatherIconRsp;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Fischer on 2016/9/19.
 */
public interface HeWeatherApi {
    @GET("/x3/condition")
    Observable<WeatherIconRsp> getWeatherIcons(@Query("search") String search,@Query("key") String key);

    @GET("/x3/citylist")
    Observable<CityRsp> getCityList(@Query("search") String search,@Query("key") String key);
}
