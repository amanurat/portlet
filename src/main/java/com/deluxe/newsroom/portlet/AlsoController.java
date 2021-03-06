package com.deluxe.newsroom.portlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.deluxe.newsroom.service.ListService;

@RequestMapping(value = "VIEW")                                          
@Controller(value="alsoPortletController") 
public class AlsoController {
    private final Logger LOG = LoggerFactory.getLogger(AlsoController.class);

    @Autowired 
    ListService listService;
    
    @RenderMapping//(params="action=list")
    public String showList(Model model){
        LOG.info("Initialising the view");
        model.addAttribute("list", listService.generateListItems());
        return "also";
    }
    
    @ActionMapping//(params="key=value", value="aPortletAction") // from javax.portlet.action
    public void initList(){
        LOG.info("Initialising the portlet");
    }
    
}
