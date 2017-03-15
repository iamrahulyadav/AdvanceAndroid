package spinc.advandroideg.dagger2.presenter.weather;

public interface WeatherPresenter extends OnWeatherInfoCompletedListener {
    void requestWeatherInformation();
}
