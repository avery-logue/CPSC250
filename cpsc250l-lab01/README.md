# Lab Instructions

The following instructions will get you started on the lab.

1. Click the Fork button near the middle of the page to create your copy of the lab.
2. Go back to your fork of the lab assignment.
3. Copy the URL in the box near the middle of the page (next to the fork button).
4. Open a terminal or Git Bash.
5. Use `cd` to enter the directory in which you store your repositories.
6. Run `git clone <copied url here>` to clone your repository onto the machine.
7. Open Eclipse, and create a new Java project using the following options.
 * Give your lab an appropriate name.
 * **Uncheck** the 'Use default location' box.
 * In the location box, navigate to the location of your repository.
 * Click next and select the 'Libraries' tab.
 * Click 'Add library', select 'JUnit', click 'Next', ensure that JUnit 4 is selected, press 'Finish'.
 * Click 'Finish' once again.
8. Open the `pdf` file for the lab and read through the classes and methods that it wants.
9. Create each class that the manual requires and create a method shell for each method that needs to be implemented.
10. Track your changes with `git add .`
11. Commit your changes with `git commit -m "Started lab N"`
12. Push your changes using `git push`
13. Follow the instructions in the lab manual.

While working on the lab, you should periodically use `git add`, `git commit`, and `git push` to save your progress.
Additionally, take note of any commit quota that the lab provides.

**Be sure to fill out the login.txt with your WebCAT login info!!!**

To do so, run `notepad login.txt` in Git Bash, or `open -e login.txt` in a Mac Terminal.

# CPSC250L Lab 1: Eclipse, jUnit, and Debugging
## Spring 2018

Introduction
============

The CPSC250L course is similar to the CPSC150L course in that you will
read the labs and complete the exercises. The main difference is that
you have more room for creativity and you will have to do more research
and thinking on your own.

In CPSC150, you used BlueJ as an Integrated Development Environment
(IDE). This semester, you will use Eclipse, which is a professional IDE.
This means that Eclipse has more powerful features, although their sheer
number can be intimidating sometimes. Like BlueJ, Eclipse is free and
runs on Macintosh, UNIX, Linux and Windows. It can be downloaded from
[www.eclipse.org](www.eclipse.org). If you want to familiarize yourself
with Eclipse, please read .

Furthermore, in CPSC250L, you will use Git, a professional version
control tool, to manage and submit your lab exercises. We recommend that
you read the Git tutorial at <https://gitlab.pcs.cnu.edu/cpsc-labs/bash-and-git-wiki/wikis/home> to get
started with Git. Your grade for each exercise is dependent on the
number of jUnit tests that your solution passes, as well as other
criteria your instructor may impose (such as code style guidelines and
Javadoc). The tests are run against the latest code submitted to the
master branch of your personal fork of the lab project; no other
branches or commits are evaluated.

If you have any questions or issues please talk to your instructor.

Exercises
=========

Before beginning, please fork and clone the repository at
<https://gitlab.pcs.cnu.edu/cpsc250-students/cpsc250l-lab01>. This
repository includes the lab manual, all jUnit tests, and a Java file
which you will need to debug. After cloning, do not close Git Bash or
your terminal! You will need it throughout the lab.

Exercise 1: “Hello World” with Eclipse and Git
----------------------------------

This first exercise will introduce you to Eclipse.

1.  Open Eclipse.

2.  When it asks you for the workspace, accept the default choice. (Make
    sure it is **not** your Git directory!)

3.  Close the Welcome Screen.

4.  Click “File -> New -> Java Project”. In the
    window that pops up, uncheck the “use default location” checkbox and
    point it towards your cloned Git repository. More explicit
    instructions are in the Git tutorial found at
    <hhttps://gitlab.pcs.cnu.edu/cpsc-labs/bash-and-git-wiki/wikis/home>.

5.  Create a class named `Hello World`, by right-clicking your new
    project and then clicking “New -> Class”.

6.  Create a `main` method that prints `Hello World` to the console.

7.  Right click `HelloWorldTest.java` under the `src` directory in the
    package explorer (the leftmost pane) and click “Run as ->
    jUnit Test”.

8.  If all of the jUnit tests passed (as indicated by a solid green bar
    in the jUnit panel), then continue on with the lab. Otherwise, if
    something failed or the tests will not run then ensure `jUnit 4`
    appears in the package explorer under your lab 1 project. If you
    continue to encounter problems, talk to your instructor.

**Exercise 1 Complete!**

Run:
```
git add .
git commit -m "Completed exercise 1"
git push origin master
```

Program Arguments and the `main` Method
---------------------------------------

This exercise will introduce command line arguments in Eclipse.

1.  Create a new class called `Arguments`.

2.  In this class, create a program that prints each command-line
    argument. You must use the `main` method for this. See an example in
    .

    **Hint**: `args` is just an array of `String`s, and we can traverse
    it with a `for` loop.

    ![An example execution of
    `Arguments.java`\[lab1-exec\]](pictures/arguments-example.png)

3.  In the package explorer, right-click `Arguments.java` and click on
    “Run as -> Run configurations”. In the window that pops
    up, click on arguments and then type some words in the “Program
    Arguments” text box. See for an example.

    ![Example arguments added to
    Arguments.java\[add-args\]](pictures/arguments-howto.png)

4.  Once you have played with this for a little bit, run
    `ArgumentsTest.java`. If all tests pass, move on to the next
    exercise.

**Exercise 2 Complete!**

Run:
```
git add .
git commit -m "Completed exercise 2"
git push origin master
```

Debugging
---------

This exercise will center on debugging code.

1.  In Eclipse, open the `Debugging` class. In this file, you have been
    given code that is meant to find the maximum value in an array of
    integers.

2.  Using your preferred style of debugging (`println` statements or
    Eclipse’s debugger), fix the code so that it returns the maximum
    value in the array. You may assume that the array is not null and
    nonempty.

3.  Run the test file `DebuggingTest.java`. If all tests pass, make sure
    you have everything pushed to Gitlab.


**Exercise 3 Complete!**

Run:
```
git add .
git commit -m "Completed exercise 3"
git push origin master
```

Common Mistakes
===============

Some common mistakes for this lab are as follows.

1.  jUnit is not in the build path. If jUnit is not in the build path,
    jUnit tests cannot be run. To correct this, right click your project
    and click “Build path -> Libraries”. In the resulting
    window, select jUnit and click next. In the next screen, select
    jUnit 4 and click finish.

2.  `HelloWorld` fails tests. Ensure that the class name is exactly as
    the lab specifies. Additionally, ensure that `main` is `public`,
    `static`, returns `void`, and takes a single `String[]` as an
    argument. Lastly, make sure it prints `Hello World` exactly.

3.  Out of bounds errors. The `Arguments` and `Debugging` programs both
    use arrays, make sure that you do not go out of bounds. The maximum
    index in any array is `array.length - 1` since Java indexes arrays
    from 0.

Well-styled code is crucial to avoiding errors. Eclipse can autoformat
your code to Java standards. Press `ctrl+shift+f` (Windows) or
`cmd+shift+f` (Mac) to automatically reformat of your code. Do this as
often as required to keep your code well formatted.

Tutorial
========

Eclipse
-------

If you wish to further explore Eclipse, check out the “Explore Windows”,
“Explore Menus”, and “Explore Views” tutorials at
<http://www.tutorialspoint.com/eclipse/eclipse_explore_windows.htm>.

If you wish to learn how to use Eclipse’s debugger see
<http://www.tutorialspoint.com/eclipse/eclipse_debugging_program.htm>.
