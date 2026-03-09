package com.cinehome.review.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommentsDomain {
    private int commentsId;       // 리뷰 댓글 번호
    private int reviewId;         // 리뷰 아이디(FK)
    private int userId;           // 사용자 아이디
    private String content;       // 내용
    private LocalDateTime creDt;  // 작성 일자
}
