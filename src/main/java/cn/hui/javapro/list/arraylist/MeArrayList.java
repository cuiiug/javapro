package cn.hui.javapro.list.arraylist;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.Consumer;

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
     * transient 不参与序列化，只能修饰成员变量，不能修饰方法、类、局部变量
     * 
     */
    transient Object[] elementData; // non-private to simplify nested class access

    /**
     * 暂：改List size被修改的次数
     */
    protected transient int modCount = 0;

    /**
    * 返回List中元素个数.
    */
    public int size() {
        return size;
    }

    /**
     * 返回List中是否没有元素
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回List是否包含 o ，调用indexof 方法
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
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

    /**
     * 返回List中第一个出现 o 的位置，如果没有 返回-1
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
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

    private class Itr implements Iterator<E> {
        int cursor; // 下一个元素的index
        int lastRet = -1; // 最后一个元素的index；没有返回-1
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size;
        }

        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = MeArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                MeArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            final int size = MeArrayList.this.size;
            int i = cursor;
            if (i >= size) {
                return;
            }
            final Object[] elementData = MeArrayList.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            while (i != size && modCount == expectedModCount) {
                consumer.accept((E) elementData[i++]);
            }
            // update once at end of iteration to reduce heap write traffic
            cursor = i;
            lastRet = i - 1;
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

    }

}