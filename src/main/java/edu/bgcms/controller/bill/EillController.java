package edu.bgcms.controller.bill;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import edu.bgcms.dao.BillMapper;
import edu.bgcms.dto.AjaxMsg;
import edu.bgcms.model.bill.Bill;
import edu.bgcms.model.boardGame.BoardGame;
import edu.bgcms.service.boardGame.BoardGameService;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("/add")
    public AjaxMsg add(Bill bill) {
        AjaxMsg msg = new AjaxMsg();
        int num = 0;
        try {
            num = billMapper.insert(bill);
        }catch (Exception e){
            e.printStackTrace();
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
