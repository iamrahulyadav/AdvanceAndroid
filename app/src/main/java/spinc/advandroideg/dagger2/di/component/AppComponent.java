package spinc.advandroideg.dagger2.di.component;

import com.test.xyz.daggersample.di.module.AppModule;
import com.test.xyz.daggersample.view.activity.repodetails.RepoDetailsActivityComponent;
import com.test.xyz.daggersample.view.activity.repodetails.RepoDetailsActivityModule;
import com.test.xyz.daggersample.view.fragment.weather.WeatherFragmentComponent;
import com.test.xyz.daggersample.view.fragment.weather.WeatherFragmentModule;
import com.test.xyz.daggersample.view.fragment.repolist.RepoListFragmentComponent;
import com.test.xyz.daggersample.view.fragment.repolist.RepoListFragmentModule;
import com.test.xyz.daggersample.di.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ServiceModule.class})
public interface AppComponent {

    WeatherFragmentComponent plus(WeatherFragmentModule module);

    RepoListFragmentComponent plus(RepoListFragmentModule module);

    RepoDetailsActivityComponent plus(RepoDetailsActivityModule module);
}
