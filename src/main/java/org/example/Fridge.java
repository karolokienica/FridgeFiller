package org.example;

public class Fridge {
    private final int[][][] fridge;

    public Fridge(int width, int height, int depth) {
        this.fridge = new int[width][height][depth];
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                for (int z = 0; z < depth; z++)
                    this.fridge[x][y][z] = 0;
    }

    public int getWidth()  { return fridge.length; }
    public int getHeight() { return fridge[0].length; }
    public int getDepth()  { return fridge[0][0].length; }

    public boolean isOccupied(int x, int y, int z) {
        return fridge[x][y][z] != 0;
    }

    public void occupy(int x, int y, int z) {
        fridge[x][y][z] = 1;
    }
}
