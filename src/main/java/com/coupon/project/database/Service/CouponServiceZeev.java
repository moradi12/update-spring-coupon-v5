package com.coupon.project.database.Service;

import com.coupon.project.database.Repository.CouponRepository;
import com.coupon.project.database.beans.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CouponServiceZeev {
    final CouponRepository couponRepository;

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public Coupon getCouponByID(Integer couponID) {
        return couponRepository.findById(couponID).orElse(null);
    }
}

