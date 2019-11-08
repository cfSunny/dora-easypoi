package com.pres.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.pres.easypoi.entity.CategoryEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * @author Dora
 * @date 2019/11/6 15:11
 **/
@RestController
@RequestMapping("/easy/poi/import")
public class EasyImportController {


    @GetMapping
    public void test1(){
        ImportParams params = new ImportParams();
        params.setNeedSave(true);
        params.setHeadRows(3);
        File file = new File("F:\\excel\\upload\\excelUpload\\CategoryEntity\\20191106191551_50542.xls");

        List<CategoryEntity> result = ExcelImportUtil.importExcel(
                file,
                CategoryEntity.class, params);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(ReflectionToStringBuilder.toString(result.get(i)));
        }
    }
}
