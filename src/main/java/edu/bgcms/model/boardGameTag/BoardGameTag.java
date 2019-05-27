package edu.bgcms.model.boardGameTag;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardGameTag {
    private String uuid;

    private String name;
    /**
     1.用户：UUID、账号、密码，名字，性性别，角色，经验，电话，邮箱，学院，专业，年级，生日，省份，城市，格言，未读消息数，是否禁止登陆，个人主页是否展示个人隐私标志。
     2.桌游：UUID、名字、类型、说明、最大玩家数量、购买日期、购买金额、申请人、申请时间、当前持有人、当前状态、浏览次数、出借次数、关注次数、评分。
     3.账单：UUID、类型、标题、备注、金额、当前余额，创建人、使用时间，创建时间。
     4.评论：UUID，图片id，接收方id，发送方id，评论对象id，上一个评论id，等级，创建时间，内容。
     5.公告通知：UUID、标题、类型、内容、时间、创建人、附件。
     6.订单：订单编号、总金额、订单名字、商品描述、商品id、用户id、支付宝订单号、创建时间、订单状态。
     7.权限：ID、权限名字、路径。
     8.角色：ID、角色名字

     */

}