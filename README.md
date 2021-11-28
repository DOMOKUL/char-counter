## Task 5 - Collection Framework
Write an application that takes a string and returns the number of unique characters in the string.
It is expected that a string with the same character sequence may be passed several times to the method.
Since the counting operation can be time-consuming, the method should cache the results, so that when the method is given a string previously encountered,
it will simply retrieve the stored result. Use collections and maps where appropriate.

E.g.  
hello world!  
"h" - 1  
"e" - 1  
"l" - 3  
"o" - 2  
"w" - 1  
"r" - 1  
"d" - 1  
"!" - 1  
" " - 1

Application should terminate when user enters "/exit" without quotes. 

Example of results:

![FirstCase](https://git.foxminded.com.ua/nikita.strokach/char-counter/uploads/015a55f2ce8c22b32522cff6de07e6c2/firstCase.PNG)

![SecondCase](https://git.foxminded.com.ua/nikita.strokach/char-counter/uploads/73cc6272b2d2d91ff5e13acdc0ce6874/SecondCase.PNG)

![ThirdCase](https://git.foxminded.com.ua/nikita.strokach/char-counter/uploads/4da38eade088da5aaabb0d691abf639f/ThirdCase.PNG)