#include "year2022.h"

void year2022::task1() 
{
    // Initialize variables
    std::istringstream input(fileToString("year2022_1.txt"));
    std::string one_line;
    int current_count{ 0 };
    int highest_count{ 0 };
    while (getline(input, one_line)) 
    {
        if (empty(one_line)) 
        {
            if (current_count > highest_count) 
            {
                highest_count = current_count;
            }
            current_count = 0;
        }
        else 
        {
            current_count += stoi(one_line);
        }
    }

    // Result
    std::cout << "Task 1.1 for 2022" << std::endl;
    std::cout << "Answer : " << highest_count << std::endl;
}

void year2022::task2() 
{
    // Initialize variables    
    std::istringstream input(fileToString("year2022_1.txt"));
    std::string one_line;
    std::vector<int> calories;
    int current_count{ 0 };
    while (getline(input, one_line)) 
    {
        if (empty(one_line)) {
            calories.push_back(current_count);
            current_count = 0;
        }
        else 
        {
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

/**
* A, X, 1 = Rock
* B, Y, 2 = Paper
* C, Z, 3 = Scissors
* Win     = 6
* Draw    = 3
* Loss    = 0
*/
void year2022::task3() 
{
    // Initialize variables 
    std::istringstream input(fileToString("year2022_2.txt"));
    std::string one_line;

    int score = 0;
    while (getline(input, one_line)) 
    {
        int left = charToInt(one_line[0]);
        int right = charToInt(one_line[2]);
        if (left == right) 
        {
            score += right + 3;
        }
        else if ((left + 1) % 3 == right)
        {
            score += right + 6;
        }
        else {
            score += right;
        }
        // Recover modulo offset
        score++;
    }

    // Result
    std::cout << "Task 2.1 for 2022" << std::endl;
    std::cout << "Answer : " << score << std::endl;
}

/**
* Loss    = X
* Draw    = Y
* Win     = Z
*/
void year2022::task4() {
    // Initialize variables 
    std::istringstream input(fileToString("year2022_2.txt"));
    std::string one_line;

    int score = 0;
    while (getline(input, one_line))
    {
        int left = charToInt(one_line[0]);
        int right = charToInt(one_line[2]);
        switch (right)
        {
            case 0:
            {
                score += (left + 2) % 3;
                break;
            }
            case 1:
            {
                score += left + 3;
                break;
            }
            case 2:
            {
                score += (left + 1) % 3 + 6;
                break;
            }
            std::cout << score << std::endl;
        }
        // Recover modulo offset
        score++;
    }

    // Result
    std::cout << "Task 2.2 for 2022" << std::endl;
    std::cout << "Answer : " << score << std::endl;
}

int year2022::charToInt(char c)
{
    switch (c)
    {
    case 'A': case 'X':
    {
        return 0;
    }
    case 'B': case 'Y':
    {
        return 1;
    }
    case 'C': case 'Z':
    {
        return 2;
    }
    }

}