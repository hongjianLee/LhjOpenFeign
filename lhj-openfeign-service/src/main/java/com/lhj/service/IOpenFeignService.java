package com.lhj.service;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import com.lhj.fallback.OpenFeignServiceFallbackFactory;
import com.lhj.lhjcore.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "lhjService", fallbackFactory = OpenFeignServiceFallbackFactory.class)
@DubboTransported(protocol = "dubbo")
public interface IOpenFeignService {

    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);

    @GetMapping("/getUser")
    List<User> getUser(@RequestParam("uesrId") Long userId);
}
