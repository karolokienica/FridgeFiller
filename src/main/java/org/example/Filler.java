package org.example;

import java.util.List;

public class Filler {
    private final Fridge fridge;
    private final List<Package> packages;

    public Filler(Fridge fridge, List<Package> packages) {
        this.fridge = fridge;
        this.packages = packages;
    }

    public boolean canFill() {
        for (Package pkg : packages) {
            if (!place(pkg)) return false;
        }
        return true;
    }

    private boolean place(Package pkg) {
        int fw = fridge.getWidth(), fh = fridge.getHeight(), fd = fridge.getDepth();
        int pw = pkg.getWidth(),    ph = pkg.getHeight(),    pd = pkg.getDepth();
        for (int x = 0; x <= fw - pw; x++)
            for (int y = 0; y <= fh - ph; y++)
                for (int z = 0; z <= fd - pd; z++)
                    if (fits(pkg, x, y, z)) {
                        mark(pkg, x, y, z);
                        return true;
                    }
        return false;
    }

    private boolean fits(Package pkg, int ox, int oy, int oz) {
        for (int x = 0; x < pkg.getWidth(); x++)
            for (int y = 0; y < pkg.getHeight(); y++)
                for (int z = 0; z < pkg.getDepth(); z++)
                    if (fridge.isOccupied(ox + x, oy + y, oz + z)) return false;
        return true;
    }

    private void mark(Package pkg, int ox, int oy, int oz) {
        for (int x = 0; x < pkg.getWidth(); x++)
            for (int y = 0; y < pkg.getHeight(); y++)
                for (int z = 0; z < pkg.getDepth(); z++)
                    fridge.occupy(ox + x, oy + y, oz + z);
    }
}