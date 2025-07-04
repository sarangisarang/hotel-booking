package com.booksys.feedbackreview;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/feedback-reviews")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FeedbackReviewController {

    private final FeedbackReviewService feedbackReviewService;

    @GetMapping
    public ResponseEntity<List<FeedbackReview>> getAll() {
        return ResponseEntity.ok(feedbackReviewService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackReview> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(feedbackReviewService.getById(id));
    }

    @PostMapping
    public ResponseEntity<FeedbackReview> create(@RequestBody FeedbackReview feedbackReview) {
        return ResponseEntity.ok(feedbackReviewService.create(feedbackReview));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackReview> update(@PathVariable UUID id, @RequestBody FeedbackReview feedbackReview) {
        return ResponseEntity.ok(feedbackReviewService.update(id, feedbackReview));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        feedbackReviewService.delete(id);
        return ResponseEntity.noContent().build();
    }
}