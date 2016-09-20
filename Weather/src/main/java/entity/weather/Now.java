package entity.weather;

/**
 * 实况天气
 * Created by Fischer on 2016/9/18.
 */
public class Now {
    /** 天气状况 */
    public Cond cond;
    /** 体感温度 */
    public String fl;
    /** 相对湿度 */
    public String hum;
    /** 降水量 */
    public String pcpn;
    /** 气压 */
    public String pres;
    /** 温度 */
    public String tmp;
    /** 能见度 */
    public String vis;
    /** 风力风向 */
    public Wind wind;

    /**
     * 天气状况
     */
    public class Cond{
        /** 天气状况代码 */
        public String code;
        /** 天气状况描述 */
        public String txt;

        @Override
        public String toString() {
            return "Cond{" +
                    "code='" + code + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Now{" +
                "cond=" + cond +
                ", fl='" + fl + '\'' +
                ", hum='" + hum + '\'' +
                ", pcpn='" + pcpn + '\'' +
                ", pres='" + pres + '\'' +
                ", tmp='" + tmp + '\'' +
                ", vis='" + vis + '\'' +
                ", wind=" + wind +
                '}';
    }
}
