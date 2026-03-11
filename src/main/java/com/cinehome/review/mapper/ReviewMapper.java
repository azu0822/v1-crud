package com.cinehome.review.mapper;

import com.cinehome.review.domain.ReviewDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    // 리뷰게시판 목록 불러오기
    public List<ReviewDomain> listReviews();
    // 리뷰게시판 글 보기
    public ReviewDomain view(int reviewId);
    // 리뷰 글 삭제
    public void deleteReview(int reviewId);
    // 리뷰 글쓰기 등록
    public void createReview(ReviewDomain reviewDomain);
}
