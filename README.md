# datamunging


Groovy based solution for [Code Kata 4](http://codekata.com/kata/kata04-data-munging/)

### Part One: Weather Data

In weather.dat you’ll find daily weather data for Morristown, NJ for June 2002. Download this text file, then write a program to output the day number (column one) with the smallest temperature spread (the maximum temperature is the second column, the minimum the third column).

[Solution](https://github.com/sudarshan89/datamunging/blob/master/src/main/groovy/Weather.groovy) 

### Part Two: Soccer League Table

The file football.dat contains the results from the English Premier League for 2001/2. The columns labeled ‘F’ and ‘A’ contain the total number of goals scored for and against each team in that season (so Arsenal scored 79 goals against opponents, and had 36 goals scored against them). Write a program to print the name of the team with the smallest difference in ‘for’ and ‘against’ goals.

[Solution](https://github.com/sudarshan89/datamunging/blob/master/src/main/groovy/Football.groovy)

### Part Three: DRY Fusion

Take the two programs written previously and factor out as much common code as possible, leaving you with two smaller programs and some kind of shared functionality.

[Solution](https://github.com/sudarshan89/datamunging/blob/master/src/main/groovy/RefactoredDataMunging.groovy)

Kata Questions

To what extent did the design decisions you made when writing the original programs make it easier or harder to factor out common code?
Was the way you wrote the second program influenced by writing the first?
Is factoring out as much common code as possible always a good thing? Did the readability of the programs suffer because of this requirement? How about the maintainability?

