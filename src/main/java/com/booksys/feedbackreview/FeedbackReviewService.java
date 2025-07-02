package com.booksys.feedbackreview;

import java.util.List;
import java.util.UUID;

public interface FeedbackReviewService {
    List<FeedbackReview> getAll();
    FeedbackReview getById(UUID id);
    FeedbackReview create(FeedbackReview feedbackReview);
    FeedbackReview update(UUID id, FeedbackReview feedbackReview);
    void delete(UUID id);
}