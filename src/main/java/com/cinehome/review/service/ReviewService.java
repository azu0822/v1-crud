package com.cinehome.review.service;

import com.cinehome.review.domain.ReviewDomain;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    public List<ReviewDomain> listReviews() throws Exception;
    public ReviewDomain view(int reviewId) throws Exception;
    public void deleteReview(int reviewId) throws Exception;
//    public ReviewDomain createReview(ReviewDomain reviewDomain) throws Exception;
}
