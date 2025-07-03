package com.booksys.guest;

import com.booksys.booking.Booking;
import com.booksys.feedbackreview.FeedbackReview;
import com.booksys.servicerequest.ServiceRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guest {

    @Id
    @GeneratedValue()
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate BirthDate;

    @OneToMany(mappedBy = "guest")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "guest")
    private List<ServiceRequest> serviceRequests;

    @OneToMany(mappedBy = "guest")
    private List<FeedbackReview> feedbackReviews;

}