package com.qwerty.consumer2.remote.hystrix;

import com.qwerty.consumer2.entity.DemoEntity;
import com.qwerty.consumer2.remote.TestRemote;
import org.springframework.stereotype.Component;

@Component
public class TestRemoteHystrix implements TestRemote {
    @Override
    public String test() {
        return "出错啦";
    }
}
