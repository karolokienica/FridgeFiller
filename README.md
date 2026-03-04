# FridgeFiller

FridgeFiller checks whether a set of 3D packages can physically fit inside a fridge.

## How it works

- **Fridge** — represents a 3D grid of a given width, height, and depth, with all cells initially empty (0).
- **Package** — represents a 3D box of a given width, height, and depth, with all cells filled (1).
- **Filler** — takes a `Fridge` and a list of `Package` objects and tries to place each package into the fridge grid one by one. It scans for the first available position where a package fits without overlapping already occupied cells. `canFill()` returns `true` if all packages were successfully placed, `false` otherwise.