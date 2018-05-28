package com.lizhenjie.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:01 2018/5/11
 * @Modified By:
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}

