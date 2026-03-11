package com.cinehome.review.domain;

import com.cinehome.member.domain.MemberDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReviewDomain {
    private int reviewId;         // 리뷰 게시판 아이디
    private int movieId;          // 영화 아이디
    private int userId;           // 작성자 아이디(FK)
    private String reviewTitle;   // 제목
    private String reviewContent; // 내용
    private LocalDate creDt;      // 작성 날짜
    private LocalDate updateDt;   // 업데이트 날짜
    private int rating;           // 평점(별점)
    private int viewCount;        // 조회수

    private String memberId;      // 작성자 아이디

}
