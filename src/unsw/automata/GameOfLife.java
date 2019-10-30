/**
 *
 */
package unsw.automata;

import java.util.ArrayList;
import java.util.List;

/**
 * Conway's Game of Life on a 10x10 grid.
 *
 * @author Robert Clifton-Everest
 *
 */
public class GameOfLife {

	private static final int dim = 10;

	boolean[][] cells;

	public GameOfLife() {
		this.cells = new boolean[dim][dim];

		// At the start all cells are dead
		for (int i = 0; i < dim; i++) {
			for (int j = 0; i < dim; i++) {
				this.cells[i][j] = false;
			}
		}
	}

	public void ensureAlive(int x, int y) {
		// Set the cell at (x,y) as alive
		this.cells[x][y] = true;
	}

	public void ensureDead(int x, int y) {
		// Set the cell at (x,y) as dead
		this.cells[x][y] = false;
	}

	public boolean isAlive(int x, int y) {
		return this.cells[x][y];
	}

	public void tick() {
		boolean[][] newState = new boolean[dim][dim];

		for (int x = 0; x < dim; x++) {
			for (int y = 0; y < dim; y++) {
				int n_neighbours = (int) getNeighbours(x, y).stream().filter(c -> this.isAlive(c.x, c.y)).count();
				if (isAlive(x, y)) {
					switch (n_neighbours) {
					case 2:
					case 3:
						newState[x][y] = true;
						break;
					default:
						newState[x][y] = false;

					}
				} else {
					newState[x][y] = n_neighbours == 3;
				}
			}
		}

		this.cells = newState;
	}

	private List<Coordinate> getNeighbours(int x, int y) {
		ArrayList<Coordinate> neighbours = new ArrayList<Coordinate>();
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				neighbours.add(new Coordinate(mod(x + i, dim), mod(y + j, 10)));
			}
		}
		return neighbours;
	}

	private static int mod(int n, int mod) {
		return (n + mod) % mod;
	}
}

class Coordinate {

	public final int x;
	public final int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
