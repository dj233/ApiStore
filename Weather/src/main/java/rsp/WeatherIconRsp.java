package rsp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import api.dao.WeatherIcon;

/**
 * Created by Fischer on 2016/9/19.
 */
public class WeatherIconRsp {
    public String status;
    @SerializedName("cond_info")
    public List<WeatherIcon> condInfos;

    @Override
    public String toString() {
        return "WeatherIconRsp{" +
                "status='" + status + '\'' +
                ", condInfos=" + condInfos +
                '}';
    }
}
