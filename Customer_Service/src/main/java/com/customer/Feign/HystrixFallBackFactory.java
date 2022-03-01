package com.customer.Feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixFallBackFactory implements FallbackFactory<Feign> {
    @Override
    public Feign create(Throwable cause) {

    System.out.println("fallback reason was:" + cause.getMessage());
    return null;

    }
}
