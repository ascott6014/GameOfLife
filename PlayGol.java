/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gameoflife;

/**
 * READ ME
 * This game has two modes
 * Indicate the mode you want to play by commenting out the other.
 * Feel free to change the row span, col span, density, and number of generations (in that order)
 * As a bonus, try to count how many repeating patterns you see.
 */

public class PlayGol {
    public static void main(String[] args){
        Gol game1 = new Gol(20,20,20,20);
       // game1.play();           // Only checks 4 neighbors
        game1.playMode2();      // Checks all 8 neighbors
        
        
        
    }
}
