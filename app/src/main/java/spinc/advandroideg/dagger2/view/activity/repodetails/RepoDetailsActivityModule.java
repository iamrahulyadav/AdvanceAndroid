package spinc.advandroideg.dagger2.view.activity.repodetails;

import com.test.xyz.daggersample.presenter.repodetails.RepoDetailsPresenter;
import com.test.xyz.daggersample.di.scope.ActivityScope;
import com.test.xyz.daggersample.interactor.MainInteractor;
import com.test.xyz.daggersample.interactor.MainInteractorImpl;
import com.test.xyz.daggersample.presenter.repodetails.RepoDetailsPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RepoDetailsActivityModule {
    public RepoDetailsActivityModule(RepoDetailsView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    RepoDetailsView provideRepoDetailsView() {
        return this.view;
    }

    @Provides
    @ActivityScope
    MainInteractor provideMainInteractor(MainInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @ActivityScope
    RepoDetailsPresenter provideRepoDetailsPresenter(RepoDetailsPresenterImpl presenter) {
        return presenter;
    }

    private final RepoDetailsView view;
}
