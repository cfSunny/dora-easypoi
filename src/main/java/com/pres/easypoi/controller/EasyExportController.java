package com.pres.easypoi.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.entity.vo.TemplateExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.pres.easypoi.entity.CompanyHasImgModel;
import com.pres.easypoi.entity.CourseEntity;
import com.pres.easypoi.entity.StudentEntity;
import com.pres.easypoi.entity.TeacherEntity;
import lombok.SneakyThrows;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Dora
 * @date 2019/11/6 13:16
 **/
@RestController
@RequestMapping("/easy/poi")
public class EasyExportController {


    @SneakyThrows
    public static void main(String[] args) {
        CompanyHasImgModel companyHasImgModel = new CompanyHasImgModel();
        Class<? extends CompanyHasImgModel> aClass = companyHasImgModel.getClass();
//
//        Field[] fields =  aClass.getDeclaredFields();
//        for (int i = 0; i < fields.length; i++) {
//            Field field = fields[i];
//            boolean array = field.getType().isArray();
//            if (array) {
//                Class<?> componentType = field.getType().getComponentType();
//                System.out.println("primitive = " +componentType.getName());
//            }
//
//        }
        Method[] methods = aClass.getMethods();
        Method method = aClass.getMethod("method", byte.class);
        method.getParameterTypes();
        aClass.getDeclaredFields();
        aClass.getFields();
        method.invoke(companyHasImgModel,(byte)1);

        System.out.println("companyHasImgModel.getCompanyId() = " + companyHasImgModel.getCompanyId());
    }

    @RequestMapping("/stu")
    public void test(ModelMap map, HttpServletRequest request,
                     HttpServletResponse response) {
        ArrayList<StudentEntity> studentEntities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(i + "");
            studentEntity.setBirthday(new Date());
            studentEntity.setName(i + "a");
            studentEntity.setRegistrationDate(new Date());
            studentEntity.setSex(1);
            studentEntities.add(studentEntity);
        }

        ExportParams params = new ExportParams("计算机一班学生", "学生", ExcelType.XSSF);
        // 设置title所占空格
        params.setFreezeCol(5);
        map.put(NormalExcelConstants.DATA_LIST, studentEntities);
        map.put(NormalExcelConstants.CLASS, StudentEntity.class);
        map.put(NormalExcelConstants.PARAMS, params);
        // 文件名字设置
        map.put(TemplateExcelConstants.FILE_NAME, "计算机一班学生");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @RequestMapping("/cou")
    @SneakyThrows
    public void test2(ModelMap map, HttpServletRequest request,
                      HttpServletResponse response) {
        ArrayList<StudentEntity> studentEntities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(i + "");
            studentEntity.setBirthday(new Date());
            studentEntity.setName(i + "a");
            studentEntity.setRegistrationDate(new Date());
            studentEntity.setSex(1);
            studentEntities.add(studentEntity);
        }
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\86185\\Pictures\\Saved Pictures\\8725c3ede80d94a14c44a68c3dc9788b.jpg"));
        byte[] bytes=new byte[fileInputStream.available()];
        fileInputStream.close();
        ArrayList<CourseEntity> courseEntities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setId(i + "");
            courseEntity.setName("高数");
            courseEntity.setStudents(studentEntities);

            courseEntity.setLogo(bytes);
            TeacherEntity teacherEntity = new TeacherEntity();
            teacherEntity.setId(i + "");
            teacherEntity.setName("花花");
            courseEntity.setMathTeacher(teacherEntity);
            courseEntities.add(courseEntity);
        }

        ExportParams params = new ExportParams("科目详细", "科目", ExcelType.XSSF);
        // 设置title所占空格
        params.setFreezeCol(6);
        map.put(NormalExcelConstants.DATA_LIST, courseEntities);
        map.put(NormalExcelConstants.CLASS, CourseEntity.class);
        map.put(NormalExcelConstants.PARAMS, params);
        // 文件名字设置
        map.put(TemplateExcelConstants.FILE_NAME, "科目详细");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @RequestMapping("/img")
    @SneakyThrows
    public void test03(ModelMap map, HttpServletRequest request,
                     HttpServletResponse response) {
        ArrayList<CompanyHasImgModel> list = new ArrayList<>();
        File file=new File("F:\\excel\\upload\\img\\CategoryEntity\\pic12772152433.JPG");
        InputStream inputStream=new FileInputStream(file);
        byte[] bytes=new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        list = new ArrayList<CompanyHasImgModel>();
        list.add(new CompanyHasImgModel((byte)1,"百度", bytes, "北京市海淀区西北旺东路10号院百度科技园1号楼"));
        list.add(new CompanyHasImgModel((byte)2,"阿里巴巴", bytes, "北京市海淀区西北旺东路10号院百度科技园1号楼"));
        list.add(new CompanyHasImgModel((byte)3,"Lemur", bytes, "亚马逊热带雨林"));
        list.add(new CompanyHasImgModel((byte)4,"一众", bytes, "山东济宁俺家"));

        ExportParams params = new ExportParams("图片导入", "学生", ExcelType.XSSF);
        // 设置title所占空格
        params.setFreezeCol(4);
        map.put(NormalExcelConstants.DATA_LIST, list);
        map.put(NormalExcelConstants.CLASS, CompanyHasImgModel.class);
        map.put(NormalExcelConstants.PARAMS, params);
        // 文件名字设置
        map.put(TemplateExcelConstants.FILE_NAME, "图片导入");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }



}
