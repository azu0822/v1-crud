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

    public List<ReviewDomain> listReviews() throws Exception {
        return reviewMapper.listReviews();
    }
}
