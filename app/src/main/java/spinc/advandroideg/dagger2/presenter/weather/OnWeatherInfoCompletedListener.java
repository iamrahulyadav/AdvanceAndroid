package spinc.advandroideg.dagger2.presenter.weather;

public interface OnWeatherInfoCompletedListener {
    void onUserNameValidationError(int messageID);

    void onCityValidationError(int messageID);

    void onSuccess(String data);

    void onFailure(String errorMessage);
}
