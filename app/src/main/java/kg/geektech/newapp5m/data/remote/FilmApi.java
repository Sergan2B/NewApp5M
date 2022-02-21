package kg.geektech.newapp5m.data.remote;

import java.util.List;

import kg.geektech.newapp5m.data.models.Film;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmApi {

    @GET("/films")
    Call<List<Film>> getFilms();

    @GET("/films/{id}")  //{id} конечный путь, называют "энд поинт". Путь
    Call<Film> getFilmById(
            @Path("id") String id
    );
}
