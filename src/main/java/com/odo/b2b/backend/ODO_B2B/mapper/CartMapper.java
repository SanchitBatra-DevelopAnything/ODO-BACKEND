package com.odo.b2b.backend.ODO_B2B.mapper;

import com.odo.b2b.backend.ODO_B2B.model.Cart.CartEntity;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {

    String findCartIdByMemberId(@Param("memberId") String memberId);

    void insertCart(@Param("cartId") String cartId,
                    @Param("memberId") String memberId,
                    @Param("cartItemsJson") String cartItemsJson);

    void updateCart(@Param("cartId") String cartId,
                    @Param("cartItemsJson") String cartItemsJson);

    void deleteCartByMemberId(@Param("memberId") String memberId);

    CartEntity getCartByMemberId(@Param("memberId") String memberId);

}
