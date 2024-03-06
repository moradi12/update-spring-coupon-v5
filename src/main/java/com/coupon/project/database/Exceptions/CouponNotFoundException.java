package com.coupon.project.database.Exceptions;

public class CouponNotFoundException extends Exception {
    public CouponNotFoundException(String message) {
        super(message);
        System.out.println("Coupon not found: " + message);
    }
}
