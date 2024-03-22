package com.example.garageApp.model;

public class Car {


    enum Color {
        RED,
        BLUE,
        GREEN,
        YELLOW,
        BLACK,
        WHITE,
        ORANGE,
        PINK,
        PURPLE,
        BROWN,
        GRAY,
        SILVER,
        MAGENTA,
        CYAN,
        TAN
    }


    private long id;
    private String model;
    private String brand;
    private int year;
    private Color color;

    // ajout d un constructeur vide qui permet la creation d une nouvelle voiture
    // et ajout de la fonction SUPER dans le contructeur classique ci dessous
    //
    public Car() {
    }
    public Car(long id, String model, String brand, int year, String color) {
        super(); // pour aider le constructeur vide a creer une nouvealle voiture

        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.color = Color.valueOf(color);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
