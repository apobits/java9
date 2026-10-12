package apo.java.practice.inheritance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class BaseClass extends BaseSuperClass {
    @Override
    abstract ArrayList one() throws IOException;

    abstract void testThrows();

}
