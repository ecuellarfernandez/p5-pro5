package org.p5;

import org.p5.arboles.Arbol;
import org.p5.archivos.LectorArchivo;
import org.p5.gui.ArbolFrame;
import org.p5.obj.Vendedor;

import java.io.File;
import java.io.IOException;

public class Piramide {
    private Arbol<Vendedor> arbol;
    public void cargarArbol() {
        File archivo = new File("C:\\Users\\erick\\IdeaProjects\\p5\\arbol.txt");
        if (!archivo.exists() || !archivo.canRead()) {
            System.out.println("No existe o no podemos leer");
            System.exit(0);
        }
        LectorArchivo lector = new LectorArchivo(archivo);
        Arbol<Vendedor> arbol = null;

        try {
            arbol = lector.leer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.arbol = arbol;
        System.out.println(arbol);
    }

    public void cargarVentas() {

    }
    public void mostrarArbol() {
        new ArbolFrame(arbol);
    }

    public void iniciar() {
        cargarArbol();
        cargarVentas();
        mostrarArbol();
    }
}
