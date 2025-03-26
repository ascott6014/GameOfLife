/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gameoflife;

/**
 *
 * @author iamad
 */
import java.util.Random;
public class Gol {
    private int row;
    private int col;
    private int density;
    private int generations;
    private int totalDeaths = 0;
    private int totalRevives = 0;
    private boolean[][] grid;
    private boolean[][] nextGrid;
    
    /**
     * Constructor
     * @param r row span
     * @param c col span
     * @param d density
     * @param g generations
     */
    public Gol(int r, int c, int d, int g){
        row = r;
        col = c;
        density = d;
        generations = g;
    }


    /**
     * Generates original Grid
     */
    public void generateGrid(){
        Random rand = new Random();
        grid = new boolean[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (rand.nextInt(100) <= density){
                    grid[i][j] = true;
                    
                }
                else{
                    grid[i][j] = false;
                }
            }
        }
        
    }
    /**
     * copys nextGrid onto Grid
     */
    public void evolveGrid(){
        for (int i = 0; i < row; i ++){
            System.arraycopy(nextGrid[i], 0, grid[i], 0, col);
        }
    }
    
    /**
     * Generates NextGrid (only checks 4 neighbors)
     */
    public void generateNextGrid(){
        
        nextGrid = new boolean[row][col];
        for (int i = 0; i < row; i ++){
            
            for (int j = 0; j < col; j ++){
                
                int neighbors = 0;
                
                if (j != 0){
                    if (grid[i][j - 1] == true){
                        neighbors ++;
                    }
                }
                if (j != (col - 1)){
                    if (grid[i][j + 1] == true){
                        neighbors ++;
                    }
                }
                if (i != 0){
                    if(grid[i - 1][j] == true){
                        neighbors ++;
                    }
                }
                if (i != (row - 1)){
                    if (grid[i + 1][j] == true){
                        neighbors ++;
                    }
                }
                // Any live cell with fewer that two live neighbors dies, as if by underpopulation
                if ((grid[i][j] == true) && (neighbors < 2)){
                    nextGrid[i][j] = false;
                    totalDeaths ++;
                }
                // Any live cell with two or three live neighbors lives on to the next generation
                else if ((grid[i][j] == true) && (neighbors < 4)){
                    nextGrid[i][j] = true;
                }
                // Any live cell with more than three live neighbors dies, as if by overpopulation
                else if ((grid[i][j] == true) && neighbors > 3){
                    nextGrid[i][j] = false;
                    totalDeaths ++;
                }
                // Any dead cell with exactly three live neighbors gets revived, as if by reproduction
                else if ((grid[i][j] == false) && (neighbors == 3)){
                    nextGrid[i][j] = true;
                    totalRevives ++;
                }
                
            }
        }
    }
    /**
     * Prints out grid
     */
    public void showGrid(){
        int alive = 0;
        int dead = 0;
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                if (grid[i][j] == true){
                    System.out.print("#");
                    alive ++;
                }
                else {
                    System.out.print("-");
                    dead ++;
                    
                }
                System.out.print("  ");
            }
            System.out.println("");
        }
        System.out.println("Alive: " + alive + "\t\tDead: " + dead);
        for (int i = 0; i <= (32); i++){
            System.out.print("=");
        }
        System.out.println("");
    }
    
    /**
     * Generates 8nGrid {Checks all 8 neighbors)
     */
    public void generate8nGrid(){  // checks all 8 neighbors
        nextGrid = new boolean[row][col];
        for (int i = 0; i < row; i ++){
            
            for (int j = 0; j < col; j ++){
                
                int neighbors = 0;
                
                if (j != 0){        // checks west
                    if (grid[i][j - 1] == true){
                        neighbors ++;
                    }
                }
                if (j != (col - 1)){        // checks east
                    if (grid[i][j + 1] == true){
                        neighbors ++;
                    }
                }
                if (i != 0){                // checks north
                    if(grid[i - 1][j] == true){
                        neighbors ++;
                    }
                }
                if (i != (row - 1)){        // checks south
                    if (grid[i + 1][j] == true){
                        neighbors ++;
                    }
                }
                if ((j != 0) && (i != 0)){  // checks northwest
                    if (grid[i - 1][j - 1] == true){
                        neighbors ++;
                    }
                }
                if ((j != (col - 1)) && (i != (row - 1))){ // checks southeast
                    if (grid[i + 1][j + 1] == true){
                        neighbors ++;
                    }
                }
                if ((j != 0) && (i != (row - 1))){      // checks southwest
                    if (grid[i + 1][j - 1] == true){
                        neighbors ++;
                    }
                }
                if ((j != col - 1) && (i != 0)){ // checks northeast
                    if (grid[i - 1][j + 1] == true){
                        neighbors ++;
                    }
                }
                
                
                // Any live cell with fewer that two live neighbors dies, as if by underpopulation
                if ((grid[i][j] == true) && (neighbors < 2)){
                    nextGrid[i][j] = false;
                    totalDeaths ++;
                }
                // Any live cell with two or three live neighbors lives on to the next generation
                else if ((grid[i][j] == true) && (neighbors < 4)){
                    nextGrid[i][j] = true;
                }
                // Any live cell with more than three live neighbors dies, as if by overpopulation
                else if ((grid[i][j] == true) && neighbors > 3){
                    nextGrid[i][j] = false;
                    totalDeaths ++;
                }
                // Any dead cell with exactly three live neighbors gets revived, as if by reproduction
                else if ((grid[i][j] == false) && (neighbors == 3)){
                    nextGrid[i][j] = true;
                    totalRevives ++;
                }
                
            }
        }
    }
    
    /**
     * Prints out nextGrid
     */
    public void showNextGrid(){
        int alive = 0;
        int dead = 0;
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                if (nextGrid[i][j] == true){
                    System.out.print("#");
                    alive ++;
                }
                else {
                    System.out.print("-");
                    dead ++;
                    
                }
                System.out.print("  ");
            }
            System.out.println("");
        }
        System.out.println("Alive: " + alive + "\t\tDead: " + dead);
        for (int i = 0; i <= (32); i++){
            System.out.print("=");
        }
        System.out.println("");
    }
    /** 
     * Plays game (4 check mode)
     */
    public void play(){
        generateGrid();
        System.out.println("Original Grid");
        showGrid();
        for (int i = 0; i < generations; i ++){
            System.out.println("Generation: " + (i + 1));
            generateNextGrid();
            evolveGrid();
            showNextGrid();
        }
        System.out.println("Total Deaths: " + totalDeaths + "\t\tTotal Revives: " + totalRevives);
    }
    
    /**
     * Plays game (8 check mode)
     */
    public void playMode2(){
        generateGrid();
        System.out.println("Original Grid");
        showGrid();
        for (int i = 0; i < generations; i ++){
            System.out.println("Generation: " + (i + 1));
            generate8nGrid();
            evolveGrid();
            showNextGrid();
        }
        System.out.println("Total Deaths: " + totalDeaths + "\t\tTotal Revives: " + totalRevives);
    }
        
      /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * @return the density
     */
    public int getDensity() {
        return density;
    }

    /**
     * @param density the density to set
     */
    public void setDensity(int density) {
        this.density = density;
    }

    /**
     * @return the generations
     */
    public int getGenerations() {
        return generations;
    }

    /**
     * @param generations the generations to set
     */
    public void setGenerations(int generations) {
        this.generations = generations;
    } 

} 
    
    

    

    