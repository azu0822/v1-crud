package com.cinehome.review.controller;

import com.cinehome.member.service.MemberService;
import com.cinehome.review.domain.ReviewDomain;
import com.cinehome.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    // 리뷰게시판 페이지로 이동
    @GetMapping("/board")
    public String board(Model model) throws Exception {

        // 리뷰 목록 조회 listReviews()
        List<ReviewDomain> listReviews = reviewService.listReviews();
        model.addAttribute("listReviews", listReviews);

        return "review/board";
    }
    // 리뷰게시판 글 보기 boardView()
    @GetMapping("/board/view")
    public String view(@RequestParam("reviewId") int reviewId,
                            Model model) throws Exception {

        ReviewDomain view = reviewService.view(reviewId);
        model.addAttribute("view", view);

        return "review/view";
    }

    // 리뷰 삭제 	deleteReview()
    @GetMapping("board/deleteReview")
    public String deleteReview(@RequestParam("reveiwId") int reviewId,
                               Model model) throws Exception {

        reviewService.deleteReview(reviewId);
        return "redirect:/review/board";
    }

    // 리뷰 등록 createReview()

    // 리뷰 수정 updateReview()




}
