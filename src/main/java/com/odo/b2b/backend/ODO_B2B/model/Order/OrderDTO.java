package com.odo.b2b.backend.ODO_B2B.model.Order;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @JsonProperty("GST")
    private String GST;
    private String area;
    private String contact;
    @JsonProperty("delivery-latitude")
    private String deliveryLatitude;
    @JsonProperty("delivery-longitude")
    private String deliveryLongitude;
    private String deviceToken;
    private List<OrderItem> items;
    private String orderDate;
    private String orderTime;
    private LocalDate orderDateRectified;
    private String orderedBy;
    private String shop;
    private String shopAddress;
    private Double totalPrice;
    private Double totalPriceAfterDiscount;
    private Character orderStatus;
}
