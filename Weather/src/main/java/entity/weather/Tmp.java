package entity.weather;

/**
 * 温度
 * Created by Fischer on 2016/9/18.
 */
public class Tmp{
    /** 最高温度 */
    public String max;
    /** 最低温度 */
    public String min;

    @Override
    public String toString() {
        return "Tmp{" +
                "max='" + max + '\'' +
                ", min='" + min + '\'' +
                '}';
    }
}
