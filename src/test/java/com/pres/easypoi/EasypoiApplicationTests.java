package com.pres.easypoi;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.pres.easypoi.entity.CategoryEntity;
import com.pres.easypoi.entity.CompanyHasImgModel;
import com.pres.easypoi.entity.StudentEntity;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

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

        CompanyHasImgModel o = ((CompanyHasImgModel) objects.get(0));
        BASE64Encoder base64Encoder = new BASE64Encoder();
        StringBuilder sb = new StringBuilder("data:image/png;base64,");
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

        // 将execl 转为csv
        // 拼装列
        CategoryEntity categoryEntity = new CategoryEntity();
        Class<? extends CategoryEntity> aClass = categoryEntity.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        String[] columnName = new String[declaredFields.length];
        AtomicInteger integer = new AtomicInteger();
        for (int i = 0; i < declaredFields.length; i++) {
            // 获取到属性
            Field declaredField = declaredFields[i];
            Excel annotation = declaredField.getAnnotation(Excel.class);
            if (null != annotation) {
                int g = integer.getAndIncrement();
                columnName[g] = annotation.name();
            }
        }

        String url = "F:\\downloads\\20191106191551_50542.csv";
        CSVFormat format = CSVFormat.DEFAULT.withHeader(columnName);
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(url)), "GBK"));
        CSVPrinter printer = new CSVPrinter(out, format);
        for (CategoryEntity entity : result) {
             // 输出列
            Class<? extends CategoryEntity> aClass1 = entity.getClass();
            Field[] fields = aClass1.getDeclaredFields();
            Object[] objects=new Object[fields.length];
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                Object o = fields[i].get(entity);
                objects[i]=o;
                if (Objects.isNull(o)) {
                    objects[i]=" ";
                }
            }
            printer.printRecord(objects);
        }
        printer.flush();
        printer.close();
        out.close();

//        //读取
//        Reader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(url)),"GBK"));
//        Iterable<CSVRecord> records = format.parse(in);
//
//        for (CSVRecord record : records) {
//            System.out.println(record.get("ID") + " " + record.get("Name"));
//        }


    }
}
