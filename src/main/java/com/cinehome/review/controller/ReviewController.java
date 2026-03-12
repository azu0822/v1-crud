package com.cinehome.review.controller;

import com.cinehome.member.domain.MemberDomain;
import com.cinehome.review.domain.ReviewDomain;
import com.cinehome.review.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    // 리뷰 글 삭제 	deleteReview()
    @GetMapping("/board/deleteReview")
    public String deleteReview(@RequestParam("reviewId") int reviewId,
                               Model model) throws Exception {

        reviewService.deleteReview(reviewId);
        return "redirect:/review/board";
    }
    // 리뷰 글쓰기 페이지로 이동
    @GetMapping("/createForm")
    public String createForm() throws Exception {
        return "review/createForm";
    }
    // 리뷰 글쓰기 등록 createReview()
    @PostMapping("createReview")
    public String createReview(@RequestParam("movieId") int movieId,
                               @RequestParam("userId") int userId,
                               @RequestParam("reviewTitle") String reviewTitle,
                               @RequestParam("reviewContent") String reviewContent,
                               @RequestParam("rating") int rating,
                               Model model) throws Exception {

        ReviewDomain reviewDomain = new ReviewDomain();
        reviewDomain.setMovieId(movieId);
        reviewDomain.setUserId(userId);
        reviewDomain.setReviewTitle(reviewTitle);
        reviewDomain.setReviewContent(reviewContent);
        reviewDomain.setRating(rating);
        reviewService.createReview(reviewDomain);

        return "redirect:/review/board";
    }
    // 리뷰 수정 클릭 시 글쓰기 폼으로
    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("reviewId") int reviewId,
                             Model model) throws Exception {
        ReviewDomain view = reviewService.view(reviewId);
        model.addAttribute("view", view);
        return "review/createForm";
    }
    // 리뷰 글쓰기 수정 updateReview()
    @PostMapping("/updateReview")
    public String updateReview(@RequestParam("reviewId") int reviewId,
                               @RequestParam("movieId") int movieId,
                               @RequestParam("userId") int userId,
                               @RequestParam("reviewTitle") String reviewTitle,
                               @RequestParam("reviewContent") String reviewContent,
                               @RequestParam("rating") int rating,
                               Model model) throws Exception {

        ReviewDomain reviewDomain = new ReviewDomain();
        reviewDomain.setReviewId(reviewId);
        reviewDomain.setMovieId(movieId);
        reviewDomain.setUserId(userId);
        reviewDomain.setReviewTitle(reviewTitle);
        reviewDomain.setReviewContent(reviewContent);
        reviewDomain.setRating(rating);
        reviewService.updateReview(reviewDomain);

        return "redirect:/review/board";
    }



}
