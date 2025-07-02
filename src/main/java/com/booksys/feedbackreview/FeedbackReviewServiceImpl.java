package com.booksys.feedbackreview;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FeedbackReviewServiceImpl implements FeedbackReviewService {

    private final FeedbackReviewRepository feedbackReviewRepository;

    @Override
    public List<FeedbackReview> getAll() {
        return feedbackReviewRepository.findAll();
    }

    @Override
    public FeedbackReview getById(UUID id) {
        return feedbackReviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FeedbackReview not found with id: " + id));
    }

    @Override
    public FeedbackReview create(FeedbackReview feedbackReview) {
        return feedbackReviewRepository.save(feedbackReview);
    }

    @Override
    public FeedbackReview update(UUID id, FeedbackReview feedbackReview) {
        FeedbackReview existing = getById(id);
        existing.setRating(feedbackReview.getRating());
        existing.setComment(feedbackReview.getComment());
        existing.setCreatedAt(feedbackReview.getCreatedAt());
        existing.setGuest(feedbackReview.getGuest());
        existing.setHotel(feedbackReview.getHotel());
        return feedbackReviewRepository.save(existing);
    }

    @Override
    public void delete(UUID id) {
        feedbackReviewRepository.deleteById(id);
    }
}
