package com.pnshsh.mybatis.controller;

import com.pnshsh.mybatis.mapper.MetadataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private MetadataMapper metadataMapper;

    @RequestMapping("/helper")
    String helper(Model model) {
        List<String> databases = metadataMapper.queryDatabases();
        model.addAttribute("databases", databases);
        return "mybatis-helper";
    }
}
