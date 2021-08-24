# In-class Midterm Programming

You may only consult with:
* Dr. Conner to clarify intent of questions if needed
* https://docs.oracle.com/javase/8/docs/api/index.html - Java API documentation
* https://gitlab.pcs.cnu.edu   - your personal CS250 repo's only
* https://web-cat.cs.vt.edu    - your webcat submissions
* Your single page of handwritten notes (for exams)

No other help is allowed.

Create your project in Eclipse and don't forget to add JUnit libraries.

Change your WebCat `login.txt` right now!

Make sure you verify that all submissions make it to webcat.  This is required for full credit.

Your code must compile in WebCat.
Be warned Eclipse will sometimes "force compile" code to run what it can, but WebCat requires all code to compile before it will grade.  Make sure you check your WebCat submissions.
Comment out any code that you cannot get to work if it is causing compilation issues on WebCat.
(Leave it in place in case I look for partial credit.)

## CS150Stuff (25 pts - Required)

This includes some basic operations with classes.
* Correct the instance variable declaration as specified in JavaDoc
 * Do NOT change the name or type of the variable
* No argument constructor that initializes according to JavaDoc
* 1 arg constructor that initializes according to parameter
* Accesor method (getter) called getString 
* Mutator method (setter) call setString


## Array2D (25 pts - Required)

* Initialize the 2D array to JavaDoc specified size in default constructor
* Create a deep copy of array in the 1-arg constructor
* setValue sets every element in a previously initialized array to given value 
* getCell returns value at given indices; returnt the minimum possible integer value if invalid array (e.g. null) or invalid index
* setDiagonal - set elements on diagonal to given value, leave other values alone


## Choose 1 of the 2 following programs

If you attempt both I will give you the maximum score between the two.

#### CrazyAnimalNames

Some animals are known by their common "muggle" name, but others have more interesting names:
* "Raccoon (Trash Panda)"
* "Snake (Danger Noodle)"
* "Crocodile (Murder Log)"
* "Zebra (Tiger Horse)"

I have given you an Animal class, and several class shells for several classes: CrazyNameAnimal, Mammal, Reptile, Raccoon, and Snake.

You do NOT need a Crocodile or Zebra for this project. 

* The given Animal class only inherits from the standard Java Object.
 * All Animals have a private String ``species`` instance variable. (provided)
 * There is a 1-arg constructor that sets this species name.
 * There is a ``toString`` method that prints the species.
 * The constructor and toString methods are the only way to access the species 
 * You cannot change this class (WebCat uses my version)
 
* Interesting animals have a CrazyNameAnimal as well as the Animal species 
 * Store the crazy name in a single String instance variable 
 * For full credit, you should only have one instance variable in this class
  * If you are stuck figuring out how to set the species, then add a second variable to let you move forward.
 * Use a two-arg constructor to set the animals regular species name and crazy name 
 * CrazyNameAnimal is an Animal 
 * CrazyNameAnimals use a ``toString`` that has their species name and their (crazyName)
  * e.g. "Raccoon (Trash Panda)"

* Both ``Mammal`` and ``Reptile`` classes are ("is a") CrazyNameAnimal 
*   Both classes use a two-argument constructor that sets the species name and crazy name .
* The ``toString`` prints the classification after the crazy name
 * e.g. "Raccoon (Trash Panda) Mammal"
 * Pay attention to the spaces between words.

* The Raccoon and Snake classes define only a no-argument constructor, but return the following strings for their corresponding definitions:
* "Raccoon (Trash Panda) Mammal"
* "Snake (Danger Noodle) Reptile"

If we had created the other classes, the would say:
* "Crocodile (Murder Log) Reptile"
* "Zebra (Tiger Horse) Mammal"
You do NOT need to create Crocodile and Zebra!


### Football (25 points)

I've given you code for Player, and shell code for Offense, Defense, QuarterBack, RunningBack, LineBacker, and Safety.
* All players use a 2-argument constructor for name and number
* You cannot change the Player class
* Offense and Defense are both Players ("is a" Player) 
* A QuarterBack is an Offensive player ("is a" Offense )
* A RunningBack is an Offensive player ("is a" Offense )
* A LineBacker is a Defensive player ( " is a Defense) 
* The test cases will attempt to create a variety of each specialty class.
* write a ``getOffense`` method for the GetOffense class that returns only offensive players from a mixed ArrayList of Players




## Push to GitLab and check submission on WebCat
