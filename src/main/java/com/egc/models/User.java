package com.egc.models;

public abstract class User {

    private String name, email, password, accessLevel;

    public User() {}

    public User(String name, String email, String password, String access){
        setName(name);
        setEmail(email);
        setPassword(password);
        accessLevel = access;
    }

    public User(String email, String password, String access){
        this("Undefined", email, password, access);        
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@") || email.contains(" "))
            throw new IllegalArgumentException("O E-mail do usuário inválido.");

        this.email = email;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 2)
            throw new IllegalArgumentException("O nome do usuário precisa ter pelo menos 2 caracteres.");

        this.name = name;
    }

    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty() || password.length() < 6)
            throw new IllegalArgumentException("A senha do usuário precisa ter pelo menos 6 caracteres.");

        this.password = password;
    }
    
}
