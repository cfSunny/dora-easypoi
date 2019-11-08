package com.pres.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @author Dora
 * @date 2019/11/6 14:42
 **/
@ExcelTarget("teacherEntity")
@Data
public class TeacherEntity {
    private String id;
    /** name */
    @Excel(name = "主讲老师_major,代课老师_absent", orderNum = "1", isImportField = "true_major,true_absent",needMerge = true)
    private String name;
}
