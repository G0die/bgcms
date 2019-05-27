package edu.bgcms.controller.workflow;

import edu.bgcms.dao.BoardGameMapper;
import edu.bgcms.dao.BorrowFormMapper;
import edu.bgcms.dao.UserMapper;
import edu.bgcms.dto.AjaxMsg;
import edu.bgcms.dto.BorrowFormDto;
import edu.bgcms.model.boardGame.BoardGame;
import edu.bgcms.model.user.User;
import edu.bgcms.model.workFlow.BorrowForm;
import edu.bgcms.utils.MyTools;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/workflow")
public class WorkflowController {
    @Autowired
    BorrowFormMapper borrowFormMapper;
    @Autowired
    BoardGameMapper boardGameMapper;
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/myForms")
    public String toForm() {
        return "/workflow/myForms";
    }

    @RequestMapping(value = "/pendingFormsView")
    public String pendingFormsView() {
        return "/workflow/pendingForms";
    }
    @ResponseBody
    @RequestMapping("/getPendingForms")
    public AjaxMsg getPendingForms() {
        AjaxMsg ajaxMsg = new AjaxMsg();
        try{
            List<BorrowFormDto> list =borrowFormMapper.selectListByApprover(MyTools.getCurUser().getUuid());
            ajaxMsg.setStatus(1);
            ajaxMsg.setData(list);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("获取待我审批失败");
            return ajaxMsg;
        }

        return ajaxMsg;
    }

    @ResponseBody
    @RequestMapping("/getMyForms")
    public AjaxMsg getMyForms() {
        AjaxMsg ajaxMsg = new AjaxMsg();
        try{
            List<BorrowFormDto> list =borrowFormMapper.selectListByApplicant(MyTools.getCurUser().getUuid());
            ajaxMsg.setStatus(1);
            ajaxMsg.setData(list);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("获取我的申请失败");
            return ajaxMsg;
        }

        return ajaxMsg;
    }
    @ResponseBody
    @RequestMapping("/approval")
    public AjaxMsg addWF(String formId) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        try{
            BorrowForm bf =borrowFormMapper.selectByPrimaryKey(formId);
            bf.setCurStep(bf.getCurStep()+1);
            borrowFormMapper.updateByPrimaryKey(bf);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("审批失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("审批成功");
        return ajaxMsg;
    }
    @ResponseBody
    @RequestMapping("/veto")
    public AjaxMsg veto(String formId) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        try{
            BorrowForm bf =borrowFormMapper.selectByPrimaryKey(formId);
            bf.setCurStep(bf.getCurStep()-1);
            borrowFormMapper.updateByPrimaryKey(bf);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("审批失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("审批成功");
        return ajaxMsg;
    }
    @ResponseBody
    @RequestMapping("/addWF")
    public AjaxMsg addWF(BorrowForm borrowForm) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        borrowForm.setCreateTime(new Date());
        borrowForm.setUuid(MyTools.getUUID());
        /**
         * 0是拥有者审批
         * 1申请者拿到
         */
        borrowForm.setCurStep(0);
        try{
           int ins =borrowFormMapper.insert(borrowForm);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("提交失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("提交成功");
        return ajaxMsg;
    }
    /**
     * 跳转表单页面
     * @return
     */
    @RequestMapping(value = "/toForm")
    public String toForm(HttpServletRequest request, Model model) {
        String formId = request.getParameter("formId");
        String bgId = request.getParameter("bgId");
        BorrowFormDto borrowForm = new BorrowFormDto();
        try {
            if(!StringHelper.isNullOrEmptyString(bgId)){
                BoardGame bg = boardGameMapper.selectByPrimaryKey(bgId);
                borrowForm.setBgName(bg.getName());
                borrowForm.setBgId(bg.getUuid());
                borrowForm.setCurUserName(userMapper.selectByPrimaryKey(bg.getCurrentuser()).getUuid());
                borrowForm.setCurUser(bg.getCurrentuser());
                borrowForm.setApplicant(MyTools.getCurUser().getUuid());
                borrowForm.setApplicantName(userMapper.selectByPrimaryKey(MyTools.getCurUser().getUuid()).getUuid());
            }
            if(!StringHelper.isNullOrEmptyString(formId)){
                borrowForm = borrowFormMapper.selectByPKRetunDto(formId);
                model.addAttribute("formId",formId);
                User user = MyTools.getCurUser();
                if(borrowForm.getCurStep()==0){
                    if(borrowForm.getCurUser().equals(user.getUuid())){
                        model.addAttribute("self",true);
                    }else {
                        model.addAttribute("self",false);
                    }
                }
                if(borrowForm.getCurStep()==1){
                    if(borrowForm.getApplicant().equals(user.getUuid())){
                        model.addAttribute("self",true);
                    }else {
                        model.addAttribute("self",false);
                    }
                }
            }
            model.addAttribute("bf",borrowForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/workflow/form";
    }
}
