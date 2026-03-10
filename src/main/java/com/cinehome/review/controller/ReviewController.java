package com.cinehome.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {

    // 리뷰게시판 페이지로 이동
    @GetMapping("/board")
    public String board() {
        return "review/board";
    }
}
