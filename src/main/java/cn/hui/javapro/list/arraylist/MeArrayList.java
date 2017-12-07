package cn.hui.javapro.list.arraylist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class MeArrayList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    /**
     * Java 的序列化机制：通过运行时判断类的serialVersionUID来验证版本一致性；在进行反序列时，JVM会把传过来的字节流中的serialVersionUID
     *                   与本地响应实体（类）的serialVersionUID进行比较，相同就认为一致，可以进行反序列化，否则就会出现序列化版本不一致
     *                   的异常。（InvalidCastException）
     * serialVersionUID有两种显示生产方式：1、1L 2、根据类名、接口名、成员方法及属性等来生成一个64位的哈希字段
     * 
     * 
     */
    private static final long serialVersionUID = 1L;
    
     /**
     * List中元素个数
     *
     */
    private int size;
     /**
     * 返回List中元素个数.
     */
    public int size() {
        return size;
    }
  

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public Object[] toArray() {
        return null;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(E e) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public E get(int index) {
        return null;
    }

    public E set(int index, E element) {
        return null;
    }

    public void add(int index, E element) {

    }

    public E remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

}