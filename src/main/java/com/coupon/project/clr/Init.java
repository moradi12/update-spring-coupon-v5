package com.coupon.project.clr;

import com.coupon.project.database.Service.CompanyService;
import com.coupon.project.database.Service.CouponService;
import com.coupon.project.database.Service.CustomerService;
import com.coupon.project.database.beans.Company;
import com.coupon.project.database.beans.Coupon;
import com.coupon.project.database.beans.Customer;
import com.coupon.project.database.Exceptions.ErrMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;

//@Component
@Order(1)
public class Init implements CommandLineRunner {
    private final CustomerService customerService;
    private final CompanyService companyService;
    private final CouponService couponService;

    @Autowired
    public Init(CustomerService customerService, CompanyService companyService, CouponService couponService) {
        this.customerService = customerService;
        this.companyService = companyService;
        this.couponService = couponService;
    }

    /**
     * Runs the command line task to initialize the application
     * @param args Command line arguments.
     * @throws Exception If an error occurs during execution
     */

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running init class......");
        try {
            // Add Company
            companyService.addCompany(Company.builder()
                    .id(43)
                    .email("Try@mail.com")
                    .name("Tamir")
                    .password("123456")
                    .build());

            // Add Customer
            customerService.addCustomer(Customer.builder()
                    .id(23)
                    .email("BestCustomer@mail.com")
                    .firstName("Dobi")
                    .lastName("Bot")
                    .password("4899")
                    .build());

            // Add Coupon
            couponService.addCoupon(Coupon.builder()
                    .companyId(10)
                    .categoryId(5)
                    .title("Coupon TitleHardcode")
                    .description("Hotel")
                    .startDate(LocalDate.now())
                    .endDate(LocalDate.now().plusDays(30))
                    .amount(10)
                    .price(9.99)
                    .image("coupon_image.jpg")
                    .build());
        } catch (Exception e) {
            System.out.println(ErrMsg.DATABASE_CONNECTION_ERROR.getMsg());
        }
    }
}
