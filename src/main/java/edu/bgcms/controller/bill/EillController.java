package edu.bgcms.controller.bill;

import edu.bgcms.dao.BillMapper;
import edu.bgcms.dto.AjaxMsg;
import edu.bgcms.model.bill.Bill;
import edu.bgcms.model.user.User;
import edu.bgcms.utils.MyTools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class EillController {
    @Autowired
    private BillMapper billMapper;

    @RequestMapping("/index")
    public String index(Model model) {
        List<Bill> bills = billMapper.selectAll();
        model.addAttribute("bills",bills);
        return "/bill/index";
    }

    @RequestMapping("/addView")
    public String addView() {
        return "/bill/addView";
    }


    @ResponseBody
    @RequestMapping("/getSurplus")
    public double getSurplus() {
        double surplus = billMapper.selectSurplus();
        return  surplus;
    }

    @ResponseBody
    @RequestMapping("/add")
    public AjaxMsg add(Bill bill) {
        double surplus = billMapper.selectSurplus();
        if("收入".equals(bill.getType())){
            bill.setSurplus(surplus +bill.getAmount());
        } else {
            bill.setSurplus(surplus - bill.getAmount());
        }
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        bill.setCreator(user.getUuid());
        bill.setUuid(MyTools.getUUID());
//        bill.setCreattime(LocalDateTime.now());
        bill.setCreattime(new Date());
        AjaxMsg msg = new AjaxMsg();
        int num = 0;
        try {
            num = billMapper.insert(bill);
        }catch (Exception e){
            msg.setStatus(0);
            msg.setMsg("系统异常,添加失败");
            e.printStackTrace();
            return msg;
        }
        if(num>0){
            msg.setStatus(1);
            msg.setMsg("添加成功");
        }else {
            msg.setStatus(0);
            msg.setMsg("添加失败");
        }

        return msg;
    }
}
