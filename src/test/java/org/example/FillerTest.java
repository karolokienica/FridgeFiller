package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FillerTest {

    // 1. Empty package list always fits
    @Test
    void noPackagesAlwaysFits() {
        Fridge fridge = new Fridge(3, 3, 3);
        Filler filler = new Filler(fridge, List.of());
        assertTrue(filler.canFill());
    }

    // 2. Single package exactly matching fridge size
    @Test
    void singlePackageExactFridgeSize() {
        Fridge fridge = new Fridge(2, 2, 2);
        Filler filler = new Filler(fridge, List.of(new Package(2, 2, 2)));
        assertTrue(filler.canFill());
    }

    // 3. Single package smaller than fridge
    @Test
    void singlePackageSmallerThanFridge() {
        Fridge fridge = new Fridge(4, 4, 4);
        Filler filler = new Filler(fridge, List.of(new Package(2, 2, 2)));
        assertTrue(filler.canFill());
    }

    // 4. Single package larger than fridge (one dimension)
    @Test
    void singlePackageTooWide() {
        Fridge fridge = new Fridge(2, 2, 2);
        Filler filler = new Filler(fridge, List.of(new Package(3, 1, 1)));
        assertFalse(filler.canFill());
    }

    // 5. Single package larger than fridge (all dimensions)
    @Test
    void singlePackageLargerThanFridge() {
        Fridge fridge = new Fridge(2, 2, 2);
        Filler filler = new Filler(fridge, List.of(new Package(3, 3, 3)));
        assertFalse(filler.canFill());
    }

    // 6. Two packages that together exactly fill the fridge
    @Test
    void twoPackagesExactlyFillFridge() {
        Fridge fridge = new Fridge(4, 1, 1);
        Filler filler = new Filler(fridge, List.of(
                new Package(2, 1, 1),
                new Package(2, 1, 1)
        ));
        assertTrue(filler.canFill());
    }

    // 7. Two packages whose combined volume exceeds the fridge
    @Test
    void twoPackagesTooLargeForFridge() {
        Fridge fridge = new Fridge(2, 2, 2);
        Filler filler = new Filler(fridge, List.of(
                new Package(2, 2, 2),
                new Package(1, 1, 1)
        ));
        assertFalse(filler.canFill());
    }

    // 8. Multiple small packages that all fit
    @Test
    void multipleSmallPackagesFit() {
        Fridge fridge = new Fridge(4, 1, 1);
        Filler filler = new Filler(fridge, List.of(
                new Package(1, 1, 1),
                new Package(1, 1, 1),
                new Package(1, 1, 1),
                new Package(1, 1, 1)
        ));
        assertTrue(filler.canFill());
    }

    // 9. One too many small packages
    @Test
    void tooManySmallPackages() {
        Fridge fridge = new Fridge(4, 1, 1);
        Filler filler = new Filler(fridge, List.of(
                new Package(1, 1, 1),
                new Package(1, 1, 1),
                new Package(1, 1, 1),
                new Package(1, 1, 1),
                new Package(1, 1, 1)
        ));
        assertFalse(filler.canFill());
    }

    // 10. Package with size 1x1x1 fits in any non-empty fridge
    @Test
    void unitPackageAlwaysFits() {
        Fridge fridge = new Fridge(1, 1, 1);
        Filler filler = new Filler(fridge, List.of(new Package(1, 1, 1)));
        assertTrue(filler.canFill());
    }

    // 11. Package exactly too tall
    @Test
    void singlePackageTooTall() {
        Fridge fridge = new Fridge(3, 2, 3);
        Filler filler = new Filler(fridge, List.of(new Package(1, 3, 1)));
        assertFalse(filler.canFill());
    }

    // 12. Packages fit in a non-cubic fridge
    @Test
    void packagesInNonCubicFridge() {
        Fridge fridge = new Fridge(6, 2, 1);
        Filler filler = new Filler(fridge, List.of(
                new Package(3, 2, 1),
                new Package(3, 2, 1)
        ));
        assertTrue(filler.canFill());
    }
}