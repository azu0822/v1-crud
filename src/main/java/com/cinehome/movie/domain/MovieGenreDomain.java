package com.cinehome.movie.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieGenreDomain {
    private int movieId;    // 영화 아이디
    private String genreId; // 장르 아이디
}
