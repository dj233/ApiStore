package entity.weather;

/**
 * 天气预报
 * Created by Fischer on 2016/9/18.
 */
public class DailyForecast {
    /** 预报日期 */
    public String date;
    /** 天文数值 */
    public Astro astro;
    /** 天气状况 */
    public Cond cond;
    /** 相对湿度（%） */
    public String hum;
    /** 降水量（mm） */
    public String pcpn;
    /** 降水概率 */
    public String pop;
    /** 气压 */
    public String pres;
    /** 温度 */
    public Tmp tmp;
    /** 能见度（km） */
    public String vis;
    /** 风力风向 */
    public Wind wind;

    /**
     * 天文数值
     */
    public class Astro{
        /** 日出时间 */
        public String sr;
        /** 日落时间 */
        public String ss;

        @Override
        public String toString() {
            return "Astro{" +
                    "sr='" + sr + '\'' +
                    ", ss='" + ss + '\'' +
                    '}';
        }
    }

    /**
     * 天气状况
     */
    public class Cond{
        /** 白天天气状况代码 */
        public String code_d;
        /** 夜间天气状况代码 */
        public String code_n;
        /** 白天天气状况描述 */
        public String txt_d;
        /** 夜间天气状况描述 */
        public String txt_n;

        @Override
        public String toString() {
            return "Cond{" +
                    "code_d='" + code_d + '\'' +
                    ", code_n='" + code_n + '\'' +
                    ", txt_d='" + txt_d + '\'' +
                    ", txt_n='" + txt_n + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DailyForecast{" +
                "date='" + date + '\'' +
                ", astro=" + astro +
                ", cond=" + cond +
                ", hum='" + hum + '\'' +
                ", pcpn='" + pcpn + '\'' +
                ", pop='" + pop + '\'' +
                ", pres='" + pres + '\'' +
                ", tmp=" + tmp +
                ", vis='" + vis + '\'' +
                ", wind=" + wind +
                '}';
    }
}
