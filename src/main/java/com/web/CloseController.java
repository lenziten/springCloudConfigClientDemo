package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.config.ApplicationUtils;

@RefreshScope
@RestController
@RequestMapping("/exit")
public class CloseController{
	
    
    private String getFrom(){
    	return ApplicationUtils.getProperties("from");
    }
    
    @RequestMapping(value="/from",method=RequestMethod.GET)
    private String from(){
    	return "from " + getFrom();
    }
    
    @RequestMapping("/shutDown")
	public String shutDownBoot(){
    	int result = SpringApplication.exit(ApplicationUtils.getApplicationContext());
		return String.valueOf(result);
	}

}
