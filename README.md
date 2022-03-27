# TextJusifier

Coded in Java 1.12

How it works:
The general approach is as follows: count the length of string without whitespace
The difference between this length and the desired length is the deficit
next the program counts how many words exist in the text
This tells us how many spaces we can use to ped the string to fill the deficit
Spaces = # of words - 1 
The Program calculated the length of the spaces by dividing the deficit by the # of spaces.
We need to account for the remainder r, so the program adds an extra length to r spaces. 
The program reconstructs the string with those calculated spaces.

installation:
Intellj:  Welcome to intellj -> Get from VLC 
enter given GIT URL 
