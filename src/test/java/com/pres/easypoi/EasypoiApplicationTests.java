package com.pres.easypoi;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.pres.easypoi.entity.CategoryEntity;
import com.pres.easypoi.entity.CompanyHasImgModel;
import com.pres.easypoi.entity.StudentEntity;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class EasypoiApplicationTests {

    @Test
    @SneakyThrows
    public void contextLoads() {
        ImportParams params = new ImportParams();
        params.setNeedSave(true);
        params.setHeadRows(2);
        File file = new File("F:\\downloads\\图片导入.xlsx");
        InputStream inputStream = new FileInputStream(file);
        List<Object> objects = ExcelImportUtil.importExcel(
                inputStream,
                CompanyHasImgModel.class, params);

        CompanyHasImgModel   o = ((CompanyHasImgModel) objects.get(0));
        BASE64Encoder base64Encoder=new BASE64Encoder();
        StringBuilder sb=new StringBuilder("data:image/png;base64,");
        sb.append(base64Encoder.encode(o.getCompanyLogo()));
        System.out.println(sb.toString());
        inputStream.close();

    }



    @Test
    @SneakyThrows
    public void test1() {
        ImportParams params = new ImportParams();
        params.setNeedSave(true);
        params.setHeadRows(2);
        File file = new File("F:\\downloads\\计算机一班学生.xlsx");

        List<StudentEntity> result = ExcelImportUtil.importExcel(
                file,
                StudentEntity.class, params);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(ReflectionToStringBuilder.toString(result.get(i)));
        }

    }

    @Test
    @SneakyThrows
    public void test2() {
        ImportParams params = new ImportParams();
        params.setNeedSave(true);
        params.setHeadRows(3);
        File file = new File("F:\\excel\\upload\\excelUpload\\CategoryEntity\\20191106191551_50542.xls");

        List<CategoryEntity> result = ExcelImportUtil.importExcel(
                file,
                CategoryEntity.class, params);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("图片:"+ReflectionToStringBuilder.toString(result.get(i)));
        }

    }
}
