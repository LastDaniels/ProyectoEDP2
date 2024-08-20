/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

/**
 *
 * @author Dario Anchundia Cobo
 */
public class Fichero {

    public static ArrayList<String> leerPreguntas(String rutaArchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(rutaArchivo), "UTF-8"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
        }
        return lineas;
    }

   public static HashMap<String, ArrayList<String>> leerRespuestas(String archivoRespuestas) {
        HashMap<String, ArrayList<String>> respuestas = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoRespuestas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                String animal = partes[0]; // La primera palabra es el nombre del animal
                ArrayList<String> respuestasAnimal = new ArrayList<>();

                for (int i = 1; i < partes.length; i++) {
                    respuestasAnimal.add(partes[i]);
                }

                // Añadir el animal y sus respuestas al HashMap
                respuestas.put(animal, respuestasAnimal);
            }
        } catch (Exception e) {
        }

        return respuestas;
    }
   public static HashMap<String, ArrayList<String>> leerRespuestasIndice(String archivoRespuestas,int numPreguntas) {
        HashMap<String, ArrayList<String>> respuestas = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoRespuestas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                String animal = partes[0]; // La primera palabra es el nombre del animal
                ArrayList<String> respuestasAnimal = new ArrayList<>();

                for (int i = 1; i < numPreguntas; i++) {
                    respuestasAnimal.add(partes[i]);
                }

                // Añadir el animal y sus respuestas al HashMap
                respuestas.put(animal, respuestasAnimal);
            }
        } catch (Exception e) {
        }

        return respuestas;
    }

}
