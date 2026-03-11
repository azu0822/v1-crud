package com.cinehome.review.service;

import com.cinehome.review.domain.ReviewDomain;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    // 리뷰게시판 목록 불러오기
    public List<ReviewDomain> listReviews() throws Exception;
    // 리뷰게시판 글 보기
    public ReviewDomain view(int reviewId) throws Exception;
    // 리뷰 글 삭제
    public void deleteReview(int reviewId) throws Exception;
    // 리뷰 글쓰기 등록
    public ReviewDomain createReview(ReviewDomain reviewDomain) throws Exception;
}
