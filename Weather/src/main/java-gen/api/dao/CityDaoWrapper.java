package api.dao;

import java.util.List;

import de.greenrobot.dao.query.WhereCondition;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Fischer on 2016/9/19.
 */
public class CityDaoWrapper {

    private CityDao mDao;

    public CityDaoWrapper(CityDao dao) {
        this.mDao = dao;
    }

    public void insertAll(List<City> cityList){
        mDao.deleteAll();
        mDao.insertInTx(cityList);
    }

    private List<City> listAll(){
        return mDao.loadAll();
    }


    /**
     * @return
     */
    public Observable<List<City>> observAll(){
        return Observable.create(new Observable.OnSubscribe<List<City>>() {
            @Override
            public void call(Subscriber<? super List<City>> subscriber) {
                subscriber.onNext(listAll());
                subscriber.onCompleted();
            }
        });
    }

}
