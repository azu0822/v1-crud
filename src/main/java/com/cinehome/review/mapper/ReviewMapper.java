package com.cinehome.review.mapper;

import com.cinehome.review.domain.ReviewDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<ReviewDomain> listReviews();
    ReviewDomain view(int review);
}
