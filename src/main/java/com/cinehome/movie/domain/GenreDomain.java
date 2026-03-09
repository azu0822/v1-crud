package com.cinehome.movie.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GenreDomain {
    private int genreId;      // 장르 아이디
    private String genreName; // 장르 이름
}
