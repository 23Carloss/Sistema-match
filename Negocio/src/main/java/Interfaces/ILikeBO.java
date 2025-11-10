/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.LikeDTO;

/**
 *
 * @author HP
 */
public interface ILikeBO {
    public void agregarLike(LikeDTO like);
    public void eliminarLike(long id);
    
    
}
