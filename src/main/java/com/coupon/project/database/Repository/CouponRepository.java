package com.coupon.project.database.Repository;

import com.coupon.project.database.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    List<Coupon> findByCompanyId(Integer companyId);

    List<Coupon> findByNameOrId(String name, int id);

    List<Coupon> findByPriceLessThan(Double maxPrice);

    List<Coupon> findByNameStartingWith(String name);

}
