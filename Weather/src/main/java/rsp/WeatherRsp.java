package rsp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

import entity.WeatherInfo;

/**
 * Created by Fischer on 2016/9/18.
 */
public class WeatherRsp {

    @SerializedName("HeWeather data service 3.0")
    public List<WeatherInfo> datas;

    @Override
    public String toString() {
        return "WeatherRsp{" +
                "datas=" + datas +
                '}';
    }
}
