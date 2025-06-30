package com.odo.b2b.backend.ODO_B2B.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.odo.b2b.backend.ODO_B2B.mapper.CartMapper;
import com.odo.b2b.backend.ODO_B2B.model.Cart.CartEntity;
import com.odo.b2b.backend.ODO_B2B.model.Cart.CartItem;
import com.odo.b2b.backend.ODO_B2B.model.Cart.SaveCartRequest;
import com.odo.b2b.backend.ODO_B2B.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ObjectMapper objectMapper;


    public void saveCart(String memberId, SaveCartRequest request) {
        String cartId = cartMapper.findCartIdByMemberId(memberId);
        String cartItemsJson;
        try {
            cartItemsJson = objectMapper.writeValueAsString(request.getItems());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing cart items", e);
        }

        if (cartId == null) {
            cartId = new UUIDGenerator().generateUUID();
            cartMapper.insertCart(cartId, memberId, cartItemsJson);
        } else {
            cartMapper.updateCart(cartId, cartItemsJson);
        }
    }


    public void deleteCart(String memberId) {
        cartMapper.deleteCartByMemberId(memberId);
    }


    public List<CartItem> getCart(String memberId) {
        CartEntity entity = cartMapper.getCartByMemberId(memberId);
        if (entity == null || entity.getCartItems() == null) return Collections.emptyList();
        try {
            return objectMapper.readValue(
                    entity.getCartItems(),
                    new TypeReference<List<CartItem>>() {}
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing cart items", e);
        }
    }
}
