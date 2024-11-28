package com.upcino.godrexyprime;

import java.util.ArrayList;
import java.util.List;

public class GodrexyPrime {
    private List<Region> regions;

    public GodrexyPrime() {
        regions = new ArrayList<>();
        regions.add(new Region("Forest", "Increase size"));
        regions.add(new Region("Desert", "Decrease size"));
        regions.add(new Region("Lake", "Change color"));
        regions.add(new Region("Mountain", "Change shape"));
        regions.add(new Region("Cave", "Glow"));
        regions.add(new Region("Swamp", "Slow movement"));
        regions.add(new Region("Valley", "Increase speed"));
    }

    public List<Region> getRegions() {
        return regions;
    }
}
