package com.cskaoyan.bean.goods;

public class GoodsAddData {
    private Goods goods;

    private  GoodsProduct[] products;

    private  GoodsAttribute[] attributes;

    private  GoodsSpecification[] specifications;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(GoodsProduct[] products) {
        this.products = products;
    }

    public GoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(GoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

    public GoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(GoodsSpecification[] specifications) {
        this.specifications = specifications;
    }
}
