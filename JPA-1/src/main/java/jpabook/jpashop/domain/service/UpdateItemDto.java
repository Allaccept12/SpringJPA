package jpabook.jpashop.domain.service;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UpdateItemDto {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    public void changeData(Long id,String name, int price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
