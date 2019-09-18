package com.zf.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SendMsg {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    @ResponseBody
    public String send(){
        jmsMessagingTemplate.convertAndSend("queue-zf","hello zf!");
        return "success";
    }

    //发送map
    @RequestMapping("/sendMap")
    @ResponseBody
    public String sendMap(){
        Map map = new HashMap();
        map.put("id","001");
        map.put("name","张峰");
        map.put("age","24");
        jmsMessagingTemplate.convertAndSend("queue-zhangfeng",map);
        return "sendsuccess";
    }
}
