package Lists;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{

	    @SuppressWarnings("hiding")
		private class ListIterator<E> implements Iterator<E>
	    {
	        private int currentPosition;
	        
	        public ListIterator() {
	            this.currentPosition = 0;
	        }
	        
	        @Override
	        public boolean hasNext() {
	            return this.currentPosition < ArrayList.this.size();
	        }
	        
	        @SuppressWarnings("unchecked")
			@Override
	        public E next() {
	            if (this.hasNext()) {
	                return (E)ArrayList.this.elements[this.currentPosition++];
	            }
	            throw new NoSuchElementException();
	        }
	    }
	    private int currentSize;
	    
	    private E[] elements;
	    
	    @SuppressWarnings("unchecked")
		public ArrayList(final int initialCapacity) {
	        if (initialCapacity < 1) {
	            throw new IllegalArgumentException("Capacity must be at least 1.");
	        }
	        this.currentSize = 0;
	        this.elements = (E[])new Object[initialCapacity];
	    }
	    
	    @Override
	    public void add(final E e) {
	        if (e == null) {
	            throw new IllegalArgumentException("Argument object cannot be null.");
	        }
	        if (this.currentSize == this.elements.length) {
	            this.reAllocate();
	        }
	        this.elements[this.currentSize++] = e;
	    }
	    
	    @Override
	    public void add(final int index, final E e) {
	        if (e == null) {
	            throw new IllegalArgumentException("Argument object cannot be null.");
	        }
	        if (index == this.size()) {
	            this.add(e);
	        }
	        else {
	            if (index < 0 || index >= this.currentSize) {
	                throw new ArrayIndexOutOfBoundsException();
	            }
	            if (this.currentSize == this.elements.length) {
	                this.reAllocate();
	            }
	            for (int i = this.currentSize; i > index; --i) {
	                this.elements[i] = this.elements[i - 1];
	            }
	            this.elements[index] = e;
	            ++this.currentSize;
	        }
	    }
	    
	    @Override
	    public void clear() {
	        for (int i = 0; i < this.currentSize; ++i) {
	            this.elements[i] = null;
	        }
	        this.currentSize = 0;
	    }
	    
	    @Override
	    public E firstElement() {
	        if (this.isEmpty()) {
	            return null;
	        }
	        return this.elements[0];
	    }
	    
	    @Override
	    public int firstIndex(final E e) {
	        for (int i = 0; i < this.currentSize; ++i) {
	            if (this.elements[i].equals(e)) {
	                return i;
	            }
	        }
	        return -1;
	    }
	    
	    @Override
	    public E get(final int index) {
	        if (index >= 0 && index < this.size()) {
	            return this.elements[index];
	        }
	        throw new ArrayIndexOutOfBoundsException();
	    }
	    
	    @Override
	    public boolean isEmpty() {
	        return this.size() == 0;
	    }
	    
	    @Override
	    public boolean isMember(final E e) {
	        return this.firstIndex(e) >= 0;
	    }
	    
	    @Override
	    public Iterator<E> iterator() {
	        return new ListIterator<E>();
	    }
	    
	    @Override
	    public E lastElement() {
	        if (this.isEmpty()) {
	            return null;
	        }
	        return this.elements[this.currentSize - 1];
	    }
	    
	    @Override
	    public int lastIndex(final E e) {
	        for (int i = this.currentSize - 1; i >= 0; --i) {
	            if (this.elements[i].equals(e)) {
	                return i;
	            }
	        }
	        return -1;
	    }
	    
	    @Override
	    public void print(final PrintStream out) {
	        for (int i = 0; i < this.size(); ++i) {
	            out.print(this.elements[i]);
	            out.print(" ");
	        }
	        out.println();
	    }
	    
	    @SuppressWarnings("unchecked")
		private void reAllocate() {
	        final Object[] newElements = new Object[2 * this.elements.length];
	        for (int i = 0; i < this.currentSize; ++i) {
	            newElements[i] = this.elements[i];
	        }
	        this.elements = (E[])newElements;
	    }
	    
	    @Override
	    public boolean remove(final E e) {
	        if (e == null) {
	            throw new IllegalArgumentException("Argument object cannot be null.");
	        }
	        int target = -1;
	        for (int i = 0; i < this.currentSize; ++i) {
	            if (this.elements[i].equals(e)) {
	                target = i;
	                break;
	            }
	        }
	        if (target == -1) {
	            return false;
	        }
	        for (int i = target; i < this.currentSize - 1; ++i) {
	            this.elements[i] = this.elements[i + 1];
	        }
	        this.elements[--this.currentSize] = null;
	        return true;
	    }
	    
	    @Override
	    public boolean remove(final int index) {
	        if (index >= 0 && index < this.currentSize) {
	            for (int i = index; i < this.currentSize - 1; ++i) {
	                this.elements[i] = this.elements[i + 1];
	            }
	            this.elements[--this.currentSize] = null;
	            return true;
	        }
	        throw new ArrayIndexOutOfBoundsException();
	    }
	    
	    @Override
	    public int removeAll(final E e) {
	        int counter = 0;
	        while (this.remove(e)) {
	            ++counter;
	        }
	        return counter;
	    }
	    
	    @Override
	    public E set(final int index, final E e) {
	        if (e == null) {
	            throw new IllegalArgumentException("Object cannot be null");
	        }
	        if (index >= 0 && index < this.size()) {
	            final E temp = this.elements[index];
	            this.elements[index] = e;
	            return temp;
	        }
	        throw new ArrayIndexOutOfBoundsException();
	    }
	    
	    @Override
	    public int size() {
	        return this.currentSize;
	    }
	}