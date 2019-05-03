package io.kabir.reactiveclient.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
public class Movie {
    private String id;
    @NonNull
    private String title;

    public Movie(@NonNull String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}