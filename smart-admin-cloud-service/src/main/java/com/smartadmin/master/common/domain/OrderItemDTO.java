package com.smartadmin.master.common.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/19
 */
@Slf4j
@Data
public class OrderItemDTO {
    private String column;
    private boolean asc = true;
}
