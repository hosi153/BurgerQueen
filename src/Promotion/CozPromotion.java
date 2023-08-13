package Promotion;

import Cart.Cart;

public class CozPromotion implements Promotion{
    @Override
    public void promotion() {
        Cart.carts.add(new Cart("[프로모션]장난감",0,1));
    }
}
