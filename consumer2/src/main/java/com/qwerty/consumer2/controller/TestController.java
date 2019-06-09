package com.qwerty.consumer2.controller;

import com.qwerty.consumer2.remote.TestRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private TestRemote testRemote;

    /**
     * 获取所有服务
     */
    @RequestMapping("services")
    public Object services(){
        return discoveryClient.getInstances("service-producer");
    }

    /**
     * 从所有服务中选择一个服务（轮询）
     */
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancer.choose("service-producer").getUri().toString();
    }

    @RequestMapping("/test")
    public String test() {
        return testRemote.test();
    }

    @RequestMapping("/test2")
    public String test2() {
        ServiceInstance serviceInstance=loadBalancer.choose("service-producer");
        String result=new RestTemplate().getForObject(serviceInstance.getUri().toString()+"/test",String.class);
        return result;
    }

}
