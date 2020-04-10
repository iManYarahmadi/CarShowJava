package com.ImanYarahmadi.car.main;

import com.ImanYarahmadi.car.data.Car;
import com.ImanYarahmadi.car.http.ApiService;

import java.util.List;

import io.reactivex.Single;

public class MainViewModel {
    private ApiService apiService;

    public MainViewModel(ApiService apiService) {

        this.apiService = apiService;
    }

    public Single<List<Car>> getCars() {
        return apiService.getCars();
    }
}
