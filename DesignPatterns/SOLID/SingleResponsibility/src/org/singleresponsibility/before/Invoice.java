package org.singleresponsibility.before;

//https://www.freecodecamp.org/news/solid-principles-explained-in-plain-english/

// calculateTotal method, which calculates the total price,
// printInvoice method, that should print the invoice to console, and
// saveToFile method, responsible for writing the invoice to a file

// The first violation is the printInvoice method, which contains our printing logic.
// The SRP states that our class should only have a single reason to change,
// and that reason should be a change in the invoice calculation for our class.

// But in this architecture, if we wanted to change the printing format, we would need to change the class.
// This is why we should not have printing logic mixed with business logic in the same class.

// There is another method that violates the SRP in our class: the saveToFile method.
// It is also an extremely common mistake to mix persistence logic with business logic.

//Possible Solution
// We can create new classes for our printing and persistence logic
// so we will no longer need to modify the invoice class for those purposes.

//We create 2 classes, InvoicePrinter and InvoicePersistence, and move the methods.

public class Invoice {
    private Book book;
    private int quantity;
    private double discountRate;
    private double taxRate;
    private double total;

    public Invoice(Book book, int quantity, double discountRate, double taxRate) {
        this.book = book;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.taxRate = taxRate;
        this.total = this.calculateTotal();
    }

    public double calculateTotal() {
        double price = ((book.price - book.price * discountRate) * this.quantity);

        double priceWithTaxes = price * (1 + taxRate);

        return priceWithTaxes;
    }

    public void printInvoice() {
        System.out.println(quantity + "x " + book.name + " " +          book.price + "$");
        System.out.println("Discount Rate: " + discountRate);
        System.out.println("Tax Rate: " + taxRate);
        System.out.println("Total: " + total);
    }

    public void saveToFile(String filename) {
        // Creates a file with given name and writes the invoice
    }
}
