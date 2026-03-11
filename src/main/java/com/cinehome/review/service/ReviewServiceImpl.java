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

    @Override
    public List<ReviewDomain> listReviews() throws Exception {
        return reviewMapper.listReviews();
    }
    @Override
    public ReviewDomain view(int reviewId) throws Exception {
        return reviewMapper.view(reviewId);
    }
    @Override
    public void deleteReview(int reviewId) throws Exception {
        reviewMapper.deleteReview(reviewId);
        return;
    }
//    @Override
//    public ReviewDomain createReview(ReviewDomain reviewDomain) throws Exception {
//        return null;
//    }

}
