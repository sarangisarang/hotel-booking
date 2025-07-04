-- Hotels
INSERT INTO hotels (id, name, address, phone, email, description, rating)
VALUES
('3ffd712e-9bec-4f41-a586-fbde15fb2915', 'Maison', 'Gorgaslis 5', '0099523213', 'bekakikalishvili@gmail.com', 'Center So bigger', 5);

-- Guests
INSERT INTO guest(id, first_name, last_name, birth_date, address, phone, email)
VALUES
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b432', 'Margalita', 'Petrovna', '1965-03-02', 'Wilkenstrasse 50', '+49-823-8228-333', 'petrovnamaria@gmail.com'),
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b643', 'Iylia', 'Saragona', '1945-03-02', 'Graf-Adolf-Platz 50', '+49-823-234-233', 'saragona@gmail.com');

-- Room Types
INSERT INTO room_types (id, name, description, price_per_night, capacity)
VALUES
('3ffd712e-9bec-4f41-a586-fbde15fb2916', 'Duplex', '2 rooms, 1 bathroom, internet, double bed', 100.00, 3),
('3ffd712e-9bec-4f41-a586-fbde15fb2917', 'Suite', '1 room, 1 bathroom, internet, king-size bed', 120.00, 2),
('3ffd712e-9bec-4f41-a586-fbde15fb2918', 'Economy', '1 room, small bathroom, internet', 60.00, 1);

-- Rooms
INSERT INTO room (id, room_number, room_status, hotel_id, room_type_id)
VALUES
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b567', '01', 'FREE', '3ffd712e-9bec-4f41-a586-fbde15fb2915', '3ffd712e-9bec-4f41-a586-fbde15fb2916'),
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b434', '02', 'FREE', '3ffd712e-9bec-4f41-a586-fbde15fb2915', '3ffd712e-9bec-4f41-a586-fbde15fb2916');

-- Staff
INSERT INTO staff (staffid, first_name, last_name, positions, salary, date_of_birth, phone, email, hotel_id, hire_date)
VALUES
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b454', 'Giorgi', 'Xokerashvili', 'Director', 700, '1965-03-02', '+49-169-2345-333', 'Xokerashvili@gmail.com', '3ffd712e-9bec-4f41-a586-fbde15fb2915', '2022-03-02');

-- Bookings
INSERT INTO bookings (id, check_in_date, check_out_date, total_amount, payment_status, guest_id, room_id)
VALUES
('3ffd712e-9bec-4f41-a586-fbde15fb3456', '2024-03-02', '2024-03-13', 350.00, 'PAID', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b432', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b567');

-- Payments
INSERT INTO payments (id, booking_id, amount, payment_method, payment_date, status)
VALUES
('3ffd712e-9bec-4f41-a586-fbde15fb2345', '3ffd712e-9bec-4f41-a586-fbde15fb3456', 350.00, 'TargoBank', '2023-02-03T00:00:00', 'PAID');

-- Feedback Reviews
INSERT INTO feedback_review (id, rating, comment, created_at, guest_id, hotel_id)
VALUES
('3ffd712e-9bec-4f41-a586-fbde15fb2346', 5, 'Super hotel, clean and comfortable.', '2023-02-03T00:00:00', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b432', '3ffd712e-9bec-4f41-a586-fbde15fb2915');

-- Invoices
INSERT INTO invoice (id, invoice_date, amount, file_url, booking_id)
VALUES
('3ffd712e-9bec-4f41-a586-fbde15fb9999', '2024-03-02T10:00:00', 350.00, 'https://hotel.com/invoices/invoice1.pdf', '3ffd712e-9bec-4f41-a586-fbde15fb3456');

-- Services
INSERT INTO service_entity (id, name, description, price)
VALUES
('9ffd712e-9bec-4f41-a586-fbde15fbabcd', 'Laundry', 'Laundry and ironing service', 15.00),
('5ffd712e-9bec-4f41-a586-fbde15fbabcd', 'Room Cleaning', 'Daily room cleaning', 10.00),
('7ffd712e-9bec-4f41-a586-fbde15fbabcd', 'Breakfast', 'Buffet breakfast', 12.00);


-- Service Requests
INSERT INTO service_request (id, request_date, guest_id, service_id, status)
VALUES
('a1fd712e-9bec-4f41-a586-fbde15fb0001', '2024-03-04T09:00:00', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b432', '9ffd712e-9bec-4f41-a586-fbde15fbabcd', 'PENDING'),
('a2fd712e-9bec-4f41-a586-fbde15fb0002', '2024-03-05T09:30:00', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b643', '5ffd712e-9bec-4f41-a586-fbde15fbabcd', 'COMPLETED');
