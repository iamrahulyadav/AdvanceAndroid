package spinc.advandroideg.dagger2.view.activity.repodetails;

import com.test.xyz.daggersample.di.scope.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(
        modules = {RepoDetailsActivityModule.class}
)
public interface RepoDetailsActivityComponent {
    void inject(RepoDetailsActivity activity);
}

