package Lists;

import java.io.PrintStream;

public interface List<E> extends Iterable<E> { // List inerface used for the creation of ArrrayList methods
    public void add(final E p0);
    
    public void add(final int p0, final E p1);
    
    public void clear();
    
    public E firstElement();
    
    public int firstIndex(final E p0);
    
    public E get(final int p0);
    
    public boolean isEmpty();
    
    public  boolean isMember(final E p0);
    
    public E lastElement();
    
    public int lastIndex(final E p0);
    
    public void print(final PrintStream p0);
    
    public boolean remove(final E p0);
    
    public boolean remove(final int p0);
    
    public int removeAll(final E p0);
    
    public E set(final int p0, final E p1);
    
    public int size();
}
