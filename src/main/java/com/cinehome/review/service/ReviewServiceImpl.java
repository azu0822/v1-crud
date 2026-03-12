package com.cinehome.review.service;

import com.cinehome.review.domain.ReviewDomain;
import com.cinehome.review.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewMapper reviewMapper;

    // 리뷰게시판 목록 불러오기
    @Override
    public List<ReviewDomain> listReviews() throws Exception {
        return reviewMapper.listReviews();
    }
    // 리뷰게시판 글 보기
    @Override
    public ReviewDomain view(int reviewId) throws Exception {
        return reviewMapper.view(reviewId);
    }
    // 리뷰 글 삭제
    @Override
    public void deleteReview(int reviewId) throws Exception {
        reviewMapper.deleteReview(reviewId);
    }
    // 리뷰 글쓰기 등록
    @Override
    public ReviewDomain createReview(ReviewDomain reviewDomain) throws Exception {
        reviewMapper.createReview(reviewDomain);
        return reviewDomain;
    }
    // 리뷰 글쓰기 수정

    @Override
    public void updateReview(ReviewDomain reviewDomain) throws Exception {
        reviewMapper.updateReview(reviewDomain);
    }

}
