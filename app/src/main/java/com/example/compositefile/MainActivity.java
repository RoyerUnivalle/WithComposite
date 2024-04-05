package com.example.compositefile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // enlazamiento
        textView = findViewById(R.id.textView);

        // Crear archivos
        Component file1 = new File("file1.txt");
        Component file2 = new File("file2.txt");

        // Crear directorios y agregar archivos
        Directory dir1 = new Directory("dir1");
        dir1.addComponent(file1);
        dir1.addComponent(file2);

        Directory dir2 = new Directory("dir2");
        dir2.addComponent(new File("file3.txt"));

        // Crear un directorio compuesto que contiene otros directorios y archivos
        Directory root = new Directory("root");
        root.addComponent(dir1);
        root.addComponent(dir2);

        // Mostrar la estructura de archivos y directorios
        //root.display(); // Pero hasta aqui no muestra nada en la View
        textView.setText(displayStructure(root));

    }

    private String displayStructure(Component component) {
        StringBuilder sb = new StringBuilder();
        displayStructure(component, sb, 0);
        return sb.toString();
    }

    private void displayStructure(Component component, StringBuilder sb, int depth) {
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        sb.append("- ").append(component.getName()).append("\n");

        if (component instanceof Directory) {
            Directory directory = (Directory) component;
            for (Component child : directory.getComponents()) {
                displayStructure(child, sb, depth + 1);
            }
        }
    }
}