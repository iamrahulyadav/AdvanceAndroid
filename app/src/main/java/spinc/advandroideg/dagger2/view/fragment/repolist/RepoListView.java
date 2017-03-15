package spinc.advandroideg.dagger2.view.fragment.repolist;

import com.test.xyz.daggersample.service.api.model.Repo;

import java.util.List;

public interface RepoListView {
    void showRepoList(List<Repo> values);

    void showError(final String errorMessage);
}
