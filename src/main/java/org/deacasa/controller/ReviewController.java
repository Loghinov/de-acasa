package org.deacasa.controller;


import lombok.RequiredArgsConstructor;
import org.deacasa.entity.Review;
import org.deacasa.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // Получение всех отзывов
    @GetMapping("/get-all-reviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Получение отзыва по ID
    @GetMapping("/get-review-by-id/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    // Создание нового отзыва
    @PostMapping("/save-review")
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    // Обновление существующего отзыва
    @PutMapping("/update-review/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    // Удаление отзыва
    @DeleteMapping("/delete-review/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
