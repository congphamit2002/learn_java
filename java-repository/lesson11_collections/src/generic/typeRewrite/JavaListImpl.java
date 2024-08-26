package generic.typeRewrite;

import java.lang.reflect.Array;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class JavaListImpl<E> implements IList<E> {
    private static final int DEFAULT_CAPACITY = 4;

    private static final int PLUS_CAPACITY = 10;

    private int size = 0;

    private E[] elementData;

    public JavaListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public JavaListImpl(int newCapacity) {
        int capacity = Math.max(newCapacity, DEFAULT_CAPACITY);
        this.elementData = newInstance(capacity);
    }

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            this.elementData = grow(size + PLUS_CAPACITY);
        }
        this.elementData[size++] = e;
        return true;
    }

    @Override
    public boolean addAll(IList<E> list) {
        return false;
    }

    @Override
    public boolean remove(int removedIndex) {
        checkIndex(removedIndex);
        for (int i = removedIndex; i < size - 1; i++) {
            this.elementData[i] = elementData[i + 1];
        }
        this.elementData[size - 1] = null;
        size--;
        return true;
    }

    @Override
    public boolean remove(E e) {
        int i = 0;
        for (; i < size; i++) {
            if(elementData[i].equals(e)) {
                break;
            }
        }
        remove(i);
        return true;
    }

    @Override
    public boolean removeIf(Predicate<E> predicate) {
        int i = 0;
        for (; i < size; i++) {
            if (predicate.test(elementData[i])) {
                break;
            }
        }
        remove(i);
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return this.elementData[index];
    }

    @Override
    public void set(int index, E e) {
        checkIndex(index);
        this.elementData[index] = e;
    }

    @Override
    public void printf() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.elementData[i] + " ");
        }
    }

    @Override
    public void forEach(Consumer<E> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.elementData[i]);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private E[] grow(int newCapacity) {
        E[] newElementData = newInstance(newCapacity);
        for (int i = 0; i < this.size; i++) {
            newElementData[i] = this.elementData[i];
        }
        return newElementData;
    }

    @SuppressWarnings("unchecked")
    private E[] newInstance(int length) {
        return (E[]) Array.newInstance(Object.class, length);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
    }
}
