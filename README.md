# TextJusifier

Written Java 1.12

installation:
Intellij:  Welcome to Intellij -> Get from VLC 
enter given GIT URL and press clone
Open src/TextJusifier.java and right click the main function and select "modify run configurations"
Enter desired CLI arguments for example: "This is text " 30
hit apply and ok
right click main function and select "TextJusifier.main()" 
Program should run.

Alternatively with command line you can clone the repo and run javac TextJusifier.java
Run java TextJusifier "This is some text." 50

How it works:
The general approach is as follows: count the length of string without whitespace
The difference between this length and the desired length is the deficit
next the program counts how many words exist in the text
This tells us how many spaces we can use to pad the string to fill the deficit
Spaces = # of words - 1 
The Program calculated the length of the spaces by dividing the deficit by the # of spaces.
We need to account for the remainder r, so the program adds an extra length to r spaces. 
The program reconstructs the string with those calculated spaces.

JUnits are located in src/TextJusifierTest.java using JUnit5.7.0
