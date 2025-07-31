package com.odo.b2b.backend.ODO_B2B.services;

import com.odo.b2b.backend.ODO_B2B.model.Order.OrderDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class OrderService {

    public void MakeOrderInsertable(OrderDTO order) throws Exception {
        String orderDate = order.getOrderDate();
        if (orderDate == null || orderDate.trim().isEmpty()) {
            throw new Exception("Order Date cannot be null");
        }

        String[] dateArray = orderDate.split("-");
        if (dateArray.length != 3) {
            throw new Exception("Invalid date format");
        }

        String day = dateArray[0].trim();
        String month = dateArray[1].trim();
        String year = dateArray[2].trim();

        if (day.length() == 1) {
            day = "0" + day;
        }

        if (month.length() == 1) {
            month = "0" + month;
        }

        String formattedDate = day + "-" + month + "-" + year;
        order.setOrderDate(formattedDate);

        // Convert to LocalDate and set to orderDateRectified
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate localDate = LocalDate.parse(formattedDate, formatter);
            order.setOrderDateRectified(localDate);
        } catch (DateTimeParseException e) {
            // handle invalid date (e.g., 31-02-2025)
            e.printStackTrace();
        }

        //make it an active order.
        order.setOrderStatus('A');

    }
}
