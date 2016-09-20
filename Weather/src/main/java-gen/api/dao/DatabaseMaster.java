package api.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Fischer on 2016/9/19.
 */
public class DatabaseMaster {

    private WeatherIconDaoWrapper weatherIconDaoWrapper;
    private CityDaoWrapper cityDaoWrapper;

    private static DatabaseMaster mInstance;

    public static DatabaseMaster instance(){
        synchronized (DatabaseMaster.class){
            if(null == mInstance){
                mInstance = new DatabaseMaster();
            }
            return mInstance;
        }
    }

    private DatabaseMaster(){
    }

    public void init(Context context){
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(context,"weather.db",null);
        DaoMaster master = new DaoMaster(openHelper.getWritableDatabase());
        DaoSession session = master.newSession();

        weatherIconDaoWrapper = new WeatherIconDaoWrapper(session.getWeatherIconDao());
        cityDaoWrapper = new CityDaoWrapper(session.getCityDao());
    }

    private class DataBaseOpenHelper extends DaoMaster.OpenHelper {
        public DataBaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            DaoMaster.dropAllTables(db, true);
            onCreate(db);
        }

        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            DaoMaster.dropAllTables(db, true);
            onCreate(db);
        }

    }

    public WeatherIconDaoWrapper getWeatherIconDaoWrapper() {
        return weatherIconDaoWrapper;
    }

    public CityDaoWrapper getCityDaoWrapper() {
        return cityDaoWrapper;
    }
}
