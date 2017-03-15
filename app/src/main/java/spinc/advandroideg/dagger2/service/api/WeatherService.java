package spinc.advandroideg.dagger2.service.api;

import rx.Observable;

public interface WeatherService {
    Observable<Integer> getWeatherInfo(String city);
}
