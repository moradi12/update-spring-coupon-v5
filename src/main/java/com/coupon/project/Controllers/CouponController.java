package com.coupon.project.Controllers;

import com.coupon.project.database.Exceptions.CouponNotFoundException;
import com.coupon.project.database.Service.CouponService;
import com.coupon.project.database.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling coupon-related HTTP requests
 */
@RestController
@RequestMapping("project/coupon/v2/spring/coupon/api/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    /**
     * Retrieves all coupons
     * @return List of all coupons
     */
    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    /**
     * Adds a new coupon
     * @param coupon The coupon to add
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@Validated @RequestBody Coupon coupon) {
        couponService.addCoupon(coupon);
    }

    /**
     * Updates an existing coupon.
     * @param id     The ID of the coupon to update
     * @param coupon The updated coupon data
     * @throws CouponNotFoundException If the coupon with the given ID is not found
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@PathVariable int id, @RequestBody Coupon coupon) throws CouponNotFoundException {
        couponService.updateCoupon(id, coupon);
    }

    /**
     * Deletes a coupon.
     * @param id The ID of the coupon to delete
     * @throws CouponNotFoundException If the coupon with the given ID is not found
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCoupon(@PathVariable int id) throws CouponNotFoundException {
        couponService.deleteCoupon(id);
    }

    /**
     * Retrieves a single coupon by ID
     * @param id The ID of the coupon to retrieve
     * @return The retrieved coupon
     * @throws CouponNotFoundException If the coupon with the given ID is not found
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coupon getSingleCoupon(@PathVariable int id) throws CouponNotFoundException {
        return couponService.getOneCoupon(id);
    }
}
