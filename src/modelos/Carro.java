/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelos;

/**
 *se crea todo el crud para una comapñia que vende vehiculos en todos los municipios de colombia.
 * @author Manuela Gomez
 */
public class Carro {

    private String matricula;
    private String modelo;
    private String marca;
    private double precio;
    private String color;
    private String seguro;
    private String ciudad;

    public Carro(String matricula, String modelo, String marca, double precio, String color, String seguro, String ciudad) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.color = color;
        this.seguro = seguro;
        this.ciudad = ciudad;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
          
}
