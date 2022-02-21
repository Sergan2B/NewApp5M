package kg.geektech.newapp5m;

import android.app.Application;

import kg.geektech.newapp5m.data.remote.FilmApi;
import kg.geektech.newapp5m.data.remote.RetrofitClient;

public class App extends Application {
    private RetrofitClient retrofitClient;
    public static FilmApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideFilmApi();
    }
}
