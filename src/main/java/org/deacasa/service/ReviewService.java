package org.deacasa.service;


import org.deacasa.entity.Review;
import java.util.List;



public interface ReviewService {
    List<Review> getAllReviews();

    Review getReviewById(Long id);

    Review saveReview(Review review);

    Review updateReview(Long id, Review review);

    void deleteReview(Long id);

}
