package edu.bgcms.controller.bill;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import edu.bgcms.dao.BillMapper;
import edu.bgcms.model.bill.Bill;
import edu.bgcms.model.boardGame.BoardGame;
import edu.bgcms.service.boardGame.BoardGameService;
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

    @ResponseBody
    @RequestMapping("/getList")
    public List<Bill> getList() {
        List<Bill> bills = billMapper.selectAll();
        return bills;
    }
}
