package edu.bgcms.dto;

import edu.bgcms.model.order.Order;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDto extends Order {
    private String objName;
    private String userName;
}
