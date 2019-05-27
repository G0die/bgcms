package edu.bgcms.model.order;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Order {
    private String outTradeNo;

    private Double totalAmount;

    private String subject;

    private String body;

    private String objId;

    private String userId;

    private String alipayId;

    private Date createTime;

    private String status;

}