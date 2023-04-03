package org.example;

public class Main {
    public static void main(String[] args) {
      ContainerSc.init();
       new App().run();
       ContainerSc.close();
    }
}