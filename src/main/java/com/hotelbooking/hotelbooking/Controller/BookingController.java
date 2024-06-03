package com.hotelbooking.hotelbooking.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotelbooking.hotelbooking.Entity.Account;
import com.hotelbooking.hotelbooking.Entity.HotelBooking;
import com.hotelbooking.hotelbooking.Entity.Room;
import com.hotelbooking.hotelbooking.Service.BookingHotelService;
import com.hotelbooking.hotelbooking.Service.RoomService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {
    
    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingHotelService bookingService;    
    
    @PostMapping("/booking")
    public String booking(@RequestBody Map<String, String> payload, HttpSession session ) {
        System.out.println("booking");
        Account account = (Account) session.getAttribute("account");
        HotelBooking newBooking = bookingService.createBooking(payload,account);
        return "redirect:/hotels";
    }
}