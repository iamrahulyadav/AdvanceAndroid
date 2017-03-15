package spinc.advandroideg.dagger2.view.fragment.weather;

import com.test.xyz.daggersample.di.scope.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(
        modules = {WeatherFragmentModule.class}
)
public interface WeatherFragmentComponent {
    void inject(WeatherFragment mainFragment);
}

