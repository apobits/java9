import greeting.greet.internal.GreeterEN;
import greeting.greet.internal.GreeterES;

module greeting.module {
    exports greeting.greet;
    provides greeting.greet.Greet with GreeterEN, GreeterES;
}
