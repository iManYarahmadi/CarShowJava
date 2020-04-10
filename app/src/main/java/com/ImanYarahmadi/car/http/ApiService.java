package com.ImanYarahmadi.car.http;

import com.ImanYarahmadi.car.data.Car;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("5e9071493300002cb827d7a7")
    Single<List<Car>> getCars();
}
