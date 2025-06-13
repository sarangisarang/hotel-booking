-- Hotels
INSERT INTO Hotel(hotelID, hotel_Name, address, phone, email, stars, check_In_Time, check_Out_Time)
VALUES
('3ffd712e-9bec-4f41-a586-fbde15fb2915', 'maison', 'gorgaslis 5', '0099523213', 'maison@gmail.com', 5, '11:00:00', '12:00:00'),
('4304a544-b508-41c0-89fd-8bf7cf02a09b', 'maison', 'gorgaslis 5', '0099523213', 'bekakikalishvili18@gmail.com', 5, '11:00:00', '12:00:00'),
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b498', 'maison', 'gorgaslis 5', '0099523213', 'bekakikalishvili18@gmail.com', 5, '11:00:00', '12:00:00'),
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b345', 'maison', 'gorgaslis 5', '0099523213', 'irakligogrebashvili8@gmail.com', 5, '11:00:00', '12:00:00');

INSERT INTO Guest(guestID, first_Name, last_Name, date_Of_Birth, address, phone, email)
VALUES
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b434', 'Margalita', 'Petrovna', '1965-03-02', 'wilkenstrase 50', '+49-823-8228-333', 'petrovnamaria@gmail.com'),
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b567', 'Iylia', 'Saragona', '1945-03-02', 'Graf-Adof-Platz 50', '+49-823-234-233', 'saragona@gmail.com');

INSERT INTO Room_type(type_Id, name, description, price_Per_Night, capacity)
VALUES
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b234', 'duplex', '2 room, 1 badroom, internet, double bed', 100.00, 3),
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b212', 'duplex', '1 room, 1 badroom, internet, double bed', 50.00, 1),
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b432', 'duplex', '1 room, 1 badroom, internet, double bed', 60.00, 3);

INSERT INTO Room(roomID, room_Status, hotel_id, type_id)
VALUES
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b567', 'FREE', '4304a544-b508-41c0-89fd-8bf7cf02a09b', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b234'),
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b434', 'FREE', '4304a544-b508-41c0-89fd-8bf7cf02a09b', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b234');

INSERT INTO Staff(staffId, first_Name, last_Name, positions, salary, date_Of_Birth, phone, email, hotel_id, hire_Date)
VALUES
('fd6f9c8d-f15a-448f-83d3-8e55d2c8b454', 'Giorgi', 'Xokerashvili', 'direktor', 700, '1965-03-02', '+49-169-2345-333', 'Xokerashvili@gmail.com', '3ffd712e-9bec-4f41-a586-fbde15fb2915', '2022-03-02');

'''INSERT INTO Booking(bookingID, check_in, check_out, total_Price, guest_ID, room_ID)
'''VALUES
''''('3ffd712e-9bec-4f41-a586-fbde15fb3456', '2024-03-02', '2024-03-13', 100, 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b434', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b567'),
''''('3ffd712e-9bec-4f41-a586-fbde15fb3324', '2024-03-03', '2024-03-15', 100, 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b434', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b567'),
''''('3ffd712e-9bec-4f41-a586-fbde15fb3564', '2024-03-04', '2024-03-16', 100, 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b434', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b567'),
''''('3ffd712e-9bec-4f41-a586-fbde15fb3876', '2024-03-05', '2024-03-17', 100, 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b434', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b567'),
''''('3ffd712e-9bec-4f41-a586-fbde15fb3987', '2024-03-06', '2024-03-18', 100, 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b434', 'fd6f9c8d-f15a-448f-83d3-8e55d2c8b567');

INSERT INTO Payment(paymentID, amount, payment_Date, payment_Method)
VALUES
('3ffd712e-9bec-4f41-a586-fbde15fb2345', 100, '2023-02-03', 'TargoBank');
