/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package hp.persistencia;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author HP
 */
public class Persistencia {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema_MatchPU");
        
    }
}
