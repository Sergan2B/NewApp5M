package kg.geektech.newapp5m.data.models;

import com.google.gson.annotations.SerializedName;

public class Film {
    @SerializedName("id") String id;
    @SerializedName("title") String title;
    @SerializedName("original_title") String originalTitle;
    @SerializedName("description") String description;
    @SerializedName("original_title_romanised") String original_title_romanised;
    @SerializedName("director") String director;

    public String getOriginal_title_romanised() {
        return original_title_romanised;
    }

    public String getDirector() {
        return director;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getDescription() {
        return description;
    }
}
