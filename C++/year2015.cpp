#include "year2015.h"
#include <iostream>

void year2015::task1() {
    // Initialize variables
    std::string input_string = fileToString("year2015_1.txt");
    int floor_level = 0;

    // Follow instructions
    for (int i = 0; i < input_string.length(); i++)
    {
        if (input_string[i] == '(') {
            floor_level++;
        }
        else if (input_string[i] == ')') {
            floor_level--;
        }
    }

    // Result
    std::cout << "Task 1.1 for 2015" << std::endl;
    std::cout << "Answer : " << floor_level << std::endl;
}

void year2015::task2() {
    // Initialize variables    
    std::string input_string = fileToString("year2015_1.txt");

    int floor_level = 0;
    int first_basement = -1;

    // Follow instructions
    for (int i = 0; i < input_string.length(); i++)
    {
        if (input_string[i] == '(') {
            floor_level++;
        }
        else if (input_string[i] == ')') {
            floor_level--;
        }

        if (floor_level < 0) {
            first_basement = i + 1;
            break;
        }
    }

    // Result
    std::cout << "Task 1.2 for 2015" << std::endl;
    std::cout << "Answer : " << first_basement << std::endl;
}

void year2015::task3() {
    // Initialize variables    
    std::string input_string = fileToString("year2015_2.txt");
    std::cout << "Task 2.1  for 2015" << std::endl;
}

void year2015::task4() {
    // Initialize variables    
    std::string input_string = fileToString("year2015_2.txt");
    std::cout << "Task 2.2 for 2015" << std::endl;
}