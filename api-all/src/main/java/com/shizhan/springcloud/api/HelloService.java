package com.shizhan.springcloud.api;

import java.util.List;

/**
 * Created by xiaos 2019/1/28
 * //TODO 写点注释吧
 */
public interface HelloService {

    String sayHello(String name);

    List<String> sayHellos(List<String> names);

}
