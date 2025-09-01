package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Immutable Order class using Builder pattern.
 */
public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.lines = new ArrayList<>();
        for (OrderLine line : builder.lines) {
            this.lines.add(new OrderLine(line.getSku(), line.getQuantity(), line.getUnitPriceCents()));
        }
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    public static Builder builder(String id, String customerEmail) {
        return new Builder(id, customerEmail);
    }

    public static class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited = false;
        private String notes;

        private Builder(String id, String customerEmail) {
            this.id = id;
            this.customerEmail = customerEmail;
        }

        public Builder addLine(OrderLine line) {
            if (line != null) {
                this.lines.add(line);
            }
            return this;
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            validateId();
            validateEmail();
            validateLines();
            validateDiscount();
            return new Order(this);
        }

        private void validateId() {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("Order ID cannot be null or empty");
            }
        }

        private void validateEmail() {
            if (customerEmail == null || !isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email format: " + customerEmail);
            }
        }

        private void validateLines() {
            if (lines.isEmpty()) {
                throw new IllegalArgumentException("Order must have at least one line");
            }
        }

        private void validateDiscount() {
            if (discountPercent != null && (discountPercent < 0 || discountPercent > 100)) {
                throw new IllegalArgumentException("Discount percent must be between 0 and 100, got: " + discountPercent);
            }
        }

        private boolean isValidEmail(String email) {
            if (email == null || email.trim().isEmpty()) {
                return false;
            }
            
            int atIndex = email.indexOf('@');
            if (atIndex <= 0 || atIndex == email.length() - 1) {
                return false;
            }
            
            int lastAtIndex = email.lastIndexOf('@');
            if (atIndex != lastAtIndex) {
                return false;
            }
            
            String domain = email.substring(atIndex + 1);
            int dotIndex = domain.indexOf('.');
            if (dotIndex <= 0 || dotIndex == domain.length() - 1) {
                return false;
            }
            
            return true;
        }
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return Collections.unmodifiableList(lines); }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }
}
