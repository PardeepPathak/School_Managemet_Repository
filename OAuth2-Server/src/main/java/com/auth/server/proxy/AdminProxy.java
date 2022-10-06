package com.auth.server.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Data-Base-Service")
public interface AdminProxy {

}
