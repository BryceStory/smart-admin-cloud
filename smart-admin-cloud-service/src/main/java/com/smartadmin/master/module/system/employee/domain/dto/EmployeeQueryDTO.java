package com.smartadmin.master.module.system.employee.domain.dto;

import com.smartadmin.master.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/19
 */
@Data
public class EmployeeQueryDTO extends PageParamDTO {

    private String phone;

    private String actualName;

    private String keyword;

    private Long departmentId;

    private Integer isLeave;

    private Integer isDisabled;

    /**
     * 删除状态 0否 1是
     */
    @ApiModelProperty("删除状态 0否 1是 不需要传")
    private Integer isDelete;

    @ApiModelProperty("员工id集合")
    private List<Long> employeeIds;

}
