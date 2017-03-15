package spinc.advandroideg.dagger2.view.activity.repodetails;

import com.test.xyz.daggersample.service.api.model.Repo;

public interface RepoDetailsView {
    void showRepoDetails(Repo data);

    void showError(final String errorMessage);
}
