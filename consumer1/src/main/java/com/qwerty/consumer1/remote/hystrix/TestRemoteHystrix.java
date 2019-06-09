package com.qwerty.consumer1.remote.hystrix;

import com.qwerty.consumer1.remote.TestRemote;
import org.springframework.stereotype.Component;

@Component
public class TestRemoteHystrix implements TestRemote {
    @Override
    public String test() {
        return "出错啦";
    }
}
