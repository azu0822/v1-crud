package com.cinehome.movie.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieDomain {
    private int movieId;         // 영화 아이디
    private String title;        // 제목
    private String summary;      // 줄거리
    private String director;     // 감독
    private LocalDate releaseDt; // 개봉일
    private String ageRating;    // 관람가
    private String type;         // MOVIE
    private LocalDate creDt;     // 생성일자
}
