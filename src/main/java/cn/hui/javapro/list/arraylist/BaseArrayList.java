package cn.hui.javapro.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class BaseArrayList{
    public static void add(){
        List<Object> arraylist = new ArrayList<Object>();
        arraylist.add(1, 100);
    }
    public static void main(String[] args) {
        add();
        System.out.println("guojianhui");
    }
}