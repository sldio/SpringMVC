package com.servlet.controller;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController
{
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    List<String> list = new ArrayList<String>();

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addMessage(@RequestParam(value = "message", required = false) String message, ModelMap model)
    {
        StringBuilder builder = new StringBuilder();
        if (message == null){
            message = "there is no messages yet";
            System.out.println("------------------------------------------------------");
            System.out.println(logger.isTraceEnabled());
            logger.trace(message);
            logger.debug(message);
            logger.info(message);
            logger.warn(message);
            logger.error(message);
        }
        else
        {
            list.add(message);

            for (int i = 0; i < list.size(); i++)
            {
                builder.append("<li>").append(list.get(i)).append("</li>");
            }
            logger.info("makes massage");
        }
        model.addAttribute("message", builder.toString());
        logger.info("work`s ok");
        return "add";
    }

    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    public String clearMessages(ModelMap model){
        list = new ArrayList<String>();
        model.addAttribute("message", "cleared");
        logger.info("cleared");
        return "add";
    }
}