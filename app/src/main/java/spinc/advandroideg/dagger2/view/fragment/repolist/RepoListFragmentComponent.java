package spinc.advandroideg.dagger2.view.fragment.repolist;

import com.test.xyz.daggersample.di.scope.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(
        modules = {RepoListFragmentModule.class}
)
public interface RepoListFragmentComponent {
    void inject(RepoListFragment repoListFragment);
}

