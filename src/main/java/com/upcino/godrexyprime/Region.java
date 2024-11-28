package com.upcino.godrexyprime;

public class Region {
    private String name;
    private String effect;

    public Region(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}