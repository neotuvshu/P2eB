package com.p2eb.backend.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_sys_user")
public class User {

    @Id
    private String username;

    private String password;
    private String userNm;
    private String useYn;
    private String role;

    // @Data аннотаци ашигласнаар бүх шинж чанарт зориулсан getter, setter-үүд автоматаар үүснэ.
}
