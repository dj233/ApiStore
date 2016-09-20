package api.app.weather;

import android.app.Application;

import net.HeWeatherReq;

import api.dao.DatabaseMaster;

/**
 * Created by Fischer on 2016/9/20.
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseMaster.instance().init(this);
        loadDatasToDb();
    }

    private void loadDatasToDb(){
        HeWeatherReq heWeatherReq = new HeWeatherReq();
        heWeatherReq.reqAllIconsToDB();
        heWeatherReq.reqAllChinaCitysToDB();
    }
}
