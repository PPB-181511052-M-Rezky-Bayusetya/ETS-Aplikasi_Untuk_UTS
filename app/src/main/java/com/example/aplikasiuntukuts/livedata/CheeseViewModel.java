package com.example.aplikasiuntukuts.livedata;

import android.app.Application;

import com.example.aplikasiuntukuts.data.Cheese;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class CheeseViewModel extends AndroidViewModel {
    private CheeseRepository mRepository;

    private LiveData<List<Cheese>> mAllWords;

    public CheeseViewModel(Application application) {
        super(application);
        mRepository = new CheeseRepository(application);
        mAllWords = mRepository.getAllCheese();
    }

    public LiveData<List<Cheese>> getAllCheese() {
        return mAllWords;
    }
}
