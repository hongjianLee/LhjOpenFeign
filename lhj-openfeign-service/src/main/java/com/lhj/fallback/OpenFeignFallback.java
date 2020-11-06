package com.lhj.fallback;

import com.lhj.lhjcore.entity.User;
import com.lhj.service.IOpenFeignService;

import java.util.ArrayList;
import java.util.List;

public class OpenFeignFallback implements IOpenFeignService {

    private Throwable throwable;

    OpenFeignFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String echo(String str) {
        return "服务降级返回";
    }

    @Override
    public List<User> getUser(Long userId) {
        return new ArrayList<>();
    }
}
