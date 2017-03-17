package spinc.advandroideg.dagger2.service.di;

import android.app.Application;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import spinc.advandroideg.dagger2.service.api.HelloService;
import spinc.advandroideg.dagger2.service.impl.HelloServiceManager;

@Module
public class MainModule {
    DaggerApplication app;

    public MainModule(DaggerApplication application) {
        app = application;
    }

    @Provides
    @Singleton
    protected Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    public HelloService provideHelloService() {
        return new HelloServiceManager();
    }
}
