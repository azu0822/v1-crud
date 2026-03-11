package com.cinehome.review.service;

import com.cinehome.review.domain.ReviewDomain;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    List<ReviewDomain> listReviews() throws Exception;
}
