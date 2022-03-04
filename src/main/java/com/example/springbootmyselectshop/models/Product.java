package com.example.springbootmyselectshop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Product extends com.example.springbootmyselectshop.models.Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    public Product(com.example.springbootmyselectshop.models.ProductRequestDto requestDto){
        this.title=requestDto.getTitle();
        this.link=requestDto.getLink();
        this.lprice=requestDto.getLprice();
        this.image=requestDto.getImage();
        this.myprice=0;
    }

    public void updateByItemDto (ItemDto itemDto) {
        this.lprice = itemDto.getLprice();
    }

    public void update(com.example.springbootmyselectshop.models.ProductMypriceRequestDto requestDto){
        this.myprice=requestDto.getMyprice();
    }
}
