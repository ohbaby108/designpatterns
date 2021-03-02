package com.xinrui.doubledetection;
/**
 * 双重检查
 * */
public class Singleton {
    private Singleton(){}//私有的构造方法
    private volatile static Singleton single;
    // 私有的访问权限让被人不能随便操作属性，
    //volatile保证原子性（防止指令重排序）
    // static 只能new Sinleton();一次
    //懒汉式加载让服务器较少承载压力

    public static Singleton getInstance(){//static不用new 通过类名直接调用方法
        if (single==null){
            synchronized (Singleton.class){
                if (single==null){
                    single=new Singleton();
                }
            }
        }
        return single;
    }
}
