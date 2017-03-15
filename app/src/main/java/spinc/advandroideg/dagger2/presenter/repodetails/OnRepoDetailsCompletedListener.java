package spinc.advandroideg.dagger2.presenter.repodetails;

import com.test.xyz.daggersample.service.api.model.Repo;

public interface OnRepoDetailsCompletedListener {
    void onRepoDetailsRetrievalSuccess(Repo data);

    void onRepoDetailsRetrievalFailure(String errorMessage);
}
