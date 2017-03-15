package spinc.advandroideg.dagger2.presenter.repodetails;

public interface RepoDetailsPresenter extends OnRepoDetailsCompletedListener {
    void requestRepoDetails(String userName, String projectID);
}
