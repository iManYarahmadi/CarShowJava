package com.ImanYarahmadi.car.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ImanYarahmadi.car.R;
import com.ImanYarahmadi.car.data.Car;
import com.ImanYarahmadi.car.data.CarAdapter;
import com.ImanYarahmadi.car.http.ApiServiceSingleton;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    private CarAdapter carAdapter;
    Disposable disposable;
    private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainViewModel mainViewModel = new MainViewModel(ApiServiceSingleton.getInstance());
        mainViewModel.getCars().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Car>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onSuccess(List<Car> cars) {
                        Log.i(TAG, "onSuccess: "+cars);
                        recyclerView=findViewById(R.id.recyclerview);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                        carAdapter = new CarAdapter(cars, MainActivity.this);
                        recyclerView.setAdapter(carAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, "error" + e.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
