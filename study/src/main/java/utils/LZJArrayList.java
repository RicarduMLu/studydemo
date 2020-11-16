package utils;

/**
 * ArrayList
 *
 * @author lzj10
 * @create 2020-11-14-宪22:42
 */
public class LZJArrayList implements LZJList{
    private static final int DEFAULT_CAPACITY = 16 ;
    int[] elementData;
    private int size;


    public LZJArrayList() {
        this.elementData = new int[DEFAULT_CAPACITY];
    }
    public LZJArrayList(int initCapaticy) {
        if (initCapaticy > 0) {
            this.elementData = new int[initCapaticy];
        }else {
            throw new IllegalArgumentException("initCapaticy error"+initCapaticy);
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int indexOf(int o) {
        return 0;
    }

    @Override
    public boolean contains(int e) {
        return false;
    }

    @Override
    public boolean add(int e) {
        return false;
    }

    @Override
    public void add(int index, int element) {

    }

    @Override
    public int set(int index, int element) {
        return 0;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int remove(int index) {
        return 0;
    }

    @Override
    public void clear() {

    }
}
