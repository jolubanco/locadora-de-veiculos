package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.GregorianCalendar;

//voltar a ser abstrata a classe
public class Veiculo {

    private String marca;
    private String placa; //tratar entrada, receber maiusculo e formatado
    private String modelo;
    private int numeroPortas;
    private double valorVeiculo;
    private String cor;
    private int ano;
    private static int totalVeiculos; //é necesario? ou posso usar da classe services

    //[*] criando o objeto veículo e aumentando o numero de veículos a cada inicialização do objeto
    public Veiculo (String marca, String placa, double valorVeiculo){
        totalVeiculos++;
        this.marca = marca;
        this.placa = placa;
        this.valorVeiculo = valorVeiculo;
    }

    public void setValorVeiculo(double valorVeiculo) {
        this.valorVeiculo = valorVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public static int getTotalVeiculos() {
        return Veiculo.totalVeiculos;
    }

    public double getValorVeiculo() { return valorVeiculo; }

    @Override
    public String toString() {
        return "Veiculo: " +
                "marca = '" + marca + '\'' +
                ", placa = '" + placa + '\'' +
                ", modelo = '" + modelo + '\'' +
                ", numeroPortas = " + numeroPortas +
                ", valorVeiculo = " + valorVeiculo +
                ", cor = '" + cor + '\'' +
                ", ano = " + ano;
    }
}
