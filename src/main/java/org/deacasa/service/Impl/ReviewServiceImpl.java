package org.deacasa.service.Impl;

import org.deacasa.entity.Review;
import org.deacasa.repository.ReviewRepo;
import org.deacasa.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    public final ReviewRepo reviewRepo;

    @Autowired
    public ReviewServiceImpl(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("Review not found"));
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        Review review1=getReviewById(id);
        review1.setComment(review.getComment());
        review1.setRating(review.getRating());
        review1.setProductId(review.getProductId());
        review1.setUserId(review1.getUserId());
        review1.setCreatedDateTime(review.getCreatedDateTime());
        return reviewRepo.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepo.deleteById(id);

    }
}
