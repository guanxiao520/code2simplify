package com.example.demo;

import lombok.Data;

/**
 * @author gx_hp
 * @version V1.0
 * @Package com.example.demo
 * @date 2021/5/15 12:44
 */
//shift+F6重命名类
public class simplifyCodeDemo {
    public static final int TARGET_SALARY = 20000;
    private String sexInfo;

    // 三种提高代码可读性的方式
    // extracted:提取为方法、常量、字段、变量、参数。
    // change signature:改变签名
    // rename: 重命名

    public void printInfo() {
        System.out.println("this is in SimplifyCode");

        XiaoMing xiaoMing = new XiaoMing("XiaoMing", "male");
        System.out.println("name=" + xiaoMing.getName());
        System.out.println("age=" + xiaoMing.getAge());
        //ctrl + alt +c (const)抽取常量
        System.out.println("期望薪资为:" + TARGET_SALARY+"元");
        //ctrl+alt+v 抽取变量
        int nameLength = xiaoMing.getName().length();
        System.out.println("名字长度: " + nameLength);
        //ctrl + alt +M 抽取方法
        sexPrint(xiaoMing, "未婚");
    }


    //ctrl +alt +P parameter抽取参数,将未婚作为状态
    private void sexPrint(XiaoMing xiaoMing, final String marriageStatus) {
        switch (xiaoMing.getSex()) {
            case "male":
                //ctrl +alt +f filed抽取字段
                sexInfo = "此人性别为";
                System.out.println(sexInfo + "男性" + marriageStatus);
            case "female":
                System.out.println(sexInfo + "女性" + marriageStatus);
            default:
                System.out.println(sexInfo + "此人跨性别" + marriageStatus);
        }
    }

    @Data
    public static class XiaoMing {
        private String name;
        private Integer age;
        private String sex;
        private String salary;


        //改变构造方法签名 ctrl + F6
        XiaoMing(String name, String sex) {
            this.name = name;
        }
    }
}