package com.cinehome.review.mapper;

import com.cinehome.review.domain.ReviewDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    public List<ReviewDomain> listReviews();
    public ReviewDomain view(int reviewId);
    public void deleteReview(int reviewId);
//    public void createReview(ReviewDomain reviewDomain);
}
