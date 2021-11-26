package com.smartadmin.master.module.system.employee;

import com.alibaba.fastjson.JSON;
import com.smartadmin.master.module.system.employee.domain.dto.EmployeeQueryDTO;
import com.smartadmin.master.utils.SmartHttpUtil;
//import com.smartadmin.master.utils.SmartRedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
//import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/24
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private RedissonClient redissonClient;

    @GetMapping("/first")
    public String first() {
        System.out.println("dsada");
        log.info("test  info !!!!!!!!!!!!!!!!!!!");
        return "test first";
    }

    @GetMapping("/testSendHttpPostJson")
    public void testSendHttpPostJson() throws Exception {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("phone", "");
        objectMap.put("actualName", "测试");
        objectMap.put("keyword", "");
        objectMap.put("departmentId", 17);
        objectMap.put("isLeave", 0);
        objectMap.put("isDisabled", 0);
        objectMap.put("isDelete", 0);
        objectMap.put("employeeIds", Collections.emptyList());
        objectMap.put("pageNum", 1);
        objectMap.put("pageSize", "");
        objectMap.put("searchCount", "");
        objectMap.put("orders", "");

        EmployeeQueryDTO employeeQueryDTO = new EmployeeQueryDTO();
        employeeQueryDTO.setPhone("");
        employeeQueryDTO.setActualName("");
        employeeQueryDTO.setKeyword("");
        employeeQueryDTO.setDepartmentId(Long.valueOf(17));
        employeeQueryDTO.setIsLeave(0);
        employeeQueryDTO.setIsDisabled(0);
        employeeQueryDTO.setIsDelete(0);
        employeeQueryDTO.setEmployeeIds(null);
        employeeQueryDTO.setPageNum(1);
        employeeQueryDTO.setPageSize(1);
        employeeQueryDTO.setSearchCount(false);
        employeeQueryDTO.setOrders(null);

        String jsonString = JSON.toJSONString(employeeQueryDTO);

        //String sendPostJson = SmartHttpUtil.sendPostForm("http://localhost:8888/employee/query", objectMap, null);
        String sendPostJson = SmartHttpUtil.sendPostJson("http://localhost:8888/employee/query", jsonString, null);

        System.out.println(sendPostJson);
    }

//    @GetMapping("/testRedisson")
//    public void testRedisson() {
//        SmartRedisUtil.set("s", "hello world");
//    }
}
