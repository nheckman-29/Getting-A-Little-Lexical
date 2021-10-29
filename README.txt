Conway's Game of Life 1-D

Created by Nathan Heckman

Inputs: Array Size (Integer), Generations (Integer)
Output: Array of Specified Size and Generation

- Once running, program will prompt user for the arrray size
- Input a number and press space 
- Program will now ask for number of generations desired 
- Input a number and press enter or return 
- Program will print the generation requested based on the neighbor logic presented in code

Compared to the 2-D Conway's Game of Life, this version runs just as fast for small array sizes and desired generations but begins to lag with larger numbers. I believe this is largely due to the fact that the entire array needs to be checked and updated on each pass, which essentially will run at O(n^2), which is an undesirable runtime. Nevertheless, this iteration does work and can represent the idea of Conway's Game of Life in a similar way to the 2-D version. The edge cells are designed to have a neighbor on the opposite end of the array and this implementation runs cyclically.