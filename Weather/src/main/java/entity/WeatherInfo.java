package entity;

import java.util.List;

import entity.weather.Aqi;
import entity.weather.Basic;
import entity.weather.DailyForecast;
import entity.weather.HourlyForecast;
import entity.weather.Now;
import entity.weather.Suggestion;

/**
 * 天气信息 包含实时天气，空气质量，生活指数等信息
 * Created by Fischer on 2016/9/18.
 */
public class WeatherInfo {

    /** 接口状态
     *
     * ok	接口正常
     * invalid key	错误的用户 key
     * unknown city	未知城市
     * no more requests	超过访问次数
     * anr	服务无响应或超时
     * permission denied	没有访问权限
     *
     */
    public String status;

    public static final String OK = "ok";
    public static final String INVALID_KEY = "invalid key";
    public static final String UNKNOWN_CITY = "unknown city";
    public static final String NO_MORE_REQUEST = "no more requests";
    public static final String ANR = "anr";
    public static final String PERMISSION_DENIED = "permission denied";

    /**
     * 基本信息
     * 城市，国家，经纬度，更新时间
     */
    public Basic basic;

    /**
     * 实况天气
     * 天气，体感温度，温度，湿度，降水，气压，能见度，风向
     */
    public Now now;

    /**
     * 空气质量，仅限国内部分城市，国际城市无此字段
     * 空气质量指数,一氧化碳,二氧化硫，臭氧，pm2.5等气体小时平均值，空气质量等级
     */
    public Aqi aqi;

    /**
     * 接下来一周的天气预报
     */
    public List<DailyForecast> daily_forecast;

    /**
     * 接下来的小时天气
     */
    public List<HourlyForecast> hourly_forecast;

    /**
     * 生活指数
     * 舒适度,洗车，穿衣，运动，旅游，紫外线等指数和提醒
     */
    public Suggestion suggestion;

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "status='" + status + '\'' +
                ", basic=" + basic +
                ", now=" + now +
                ", aqi=" + aqi +
                ", daily_forecast=" + daily_forecast +
                ", hourly_forecast=" + hourly_forecast +
                ", suggestion=" + suggestion +
                '}';
    }
}
