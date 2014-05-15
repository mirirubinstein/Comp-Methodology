package rubinstein.triangle;

public class Triangle {
	private final int height;
	private final int width;
	private final int middle;

	public Triangle(int height) {
		this.height = height;
		this.width = (height * 2) - 1;
		this.middle = height - 1;
	}

	@Override
	public String toString() {
		char sp = ' ';
		char st = '*';
		StringBuilder triangle = new StringBuilder().append("");

		if (height <= 0) {
			triangle.append("Invalid height");
		} else {
			for (int i = 0; i < height - 1; i++) {
				for (int j = 0; j < middle + i + 1; j++) {

					if (j == middle - i || j == middle + i) {
						triangle.append(st);
					} else {
						triangle.append(sp);// need do while loop
					}
				}
				triangle.append("\n");
			}
			for (int i = 0; i < width; i++) {
				triangle.append(st);
			}
			/*
			 * char[][] grid = new char[height][width];
			 * 
			 * for (int i = 0; i < height - 1; i++) { grid[i][middle - i] = '*';
			 * grid[i][middle + i] = '*'; } for (int i = 0; i < width; i++) {
			 * grid[height - 1][i] = '*'; } for (int i = 0; i < height; i++) {
			 * for (int j = 0; j < width; j++) { triangle.append(grid[i][j]); }
			 * 
			 * triangle.append("\n"); }
			 */}
		return triangle.toString();

	}

}
