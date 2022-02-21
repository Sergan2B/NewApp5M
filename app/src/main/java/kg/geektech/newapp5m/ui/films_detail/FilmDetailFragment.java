package kg.geektech.newapp5m.ui.films_detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kg.geektech.newapp5m.App;
import kg.geektech.newapp5m.R;
import kg.geektech.newapp5m.data.models.Film;
import kg.geektech.newapp5m.databinding.FragmentFilmDetailBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmDetailFragment extends Fragment {

    private FragmentFilmDetailBinding binding;
    private String id;

    public FilmDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        id = getArguments().getString("filmKey");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.api.getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {
                    binding.textViewId.setText(response.body().getId());
                    binding.textViewTitle.setText(response.body().getTitle());
                    binding.textViewOriginalTitle.setText(response.body().getOriginalTitle());
                    binding.textViewOriginalTitleRomanised.setText(response.body().getOriginal_title_romanised());
                    binding.textViewDescription.setText(response.body().getDescription());
                    binding.textViewDirector.setText(response.body().getDirector());
                    Log.e("Tag2", "onResponse: ");
                } else {
                    Log.e("Tag22", "onResponse" + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}