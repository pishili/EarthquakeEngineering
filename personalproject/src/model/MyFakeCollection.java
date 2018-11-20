package model;

import java.util.Iterator;

public class MyFakeCollection implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Integer> {

        private int current = 1;

        @Override
        public
        boolean hasNext() {
            return current+1 <= 10;
        }

        @Override
        public
        Integer next() {
            current += 1;
            return current;
        }

        @Override
        public
        void remove() {
            // Nothing
        }
    }
}


