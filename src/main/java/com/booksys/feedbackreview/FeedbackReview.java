package com.booksys.feedbackreview;
import com.booksys.guest.Guest;
import com.booksys.hotel.Hotel;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="feedback_review")
public class FeedbackReview {

    @Id
    @GeneratedValue
    private UUID id;

    private int rating;
    private String comment;
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
