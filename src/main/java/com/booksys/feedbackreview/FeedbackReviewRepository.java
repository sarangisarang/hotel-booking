package com.booksys.feedbackreview;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface FeedbackReviewRepository extends JpaRepository<FeedbackReview, UUID> {
}