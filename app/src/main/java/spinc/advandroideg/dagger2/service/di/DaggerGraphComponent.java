package spinc.advandroideg.dagger2.service.di;


import javax.inject.Singleton;

import dagger.Component;

import spinc.advandroideg.dagger2.ui.Dagger2Activity;

@Singleton
@Component(modules = {MainModule.class})
public interface DaggerGraphComponent {

    void inject(Dagger2Activity mainActivity);

    static final class Initializer {
        private Initializer() {
        }

        public static DaggerGraphComponent init(DaggerApplication app) {
            return DaggerDaggerGraphComponent.builder()
                                             .mainModule(new MainModule(app))
                                             .build();
        }
    }
}
