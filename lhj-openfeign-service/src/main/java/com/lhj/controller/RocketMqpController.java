package com.lhj.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.lhj.lhjRocketmqp.IService.IMqProducerService;
import com.lhj.service.IOpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 李洪健
 * @since 2020-11-03
 */
@Slf4j
@RestController
@RequestMapping("/roketmqp")
public class RocketMqpController {

    @Reference(version = "${dubbo.consumer.versoin}")
    private IMqProducerService mqProducerService;

    @Autowired
    private IOpenFeignService openFeignService;

    @GetMapping("echo/{echo}")
    @SentinelResource(value = "fallback",blockHandler = "blockEcho")
    public String echo(@PathVariable String echo){
        return openFeignService.echo(echo);
    }
    public String blockEcho(@PathVariable String echo, BlockException blockException){
        return "501 进入sentinel BlockHandler方法";
    }

    @GetMapping("getUser/{userId}")
    public List getUser(@PathVariable("userId") Long userId){
        return openFeignService.getUser(userId);
    }

    @GetMapping("message/{id}")
    public String get(@PathVariable Long id) {
        String resultMsg = mqProducerService.sendMessageToMQ("test", "test",
                JSON.toJSONString(id));
        log.debug(resultMsg);
        return resultMsg;
    }

}
