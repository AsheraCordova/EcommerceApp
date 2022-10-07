package com.ashera.jsonadapter;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NSMutableArrayList<E> extends java.util.AbstractList<E> {
	@com.google.j2objc.annotations.Property Object nsmutableArray;
	/*-[
	- (instancetype)init {
	  if ((self = [super init])) {
	    nsmutableArray_ = [NSMutableArray array];
	  }
	  return self;
		}
	]-*/;
	public Object getNsmutableArray() {
		return nsmutableArray;
	}
	public NSMutableArrayList(Object nsmutableArray) {
		this.nsmutableArray = nsmutableArray;
	}
	@Override
	public native int size()/*-[
  		return (int) [(NSMutableArray*)self->nsmutableArray_ count];
	]-*/;

	@Override
	public boolean isEmpty() {
		return nsmutableArray == null || size() == 0;
	}

	@Override
	public native boolean contains(Object o)/*-[
	  return [(NSMutableArray*)self->nsmutableArray_ containsObject:o];
	]-*/;


	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}

	@Override
	public Object[] toArray() {
		return (Object[]) getNativeArray(nsmutableArray);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return (T[]) getNativeArray(nsmutableArray);
	}

	private native Object getNativeArray(Object nsarray) /*-[
	  return [IOSObjectArray arrayWithNSArray:nsarray type:[IOSClass forName: @"java.lang.Object"]];
	]-*/;
	@Override
	public boolean add(E e)  {
		add(-1, e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		int i = indexOf(o);
		if (i >= 0) {
			removeObject(o);
			return true;
		}
		return false;
	}
	
	public native void removeObject(Object e) /*-[
	  [(NSMutableArray*)self->nsmutableArray_ removeObject:e];
	]-*/;

	@Override
	public boolean containsAll(Collection<?> c) {
		return super.containsAll(c);	
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return super.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return super.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return super.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return super.retainAll(c);	
	}

	@Override
	public native void clear() /*-[
	  [(NSMutableArray*)self->nsmutableArray_ removeAllObjects];
	]-*/;

	@Override
	public native E get(int index) /*-[
		return [(NSMutableArray*)self->nsmutableArray_ objectAtIndex:index];;
	]-*/;

	@Override
	public E set(int index, E element) {
		E oldValue = get(index);
		nativeSet(index, element);
		return oldValue;
	}
	
	public native void nativeSet(int index, E element) /*-[
		[(NSMutableArray*)self->nsmutableArray_ replaceObjectAtIndex:index withObject:element];
	]-*/;

	@Override
	public native void add(int index, E element) /*-[
		if (index == -1) {
	  		[(NSMutableArray*)self->nsmutableArray_ addObject:element];
		} else {
			[(NSMutableArray*)self->nsmutableArray_ insertObject:element atIndex:index];
		}
	]-*/;

	@Override
	public E remove(int index)  {
		E oldValue = get(index);
		removeObjectAtIndex(index);
		return oldValue;
	}
	private native void removeObjectAtIndex(int index) /*-[
		[(NSMutableArray*)self->nsmutableArray_ removeObjectAtIndex:index];
	]-*/;


	@Override
	public native int indexOf(Object o) /*-[
		return (int) [(NSMutableArray*)self->nsmutableArray_ indexOfObject: o];
	]-*/;

	@Override
	public native int lastIndexOf(Object o) /*-[
		NSMutableArray* rArray=[[[(NSMutableArray*)self->nsmutableArray_ reverseObjectEnumerator] allObjects] mutableCopy];
		return (int) [rArray indexOfObject:o];
	]-*/;

	@Override
	public ListIterator<E> listIterator() {
		return  new ListItr(0);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new ListItr(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
}

	private class Itr implements Iterator<E> {
        // Android-changed: Add "limit" field to detect end of iteration.
        // The "limit" of this iterator. This is the size of the list at the time the
        // iterator was created. Adding & removing elements will invalidate the iteration
        // anyway (and cause next() to throw) so saving this value will guarantee that the
        // value of hasNext() remains stable and won't flap between true and false when elements
        // are added and removed from the list.
        protected int limit = NSMutableArrayList.this.size();

        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor < limit;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            int i = cursor;
            if (i >= limit)
                throw new NoSuchElementException();
            cursor = i + 1;
            return (E) NSMutableArrayList.this.get(lastRet = i);
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

            try {
            	NSMutableArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
                limit--;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> consumer) {
        	throw new RuntimeException("Unimplemented");
        }
    }

    /**
     * An optimized version of AbstractList.ListItr
     */
    private class ListItr extends Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        @SuppressWarnings("unchecked")
        public E previous() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            cursor = i;
            return (E) NSMutableArrayList.this.get(lastRet = i);
        }

        public void set(E e) {
            if (lastRet < 0)
                throw new IllegalStateException();
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

            try {
            	NSMutableArrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(E e) {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

            try {
                int i = cursor;
                NSMutableArrayList.this.add(i, e);
                cursor = i + 1;
                lastRet = -1;
                expectedModCount = modCount;
                limit++;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
