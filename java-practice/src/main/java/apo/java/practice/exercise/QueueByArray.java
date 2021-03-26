package apo.java.practice.exercise;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueByArray<T> {
    private Object[] elements = new Object[5];
    private int addIndex = 0, getIndex = 0;

    public void offer(Object object) {
	checkResize();
	elements[addIndex++] = object;
    }

    public Object poll() {
	if (getIndex == addIndex) {
	    throw new NoSuchElementException();
	}
	Object object = elements[getIndex];
	elements[getIndex++] = null;
	return object;
    }

    private void checkResize() {
	if (addIndex == elements.length) {
	    elements = Arrays.copyOf(elements, elements.length << 1);
	}
    }

}
