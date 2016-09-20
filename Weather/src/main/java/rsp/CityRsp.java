package rsp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import api.dao.City;
import api.dao.WeatherIcon;

/**
 * Created by Fischer on 2016/9/19.
 */
public class CityRsp {
    public String status;
    @SerializedName("city_info")
    public List<City> cityList;

    @Override
    public String toString() {
        return "CityRsp{" +
                "status='" + status + '\'' +
                ", cityList=" + cityList +
                '}';
    }
}
