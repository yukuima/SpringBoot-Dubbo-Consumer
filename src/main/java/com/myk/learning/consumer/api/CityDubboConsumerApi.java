package com.myk.learning.consumer.api;

import com.myk.learning.domain.City;
import com.myk.learning.service.CityDubboService;
import com.myk.learning.utils.json.JSONParseUtils;
import com.myk.learning.utils.result.ApiResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市 Dubbo 服务消费者
 * <p>
 *
 * @author myk
 */
@RestController
public class CityDubboConsumerApi {

    @Autowired
    CityDubboService cityDubboService;


    /**
     * Print city string.
     *
     * @return the string
     */
    @ApiOperation(value = "测试Dubbo Rpc调用", response = ApiResult.class)
    @GetMapping("/getCity")
    public ApiResult printCity() {
        String cityName = "广州";
        City city = cityDubboService.findCityByName(cityName);
        String desc = cityDubboService.mmbMethod("Dubbo");
        return ApiResult.prepare().success(JSONParseUtils.object2JsonString(city), 200, desc);
    }
}
