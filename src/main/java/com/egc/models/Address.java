package com.egc.models;

public class Address {
    private String numero, rua, cidade, estado, bairro;

    public Address(String numero, String rua, String cidade, String estado, String bairro) {
        setNumero(numero);
        setRua(rua);
        setCidade(cidade);
        setEstado(estado);
        setBairro(bairro);
    }

    public String getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.trim().isEmpty())
            throw new IllegalArgumentException("O número não pode estar vazio.");
        this.numero = numero.toUpperCase();
    }

    public void setRua(String rua) {
        if (rua == null || rua.trim().isEmpty())
            throw new IllegalArgumentException("A rua não pode estar vazia.");
        this.rua = rua.toUpperCase();
    }

    public void setCidade(String cidade) {
        if (cidade == null || cidade.trim().isEmpty())
            throw new IllegalArgumentException("A cidade não pode estar vazia.");
        this.cidade = cidade.toUpperCase();
    }

    public void setEstado(String estado) {
        if (estado == null || estado.trim().length() != 2) {
            throw new IllegalArgumentException("O estado deve ser uma sigla de 2 letras (ex: SP, PA).");
        }
        this.estado = estado.toUpperCase();
    }

    public void setBairro(String bairro) {
        if (bairro == null || bairro.trim().isEmpty())
            throw new IllegalArgumentException("O bairro não pode estar vazio.");
        this.bairro = bairro.toUpperCase();
    }

    public boolean isValid(){
        if (bairro == null || bairro.trim().isEmpty() ||
            estado == null || estado.trim().isEmpty() ||
            cidade == null || cidade.trim().isEmpty() ||
            rua == null    || rua.trim().isEmpty()    ||
            numero == null || numero.trim().isEmpty()) return false;
        return true;
    }
    
    @Override 
    public String toString(){
        return
        "\n > Estado: " + estado +
        "\n > Cidade: " + cidade +
        "\n > Bairro: " + bairro +
        "\n > Rua: "    + rua    +
        "\n > Número: " + numero;
    }
    
}
