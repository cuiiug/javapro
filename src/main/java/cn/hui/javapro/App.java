package cn.hui.javapro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    
    public static void main(String[] args) {
        testArrayListRemoveException();
        System.out.println("over.");
    }

    public static void testArrayListRemoveException(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(112);
        list.add(2);
        list.add(22);
        list.add(23);
        list.add(24);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.addAll(list);
        Iterator<Integer> it = list.iterator();
        //第一种删除
        for(;it.hasNext();){
            System.out.println(it.next());
            it.remove();
        }
        list2.remove(1);
        // 第二种删除
        for(int i = 0;i<list2.size();i++){
            Integer  s = list2.get(i);
            list.remove(s);
        }
    }
}
