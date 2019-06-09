package com.qwerty.consumer1.remote;

import com.qwerty.consumer1.remote.hystrix.TestRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="service-producer",fallback = TestRemoteHystrix.class)
public interface TestRemote {
    /*
    * 这里要保证请求url一致，不过方法名和返回值类型可以不同
    * */
    @RequestMapping("test")
    String test();

}
