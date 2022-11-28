package com.awin.test.controller;

import com.awin.test.entity.Test;
import com.awin.test.service.TestService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
    private final TestService service;

    @GetMapping("/notice/list")
    public ModelAndView getHello(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("text", "hello");
        mv.addObject("datas", service.getLists());
        return mv;
    }
    @GetMapping("/notice/detail")
    public ModelAndView getDetail(@RequestParam(name = "id", required = false, defaultValue = "0")long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("detail");
        if(id > 0)
        mv.addObject("data", service.getData(id).get());
        return mv;
    }
    @PostMapping("/notice/save")
    @ResponseBody
    public HttpStatus save(@RequestBody Test test){
        service.getData(test);

        return HttpStatus.OK;
    }
    @PostMapping("/notice/update/{id}")
    @ResponseBody
    public HttpStatus update(@PathVariable(name = "id")long id, @RequestBody Test test){
        test.setId(id);
        service.getData(test);
        return HttpStatus.OK;
    }
}
