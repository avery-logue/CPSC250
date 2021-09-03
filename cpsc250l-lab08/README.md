# Lab Instructions

The following instructions will get you started on the lab.

1. Click the Fork button near the middle of the page to create your copy of the lab.
   1. Go to the group where you forked this project.
   2. Click settings and then "CI/CD"
   3. If they're not already there make `WCUSER` and `WCPASS` variables and give them your WebCAT username and password respectively.
      * To do so, type in the name of the variable in the "Key" field (exactly as above) and put the value in the "Value" field.
      * Click "Add new variable".
      * If you need to add another variable, repeat this process. 
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

**Be sure to fill out the CI/CD variables with your WebCAT login info!!!**
