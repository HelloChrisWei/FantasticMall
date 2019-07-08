package com.cskaoyan.bean.goods;

public class GoodsUpDateData {
    private Goods goods;

    private  GoodsProduct goodsProduct;

    private  GoodsAttribute goodsAttribute;

    private  GoodsSpecification goodsSpecification;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsProduct getGoodsProduct() {
        return goodsProduct;
    }

    public void setGoodsProduct(GoodsProduct goodsProduct) {
        this.goodsProduct = goodsProduct;
    }

    public GoodsAttribute getGoodsAttribute() {
        return goodsAttribute;
    }

    public void setGoodsAttribute(GoodsAttribute goodsAttribute) {
        this.goodsAttribute = goodsAttribute;
    }

    public GoodsSpecification getGoodsSpecification() {
        return goodsSpecification;
    }

    public void setGoodsSpecification(GoodsSpecification goodsSpecification) {
        this.goodsSpecification = goodsSpecification;
    }
}
