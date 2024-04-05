package com.example.compositefile;

import java.util.ArrayList;
import java.util.List;

public class Directory implements  Component{

    private String name;
    private List<Component> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display() {
        System.out.println("Directory: " + name);
        for (Component component : components) {
            component.display();
        }
    }

    public List<Component> getComponents() {
        return components;
    }
}
