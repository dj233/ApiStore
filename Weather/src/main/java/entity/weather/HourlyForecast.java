package entity.weather;

/**
 * 每三小时天气预报，全能版为每小时预报
 * Created by Fischer on 2016/9/18.
 */

public class HourlyForecast {

    /** 预报日期 */
    public String date;
    /** 相对湿度（%） */
    public String hum;
    /** 降水概率 */
    public String pop;
    /** 气压 */
    public String pres;
    /** 温度 */
    public String tmp;
    /** 风力风向 */
    public Wind wind;

    @Override
    public String toString() {
        return "HourlyForecast{" +
                "date='" + date + '\'' +
                ", hum='" + hum + '\'' +
                ", pop='" + pop + '\'' +
                ", pres='" + pres + '\'' +
                ", tmp=" + tmp +
                ", wind=" + wind +
                '}';
    }
}
