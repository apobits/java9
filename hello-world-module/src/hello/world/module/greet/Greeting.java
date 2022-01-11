package hello.world.module.greet;

import greeting.greet.Greet;

import javax.swing.*;
import java.util.Locale;
import java.util.ServiceLoader;

public class Greeting {
    public static void main(String[] args) {
	var serviceLoader = ServiceLoader.load(Greet.class).stream().filter(t -> t.get().getLocale().equals(Locale.ENGLISH)).findFirst();

	JOptionPane.showMessageDialog(null, serviceLoader.get().get().sayHi("Albin"));
    }
}
