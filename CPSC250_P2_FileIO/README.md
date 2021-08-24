This project continues creation of the ```MineSweeper``` game found on some computers.  See the slides from class for pictures of the game.

I have given you code that defines the MineField (solution to P1) in the ``given`` folder.
Please review this code.

In this project, you will write code to save just the mine field to a file, and load such a field from a file and create a new MineField instance with appropriate hints and all unexposed cells.
You will also create methods to save and load the an in-progress game by saving both the field (and hints) and the exposed array data.
These methods are in the ``MineFieldFileIO.java`` class.
I have also given you an empty ``MineFieldIO.java`` class.  I've given you some hints in that class, and in a MineFieldIOTest.java class; this latter JUnit test is not graded on WebCat.  You may use the MineFieldIO.java class as you wish.

When reading files, if there is an IOException, then return null.  If the data is invalid for any other reason, then throw a MineFieldException.  You need to correctly define this as a RuntimeException.

Only MineFieldException.java, MineFieldIO.java, and MineFieldFileIO.java are uploaded to WebCat.

You are not allowed to modify the given MineField.java class.


Later projects will add user interaction.


## Setup
* Fork this project into your course group.

* Clone your fork of repo to your computer
* Create Eclipse project that points to this repo
 * Be sure to add JUnit library
* Update the login.txt with your web-cat information

Write the necessary ``MineFieldFileIO.java`` class.  You may use ``MineFieldIO.java`` to support the
program as needed.



### This project is due in 14-March-2018 @ 11:59PM
 * This is 80% JUnit correctness and 20% proper style
 * NOTE: I strongly encourage you to get saveMineField and readMineField working before Spring break.


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
