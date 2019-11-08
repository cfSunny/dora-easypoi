package com.pres.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Dora
 * @date 2019/11/6 14:41
 **/
@Data
@ExcelTarget("courseEntity")
public class CourseEntity implements Serializable {

    /** 主键 */
    private String        id;
    /** 课程名称 */
    @Excel(name = "课程名称", orderNum = "1", width = 25,needMerge = true)
    private String        name;
    /** 老师主键 */
    @ExcelEntity(id = "absent")
    private TeacherEntity mathTeacher;

    @ExcelCollection(name = "学生", orderNum = "4")
    private List<StudentEntity> students;

    @Excel(name = "公司LOGO", type = 2 ,width = 40 , height = 20,imageType = 2)
    private byte[] logo;



}
