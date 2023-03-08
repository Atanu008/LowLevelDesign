package org.bms.controller;

import org.bms.services.BookingService;
import org.bms.services.PaymentsService;

public class PaymentController {
    private final PaymentsService paymentsService;
    private final BookingService bookingService;

    public PaymentController(PaymentsService paymentsService, BookingService bookingService) {
        this.paymentsService = paymentsService;
        this.bookingService = bookingService;
    }

    public  void handlePaymentFailure(String bookingId, String user){
        paymentsService.processPaymentFailed(bookingService.getBooking(bookingId), user);
    }

    public  void handlePaymentSuccess(String bookingId, String user){
        bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
    }
}
