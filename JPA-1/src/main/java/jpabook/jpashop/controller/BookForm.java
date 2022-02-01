package jpabook.jpashop.controller;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;

//    public void changeData(long id, String name, int price, int stockQuantity, String author, String isbn) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.stockQuantity = stockQuantity;
//        this.author = author;
//        this.isbn = isbn;
//    }
}
