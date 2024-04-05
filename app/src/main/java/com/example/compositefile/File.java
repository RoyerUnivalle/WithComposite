package com.example.compositefile;

public class File implements Component{
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}
