# Dependency Breaking Katas #

Exercises to practice breaking dependencies in legacy
code to create tests for it.


We have some legacy code. We need to make changes. 
To make changes we need to create/add tests.
We might have to change some code to enable testing.
We need to introduce so-called Seams (see [Michael
Feathers' Working Effectively with Legacy
Code](https://www.goodreads.com/book/show/44919.Working_Effectively_with_Legacy_Code)).

Changing code without test is risky, so we want to
* Only change as little code as possible. 
* Rely on automated Refactoring tools as much as possible. 
* You must not change the public API of the class.

## Assignments for Techniques ##
Assignments for specific techniques (in recommended order)

* Subclass And Override Method
* Extract And Override Call
* Replace Global Reference With Getter
* Parameterise Constructor

You will find a detailed description in each directory in the file *Assignment.md*.

### License ###

[New BSD License](http://opensource.org/licenses/bsd-license.php), see `license.txt` in repository.
