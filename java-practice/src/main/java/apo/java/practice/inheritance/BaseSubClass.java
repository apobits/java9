package apo.java.practice.inheritance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class BaseSubClass extends BaseClass implements BaseSuperInterface{

    @Override
    public ArrayList one() throws IOException {
        return null;
    }

    @Override
    void testThrows() {

    }

    @Override
    public LinkedList two() {
        return null;
    }
}
