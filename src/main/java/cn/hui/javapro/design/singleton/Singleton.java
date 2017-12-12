package cn.hui.javapro.design.singleton;

public class Singleton {
    /**
     * 私有构造器，防止外部new
     */
    private Singleton() {}

    /**
     * 私有静态内部类，懒汉模式
     */
    private static class SingletonHolder {
        private final static Singleton intstance = new Singleton();
    }

    /**
     * 静态方法返回对象实例
     */
    public static Singleton getInstance() {
        return SingletonHolder.intstance;
    }

    public static void main(String[] args) {
        System.out.println("main start .......");
        Singleton.getInstance();
        System.out.println("main end .........");
    }
}