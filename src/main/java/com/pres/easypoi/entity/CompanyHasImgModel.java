package com.pres.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Dora
 * @date 2019/11/6 16:19
 **/
@Data
@ExcelTarget("companyHasImgModel")
@NoArgsConstructor
@AllArgsConstructor

public class CompanyHasImgModel implements Serializable {
    @Excel(name = "id",width=40,orderNum = "1",fixedIndex = 0)
    private int companyId;

    @Excel(name = "公司名字",width=40,orderNum = "2",fixedIndex = 1)
    private String companyName;


    @Excel(name = "公司LOGO", type = 2 ,width = 40 , height = 20,imageType = 2,orderNum = "3",fixedIndex = 2)
    private byte[] companyLogo;


    @Excel(name = "公司地址",width = 40,orderNum = "4",fixedIndex = 3)
    private String address;


}
