package com.shop.cart;

import java.math.BigDecimal;
import java.util.List;

import com.shop.util.BigDecimalUtil;

public class Function {

	private CartVo getCartVoLimit(Integer userId){
        CartVo cartVo = new CartVo();
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        List<CartProductVo> cartProductVoList = Lists.newArrayList();
 
        BigDecimal cartTotalPrice = new BigDecimal("0");
        if(org.apache.commons.collections.CollectionUtils.isNotEmpty(cartList)){
            for(Cart cartItem : cartList){
                CartProductVo cartProductVo = new CartProductVo();
                cartProductVo.setId(cartItem.getId());
                cartProductVo.setUserId(userId);
                cartProductVo.setProductId(cartItem.getProductId());
 
                Product product = productMapper.selectByPrimaryKey(cartItem.getProductId());
                if(product != null){
                    cartProductVo.setProductMainImage(product.getMainImage());
                    cartProductVo.setProductName(product.getName());
                    cartProductVo.setProductSubtitle(product.getSubtitle());
                    cartProductVo.setProductStatus(product.getStatus());
                    cartProductVo.setProductPrice(product.getPrice());
                    cartProductVo.setProductStock(product.getStock());
//                    �жϿ��
                    int buyLimitCount = 0;
                    if(product.getStock() >= cartItem.getQuantity()){
//                        ˵��������
                        buyLimitCount = cartItem.getQuantity();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
                    }else{
//                        ��治�����ʱ��
                        buyLimitCount = product.getStock();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);
                        //���ﳵ�и�����Ч���
                        Cart cartForQuantity = new Cart();
                        cartForQuantity.setId(cartItem.getId());
                        cartForQuantity.setQuantity(buyLimitCount);
                        cartMapper.updateByPrimaryKeySelective(cartForQuantity);
                    }
                    cartProductVo.setQuantity(buyLimitCount);
                    //�����ܼ�
                    cartProductVo.setProductTotalPrice(BigDecimalUtil.mul(product.getPrice().doubleValue(),cartProductVo.getQuantity()));
                    cartProductVo.setProductChecked(cartItem.getChecked());
                }
                if(cartItem.getChecked() == Const.Cart.CHECKED){
                    //����Ѿ���ѡ,���ӵ������Ĺ��ﳵ�ܼ���
                    cartTotalPrice = BigDecimalUtil.add(cartTotalPrice.doubleValue(),cartProductVo.getProductTotalPrice().doubleValue());
                }
                cartProductVoList.add(cartProductVo);
            }
        }
        cartVo.setCartTotalPrice(cartTotalPrice);
        cartVo.setCartProductVoList(cartProductVoList);
        cartVo.setAllChecked(this.getAllCheckedStatus(userId));
        cartVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));
 
        return cartVo;
    }

	
}
