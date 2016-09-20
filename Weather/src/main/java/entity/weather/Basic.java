package entity.weather;

/**
 * 基本信息
 * Created by Fischer on 2016/9/18.
 */
public class Basic {
    /** 城市名称 */
    public String city;
    /** 国家 */
    public String cnty;
    /** 城市ID，参见http://www.heweather.com/documents/cn-city-list */
    public String id;
    /** 城市纬度 */
    public String lat;
    /** 城市经度 */
    public String lon;
    /** 更新时间 */
    public Update update;

    /** 更新时间 */
    public class Update{
        /** 当地时间 */
        public String loc;
        /** UTC时间 */
        public String utc;

        @Override
        public String toString() {
            return "Update{" +
                    "loc='" + loc + '\'' +
                    ", utc='" + utc + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Basic{" +
                "city='" + city + '\'' +
                ", cnty='" + cnty + '\'' +
                ", id='" + id + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", update=" + update +
                '}';
    }
}
