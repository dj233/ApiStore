package entity.weather;

/**
 * 生活指数，仅限国内城市，国际城市无此字段
 * Created by Fischer on 2016/9/18.
 */
public class Suggestion {
    /** 舒适度指数 */
    public Comf comf;
    /** 洗车指数 */
    public Cw cw;
    /** 穿衣指数 */
    public Drsg drsg;
    /** 感冒指数 */
    public Flu flu;
    /** 运动指数 */
    public Sport sport;
    /** 旅游指数 */
    public Trav trav;
    /** 紫外线指数 */
    public UV uv;

    /**
     * 舒适度指数
     */
    public class Comf{
        /** 简介 */
        public String brf;
        /** 详细描述 */
        public String txt;

        @Override
        public String toString() {
            return "Comf{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    /**
     * 洗车指数
     */
    public class Cw{
        /** 简介 */
        public String brf;
        /** 详细描述 */
        public String txt;

        @Override
        public String toString() {
            return "Comf{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    /**
     * 穿衣指数
     */
    public class Drsg{
        /** 简介 */
        public String brf;
        /** 详细描述 */
        public String txt;

        @Override
        public String toString() {
            return "Comf{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    /**
     * 感冒指数
     */
    public class Flu{
        /** 简介 */
        public String brf;
        /** 详细描述 */
        public String txt;


        @Override
        public String toString() {
            return "Comf{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    /**
     * 运动指数
     */
    public class Sport{
        /** 简介 */
        public String brf;
        /** 详细描述 */
        public String txt;

        @Override
        public String toString() {
            return "Comf{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    /**
     * 旅游指数
     */
    public class Trav{
        /** 简介 */
        public String brf;
        /** 详细描述 */
        public String txt;

        @Override
        public String toString() {
            return "Comf{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    /**
     * 紫外线指数
     */
    public class UV{
        /** 简介 */
        public String brf;
        /** 详细描述 */
        public String txt;

        @Override
        public String toString() {
            return "Comf{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "comf=" + comf +
                ", cw=" + cw +
                ", drsg=" + drsg +
                ", flu=" + flu +
                ", sport=" + sport +
                ", trav=" + trav +
                ", uv=" + uv +
                '}';
    }
}
