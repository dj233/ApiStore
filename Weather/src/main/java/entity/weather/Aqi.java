package entity.weather;

/**
 * 空气质量，仅限国内部分城市，国际城市无此字段
 * Created by Fischer on 2016/9/18.
 */
public class Aqi {

    public City city;

    public class City{
        /** 空气质量指数 */
        public String aqi;
        /** 一氧化碳1小时平均值(ug/m³) */
        public String co;
        /** 二氧化氮1小时平均值(ug/m³) */
        public String no2;
        /** 臭氧1小时平均值(ug/m³) */
        public String o3;
        /** //PM10 1小时平均值(ug/m³) */
        public String pm10;
        /** PM2.5 1小时平均值(ug/m³) */
        public String pm25;
        /** 空气质量类别 */
        public String qlty;
        /** 二氧化硫1小时平均值(ug/m³) */
        public String so2;

        @Override
        public String toString() {
            return "City{" +
                    "aqi='" + aqi + '\'' +
                    ", co='" + co + '\'' +
                    ", no2='" + no2 + '\'' +
                    ", o3='" + o3 + '\'' +
                    ", pm10='" + pm10 + '\'' +
                    ", pm25='" + pm25 + '\'' +
                    ", qlty='" + qlty + '\'' +
                    ", so2='" + so2 + '\'' +
                    '}';
        }
    }
}
