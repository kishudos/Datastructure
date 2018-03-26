package stack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Cell {
	private int x;
	private int y;
	private String value;
	private boolean visit;

	public Cell(int x, int y, String v) {
		this.x = x;
		this.y = y;
		this.value = v;
		this.setVisit(false);
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isEquals(Cell cell) {
		return (this.x == cell.x && this.y == cell.y && this.value == cell.value);
	}

	public String toString() {
		return "" + this.value;
	}

	public boolean isVisited() {
		return this.visit;
	}

	public void setVisit(boolean visit) {
		this.visit = visit;
	}
}

class CellStack {
	private int top, capacity;
	private Cell[] stack = null;

	public CellStack(int capacity) {
		this.capacity = capacity;
		this.stack = new Cell[capacity];
		this.top = -1;
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public boolean isFull() {
		return (this.top == this.capacity - 1);
	}

	public void push(Cell item) {
		if (!this.isFull()) {
			stack[++top] = item;
			// System.out.println("Item pushed");
		} else {
			System.out.println("Stack full.!");
		}
	}

	public Cell pop() {
		if (!isEmpty()) {
			return stack[top--];
		} else {
			// System.out.println("Stack is already empty ..!");
			return null;
		}
	}

	public Cell peek() {
		if (!isEmpty()) {
			return this.stack[top];
		} else {
			// System.out.println("Stack is already empty ..!");
			return null;
		}
	}

	public void print() {
		for (int i = 0; i <= this.top; ++i)
			System.out.println(this.stack[i] + " ");
	}
}

public class MazeClass {
	private int row;
	private int col;
	private Cell[][] maze = null;
	Cell startCell;
	Cell endCell;

	public void solve() {
		// Stack initialization
		CellStack stack = new CellStack(this.row * this.col);

		Cell currCell = this.maze[this.startCell.getX()][this.startCell.getY()];
		// System.out.println("StartCell"+startCell.getX()+startCell.getY());
		// System.out.println("EndCell"+endCell.getX()+endCell.getY());
		while (!currCell.isEquals(this.endCell)) {
			currCell.setVisit(true);
			if(!(currCell.getValue().equals("m")||currCell.getValue().equals("e")))
				currCell.setValue(".");
			printMaze();
			// System.out.println("Current
			// CellValue->"+currCell+"\nxy=>"+currCell.getX()+currCell.getY());
			if ((currCell.getX() - 1 >= 0 && currCell.getX() - 1 < this.row && currCell.getY() >= 0
					&& currCell.getY() < this.col) && (!this.maze[currCell.getX() - 1][currCell.getY()].isVisited())
					&& (!this.maze[currCell.getX() - 1][currCell.getY()].getValue().equals("1"))) {
				// System.out.println("going up");
				stack.push(this.maze[currCell.getX() - 1][currCell.getY()]);
			}
			if ((currCell.getX() >= 0 && currCell.getX() < this.row && currCell.getY() - 1 >= 0
					&& currCell.getY() - 1 < this.col) && (!this.maze[currCell.getX()][currCell.getY() - 1].isVisited())
					&& (!this.maze[currCell.getX()][currCell.getY() - 1].getValue().equals("1"))) {
				// System.out.println("going left");
				stack.push(this.maze[currCell.getX()][currCell.getY() - 1]);
			}
			if ((currCell.getX() + 1 >= 0 && currCell.getX() + 1 < this.row && currCell.getY() >= 0
					&& currCell.getY() < this.col) && (!this.maze[currCell.getX() + 1][currCell.getY()].isVisited())
					&& (!this.maze[currCell.getX() + 1][currCell.getY()].getValue().equals("1"))) {
				// System.out.println("going down");
				stack.push(this.maze[currCell.getX() + 1][currCell.getY()]);
			}
			if ((currCell.getX() >= 0 && currCell.getX() < this.row && currCell.getY() + 1 >= 0
					&& currCell.getY() + 1 < this.col) && (!this.maze[currCell.getX()][currCell.getY() + 1].isVisited())
					&& (!this.maze[currCell.getX()][currCell.getY() + 1].getValue().equals("1"))) {
				// System.out.println("going right");
				stack.push(this.maze[currCell.getX()][currCell.getY() + 1]);
			}

			if (stack.isEmpty()) {
				System.out.println("The mouse is trapped: we tried all routes and failed to find the");
				System.exit(0);
			} else {
				currCell = stack.pop();
			}
		}
		System.out.println("The mouse can escape the maze: we reached the goal cell.");
	}

	public void mazeLoader(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = "";
		boolean firstLineFlag = true;
		int r = 0, c = 0, lineNumber = -1;
		Cell[][] maze = null;
		try {
			while ((line = br.readLine()) != null) {
				if (firstLineFlag) {
					r = Integer.parseInt(line.split(" ")[0]);
					this.row = r;
					c = Integer.parseInt(line.split(" ")[1]);
					this.col = c;
					maze = new Cell[r][c];
					firstLineFlag = false;
				} else {
					String[] rowValue = line.split(" ");

					for (int i = 0; i < rowValue.length; i++) {
						maze[lineNumber][i] = new Cell(lineNumber, i, rowValue[i]);
						if (rowValue[i].equalsIgnoreCase("m")) {
							this.startCell = new Cell(lineNumber, i, rowValue[i]);
						}
						if (rowValue[i].equalsIgnoreCase("e")) {
							this.endCell = new Cell(lineNumber, i, rowValue[i]);
						}
					}
				}
				lineNumber++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.maze = maze;
	}
	public void printMaze(){
		System.out.println();
		for(int i=0;i<this.row;i++){
			for(int j=0;j<this.col;j++){
				System.out.print(maze[i][j].getValue());
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String filePath = "/home/equester/Desktop/Ravi sir/task_input.txt";
		MazeClass mazeobj = new MazeClass();
		mazeobj.mazeLoader(filePath);
		mazeobj.solve();
	}
}
