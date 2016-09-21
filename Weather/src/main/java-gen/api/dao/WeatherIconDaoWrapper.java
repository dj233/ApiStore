package api.dao;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Fischer on 2016/9/19.
 */
public class WeatherIconDaoWrapper {

    private WeatherIconDao mDao;

    public WeatherIconDaoWrapper(WeatherIconDao dao){
        this.mDao = dao;
    }

    public void insertAll(List<WeatherIcon> weatherIcons){
        mDao.deleteAll();
        mDao.insertInTx(weatherIcons);
    }

    private List<WeatherIcon> listAll(){
        return mDao.loadAll();
    }

    private WeatherIcon getByCode(String code){
        return mDao.queryBuilder().where(WeatherIconDao.Properties.Code.eq(code)).unique();
    }

    public Observable<WeatherIcon> observByCode(final String code) {
        return Observable.create(new Observable.OnSubscribe<WeatherIcon>() {
            @Override
            public void call(Subscriber<? super WeatherIcon> subscriber) {
                WeatherIcon weatherIcon = getByCode(code);
                subscriber.onNext(weatherIcon);
                subscriber.onCompleted();
            }
        });
    }

    public Observable<List<WeatherIcon>> observAll(){
        return Observable.create(new Observable.OnSubscribe<List<WeatherIcon>>() {
            @Override
            public void call(Subscriber<? super List<WeatherIcon>> subscriber) {
                subscriber.onNext(listAll());
                subscriber.onCompleted();
            }
        });
    }
}
