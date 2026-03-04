package org.example;

public class Package {
    private final int[][][] pkg;

    public Package(int width, int height, int depth) {
        this.pkg = new int[width][height][depth];
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                for (int z = 0; z < depth; z++)
                    this.pkg[x][y][z] = 1;
    }

    public int getWidth()  { return pkg.length; }
    public int getHeight() { return pkg[0].length; }
    public int getDepth()  { return pkg[0][0].length; }
}
