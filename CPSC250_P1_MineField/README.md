This project begins creation of the ```MineSweeper``` game found on some computers.  See the slides from class for pictures of the game.

In this project we will write code that defines creation of the MineField, and handles updating the game.  Later projects will add user interaction.




## Setup
* Fork this project into your course group.

* Clone your fork of repo to your computer
* Create Eclipse project that points to this repo
 * Be sure to add JUnit library
* Update the login.txt with your web-cat information

The project defines the ```MineField.java``` class with certain instance variables already defined, and the default constructor defined.  Please read the JavaDoc carefully for descriptions.

You will be writing several methods.


## ```MineField(int rows, int cols, int mines)```

This constructor takes three arguments: ```rows, columns```, and ```mines```.

You will create the appropriate arrays with ```rows``` x ```columns``` size, and place the ```mines``` number of mines randomly inside the array.

if ```mines > rows*columns``` then set the entire mineField array values to -1 to indicate full of mines.

There can only be one mine per location, so if you randomly choose the same location twice, then you need to re-sample a location.   As this chance of collision increases as the number of mines go up, and may significantly increase runtime, I suggest that if ```mines > 0.5*rows*columns```, you take the opposite approach and initialize all cells as having a mine and randomly choose the appropriate number of cells to set to clear.

You need to calculate the hint values for cells that are not mines.  
Definition of this constructor may be easier if you make use of the methods below.

## ```void MineField.setMineField(int[][] array)```

This method creates a deep copy of the method argument array for the ```mineField```, and then calculates the appropriate hint values, and initializes the ```exposed``` array.

## ```void MineField.setHint()```

This method calculates the *hint* values for the ```mineField``` instance array.

We will put the hint values in the ```mineField``` instance array.  If a cell has a mine (-1 value), then leave it -1.  If a cell does not have a mine (0 initially), then calculate the number of mines in it's eight neighbors, and write that value.  

See the JUnit tests for expected values.

## ```boolean exposeCell(int row, int column)```

This method handles selection of a given cell.

If the cell contains a mine (-1), then set the exposed array cell to ```true``` and return ```false```.

If the cell contains a hint (>0), then expose and return ```true```.
If cell does not contain a mine or hint (==0), then you must expose all neighboring cells that contain neither a mine nor hint (0 value).  
You should continue to expose all (unexposed) neighbors that have zero value.  

The easiest way to do this is if a neighboring cell contains 0 and has not been previously exposed, then re-call ```exposeCell``` for that neighbor's coordinates.  This is an example of a *recursive* method call, a method that calls itself; we will cover recursive methods in detail later in the course.  

## ```String toString()```

Write the toString method for this class.  The output will show data in a rectangle of characters the size of the array.
We will use 3 characters to represent each column.
Use a ``` * ``` (space-asterisk-space) string for each cell if the corresponding cell is not exposed (e.g. ```exposed[row][col] == false```).
If exposed is true, and the value is not 0, then show the numeric value of the ```mineField``` cell using 3 characters  (hint: see String.format).  If the value is 0, then use 3 space characters.


### Directions

* Do not change the instance variable names or given method signatures
* You may create additional helper methods if you wants
* I've started you with good JavaDoc, but you must add proper JavaDoc for any methods you add.

* Submit to GitLab frequently; at least one commit per method you write.

### This project is due in 2 phases
* Phase 1 (50 pts)- Due 30-January at 11:59PM
 * You get credit for the fraction of JUnit tests passed up to 50 points
* Phase 2 (100 pts) Due 6-February at 11:59PM
 * This is 80% JUnit correctness and 20% proper style
* NOTE: I strongly encourage you to do most of this before the first Midterm for practice.

## Honor Policy

 Unlike weekly assignments, this project has strict Honor Guidelines

* You may work in collaboration with one partner (or individually at your discretion).
* If you want to work with a partner, choose one yourself
 * Email me and cc your partner prior to Thursday 25-January at 5PM
* You must both submit to your personal GitLab repos.  Either:
 * Work together in one shared repo, and then do a final fork to individual repos
 * Work collaboratively, but making individual code commits to separate repos
* You may freely discuss and share code with your partner
* You may NOT view anyone else's code other than your partner!

* Any discussions with others, must follow the *Empty Hands Rule*
 * You may discuss concepts in abstract, including on paper or white board
 * You must destroy notes/erase prior to coding
 * You must document all discussions with other people
  * This includes both giving and receiving help
* Code will be checked for plagarism and unauthorized sharing.

## Notes:

* Read the JavaDoc for specific directions for each methods
* Look at the unit tests carefully when debugging for details.
* You do NOT need to write JUnit tests for this.
* Web-cat is picky on style and logic.  You can have correct code that will still lose points in web-cat.  Look at the reports
 * Web-cat wants extra braces around single line statements.  Just do it.
