package io.github.mportilho.sentencecompiler.syntaxtree.function.teste2;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getName(Integer num) {
        return name + " - " + num;
    }

    public void setName(String name) {
        this.name = name;
    }
}
