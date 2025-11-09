/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entidades;

/**
 *
 * @author Sandra
 */
public enum Hobby {
    
    MUSICA, LIBROS, PELICULAS, FOTOGRAFIA, TECNOLOGIA, DEPORTES, 
    VIAJES, COCINA, BAILE;
    
    public static Hobby fromString(String str) {
    for (Hobby h : Hobby.values()) {
        if (h.name().equalsIgnoreCase(str)) {
            return h;
        }
        }
        throw new IllegalArgumentException("Hobby desconocido: " + str);
    }
    
}
