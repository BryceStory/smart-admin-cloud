package com.smartadmin.master.module.system.employee;

import com.smartadmin.master.common.anno.NoValidPrivilege;
import com.smartadmin.master.common.anno.OperateLog;
import com.smartadmin.master.common.domain.PageResultDTO;
import com.smartadmin.master.common.domain.ResponseDTO;
import com.smartadmin.master.constant.SwaggerTagConst;
import com.smartadmin.master.module.system.employee.domain.dto.EmployeeQueryDTO;
import com.smartadmin.master.module.system.employee.domain.entity.EmployeeEntity;
import com.smartadmin.master.module.system.employee.domain.vo.EmployeeVO;
import com.smartadmin.master.utils.SmartHttpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/19
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_USER})
@OperateLog
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/first")
    @ApiOperation(value = "首个测试无参方法")
    public String getFirst() throws IOException {
        System.out.println("first");
        return "first";
    }

    @GetMapping("/get/all")
    @ApiOperation(value = "查询所有员工基本信息，用于选择框", notes = "查询所有员工基本信息，用于选择框")
    public ResponseDTO<List<EmployeeVO>> getAll() {
        return ResponseDTO.succData(employeeService.getAllEmployee());
    }

    @PostMapping("/query")
    @ApiOperation(value = "员工管理查询", notes = "员工管理查询")
    public ResponseDTO<PageResultDTO<EmployeeVO>> query(@RequestBody EmployeeQueryDTO query) {
        return employeeService.selectEmployeeList(query);
    }

    @PostMapping("/updateStatus/{employeeId}/{status}")
    @ApiOperation(value = "更新员工状态")
    public ResponseDTO<String> updateStatus(@PathVariable("employeeId") long employeeId, @PathVariable("status") Integer status) {
        return employeeService.updateStatus(employeeId, status);
    }

}
