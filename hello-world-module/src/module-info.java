module hello.world.module {
    requires java.desktop;
    requires greeting.module;
    uses greeting.greet.Greet;
}
