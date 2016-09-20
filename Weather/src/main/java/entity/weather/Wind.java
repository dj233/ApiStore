package entity.weather;

/**
 * 风力风向
 * Created by Fischer on 2016/9/18.
 */
public class Wind{
    /** 风向（360度） */
    public String deg;
    /** 风向 */
    public String dir;
    /** 风力 */
    public String sc;
    /** 风速（kmph） */
    public String spd;

    @Override
    public String toString() {
        return "Wind{" +
                "deg='" + deg + '\'' +
                ", dir='" + dir + '\'' +
                ", sc='" + sc + '\'' +
                ", spd='" + spd + '\'' +
                '}';
    }
}
