package com.cinehome.review.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AttachDomain {
    private int fileId;      // 리뷰 파일 아이디
    private int reviewId;    // 리뷰 게시판 아이디
    private String fileName; // 파일명
    private String filePath; // 파일 경로
    private LocalDate creDt; // 생성 일자
}
