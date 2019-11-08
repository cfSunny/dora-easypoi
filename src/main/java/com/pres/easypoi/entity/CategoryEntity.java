package com.pres.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author Dora
 * @date 2019/11/6 17:26
 **/
@Data
public class CategoryEntity {
    @Excel(name = "一级分类",orderNum = "1",fixedIndex=0)
    private String primaryClassification;

    @Excel(name = "二级分类",orderNum = "2",fixedIndex=1)
    private String secondaryClassification;

    @Excel(name = "三级分类",orderNum = "3",fixedIndex=2)
    private String threeLevelClassification;

    @Excel(name = "标题",orderNum = "4",fixedIndex = 3)
    private String title;

    @Excel(name = "详情1",orderNum = "5",fixedIndex = 4)
    private String detailsOne;

    @Excel(name = "图片",orderNum = "6",type = 2,fixedIndex = 5,imageType = 2)
    private byte[] imageUrl;

    @Excel(name = "作者",orderNum = "7",fixedIndex = 6)
    private String author;

    @Excel(name = "关键字",orderNum = "8",fixedIndex = 7)
    private String keyWord;

    @Excel(name = "描述",orderNum = "9",fixedIndex = 8)
    private String description;


    @Excel(name = "置顶（1是0否）",orderNum = "10",fixedIndex = 9)
    private Byte flagTop;

    @Excel(name = "排序（从大到小）",orderNum = "11",fixedIndex = 10)
    private Integer order;

    @Excel(name = "同类推荐（1是0否）",orderNum = "12",fixedIndex = 11)
    private Integer similarRecommendation;

    @Excel(name = "全局推荐（1是0否）",orderNum = "13",fixedIndex = 12)
    private Integer globalRecommendation;


    @Excel(name = "立即发布（1是0否）",orderNum = "14",fixedIndex = 13)
    private Integer immediateRelease ;


    @Excel(name = "详情2",orderNum = "15",fixedIndex = 14)
    private Integer detailsTwo ;


    @Excel(name = "详情3",orderNum = "16",fixedIndex = 15)
    private Integer detailsThree ;

    @Excel(name = "详情4",orderNum = "17",fixedIndex = 16)
    private Integer detailsFour ;

    @Excel(name = "详情5",orderNum = "18",fixedIndex = 17)
    private Integer detailsFive ;


    @Excel(name = "详情6",orderNum = "19",fixedIndex = 18)
    private Integer detailsSix ;

    @Excel(name = "详情7",orderNum = "20",fixedIndex = 19)
    private Integer detailsSeven ;




}
