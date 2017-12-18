package cn.hui.javapro.list.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class BaseArrayList{
    public static void add(){
        Queue q = new LinkedList();
        q = new PriorityQueue();
        Map<String,String> mp = new HashMap<String,String>();
        List<Object> arraylist = new ArrayList<Object>();
        arraylist.add(1, 100);
    }
    public static void main(String[] args) {
        add();
        System.out.println("guojianhui121");
    }
}