package com.p2eb.backend.model;

import lombok.Data;

@Data // Lombok ашиглаж, бүх getter, setter-үүдийг автоматаар үүсгэнэ.
public class User {
    private String username;
    private String password;
    private String userNm;
    private String useYn;
    private String role;

    // @Data аннотаци ашигласнаар бүх шинж чанарт зориулсан getter, setter-үүд автоматаар үүснэ.
}
