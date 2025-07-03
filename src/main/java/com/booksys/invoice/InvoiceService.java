package com.booksys.invoice;

import java.math.BigDecimal; import java.util.List; import java.util.UUID;

public interface InvoiceService {
    Invoice createInvoice(UUID bookingId, BigDecimal amount, String fileUrl);
    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(UUID id);
    void deleteInvoice(UUID id);
}
