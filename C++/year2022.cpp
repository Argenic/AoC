#include "year2022.h"

#include <algorithm>    // std::sort

void year2022::task1() {
    // Initialize variables
    std::istringstream input(fileToString("year2022_1.txt"));
    std::string one_line;
    int current_count{ 0 };
    int highest_count{ 0 };
    while (getline(input, one_line)) {
        if (empty(one_line)) {
            if (current_count > highest_count) {
                highest_count = current_count;
            }
            current_count = 0;
        }
        else {
            current_count += stoi(one_line);
        }
    }

    // Result
    std::cout << "Task 1.1 for 2022" << std::endl;
    std::cout << "Answer : " << highest_count << std::endl;
}

void year2022::task2() {
    // Initialize variables    
    std::istringstream input(fileToString("year2022_1.txt"));
    std::string one_line;
    std::vector<int> calories;
    int current_count{ 0 };
    while (getline(input, one_line)) {
        if (empty(one_line)) {
            calories.push_back(current_count);
            current_count = 0;
        }
        else {
            current_count += stoi(one_line);
        }
    }

    std::sort(calories.begin(), calories.end(), std::greater<int>());

    // Amount
    int total = calories[0] + calories[1] + calories[2];

    // Result
    std::cout << "Task 1.2 for 2022" << std::endl;
    std::cout << "Answer : " << total << std::endl;
}

void year2022::task3() {
    // Initialize variables 
       
    // Result
    std::cout << "Task 2.1 for 2022" << std::endl;
    std::cout << "Answer : " << std::endl;
}

void year2022::task4() {
    // Initialize variables    

    // Result
    std::cout << "Task 2.2 for 2022" << std::endl;
    std::cout << "Answer : " << std::endl;
}