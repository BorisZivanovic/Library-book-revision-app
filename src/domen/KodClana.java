/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Jaca
 */
public class KodClana {
    
    private String kodClana;

    public KodClana() {
    }

    public KodClana(String kodClana) {
        this.kodClana = kodClana;
    }

    public String getModelniKod() {
        return kodClana;
    }

    public void setModelniKod(String kodClana) {
        this.kodClana = kodClana;
    }

    @Override
    public String toString() {
        return this.kodClana;
    }
    
}
