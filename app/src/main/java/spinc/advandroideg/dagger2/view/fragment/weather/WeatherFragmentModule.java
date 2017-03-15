package spinc.advandroideg.dagger2.view.fragment.weather;

import com.test.xyz.daggersample.di.scope.ActivityScope;
import com.test.xyz.daggersample.interactor.MainInteractor;
import com.test.xyz.daggersample.interactor.MainInteractorImpl;
import com.test.xyz.daggersample.presenter.weather.WeatherPresenter;
import com.test.xyz.daggersample.presenter.weather.WeatherPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherFragmentModule {
    public WeatherFragmentModule(WeatherView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    WeatherView provideMainView() {
        return this.view;
    }

    @Provides
    @ActivityScope
    MainInteractor provideMainInteractor(MainInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @ActivityScope
    WeatherPresenter provideMainPresenter(WeatherPresenterImpl presenter) {
        return presenter;
    }

    private final WeatherView view;
}
