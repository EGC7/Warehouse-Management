package com.egc.models;

public abstract class Product{ // TODO: Adicionar forma de destacar verificando quantidade em estoque. [RN04]

    private String name, description;
    private double price, weight;
    private int amountStorage, minStorage, splitTime, id;

    
    public abstract double calculateHandlingFee(int amount); //? Vai ter que pegar esse valor de param do pedido do cliente.
    
    public Product(){}

    public Product(String name, String description, double price,double weight,
                int amountStorage, int minStorage, int splitTime) {
        
        setName(name);
        setDescription(description);
        setPrice(price);
        setWeight(weight);
        setAmountStorage(amountStorage);
        setMinStorage(minStorage);
        setSplitTime(splitTime);

    }

    public Product(String name, double price,double weight,
                int amountStorage, int minStorage, int splitTime) {
        this(name, "", price, weight, amountStorage, minStorage, splitTime);
    }
    
    

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public int getAmountStorage() {
        return amountStorage;
    }

    public int getMinStorage() {
        return minStorage;
    }

    public int getSplitTime() {
        return splitTime;
    }

    public int getId() {
        return id;
    }

   

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() < 3 )
            throw new IllegalArgumentException("O nome do produto não pode ser menor que 3.");
        this.name = name;
    }

    public void setDescription(String description) {
        // if (description == null || description.trim().isEmpty() )
            // throw new IllegalArgumentException("O nome deve ter pelo menos 5 Caracteres.");
        this.description = description;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("O preço do produto não pode ser menor que 0.");
        this.price = price;
    }

    public void setWeight(double weight) {
        if (weight < 0)
            throw new IllegalArgumentException("O peso do produto não pode ser menor que 0.");
        this.weight = weight;
    }

    public void setAmountStorage(int amountStorage) {
        if (amountStorage < 0)
            throw new IllegalArgumentException("A quantidade armazenada do produto não pode ser menor que 0.");
        this.amountStorage = amountStorage;
    }

    public void setMinStorage(int minStorage) {
        if (minStorage < 0)
            throw new IllegalArgumentException("A quantidade mínima armazenada do produto não pode ser menor que 0.");
        this.minStorage = minStorage;
    }

    public void setSplitTime(int splitTime) {
        if (splitTime < 0)
            throw new IllegalArgumentException("O tempo de separação do produto não pode ser menor que 0.");
        this.splitTime = splitTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void replenish(int amount){
        if (amount < 0)
            throw new IllegalArgumentException("A quantidade de reabastecimento do produto não pode ser menor que 0.");

        //TODO Adicionar uma forma de verificar se ainda tem espaço antes de realmente reabastecer aquela quantidade (amount). [Rn03]

        amountStorage += amount;
    }

    @Override
    public String toString(){
        return "---------- " + name + " ----------\n" + "> Id: " + id + "\n" +
        (description.length() > 0 ? ("> Descrição: " + description + "\n") : "") +
        "> Preço" + price + " | Peso: " + weight +
        "\n> Quantidade em Estoque: " + amountStorage + " | Mínimo no Estoque: " + minStorage + 
        "\n> Tempo de Separação: " + splitTime;        
    }

    public void showDetails(){
        System.out.println(toString());
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (id != other.id)
            return false;
        return true;
    }
}