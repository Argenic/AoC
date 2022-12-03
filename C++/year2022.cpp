#include "year2022.h"

void year2022::task1() 
{
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
    std::cout << "Task 1.1 for 2022" << std::endl;
    std::cout << "Answer : " << highest_count << std::endl;
}

void year2022::task2() 
{
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
    int total = calories[0] + calories[1] + calories[2];
    std::cout << "Task 1.2 for 2022" << std::endl;
    std::cout << "Answer : " << total << std::endl;
}

void year2022::task3() 
{
    std::istringstream input(fileToString("year2022_2.txt"));
    std::string one_line;
    int score = 0;
    while (getline(input, one_line)) 
    {
        int left = rpsToI(one_line[0]);
        int right = rpsToI(one_line[2]);
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
        score++;                                                    // Recover modulo offset
    }
    std::cout << "Task 2.1 for 2022" << std::endl;
    std::cout << "Answer : " << score << std::endl;
}

void year2022::task4() {
    std::istringstream input(fileToString("year2022_2.txt"));
    std::string one_line;
    int score = 0;
    while (getline(input, one_line))
    {
        int left = rpsToI(one_line[0]);
        int right = rpsToI(one_line[2]);
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
        }
        score++;                                                    // Recover modulo offset
    }
    std::cout << "Task 2.2 for 2022" << std::endl;
    std::cout << "Answer : " << score << std::endl;
}

int year2022::rpsToI(char c)
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

void year2022::task5()
{
    std::istringstream input(fileToString("year2022_3.txt"));
    std::string one_line;
    int count = 0;
    while (getline(input, one_line))
    {
        int index;
        int alphabet[52] = { 0 };
        for (int i = 0; i < one_line.length() ; i++) 
        {
            index = one_line[i] - 'a';                          
            if (index < 0) 
            {                                                       // If lesser then 0 it must be uppercase
                index = one_line[i] - 'A' + 26;                 
            }
            if (one_line.length() / 2 > i)                          // Halfway point
            {
                alphabet[index]++;                                  // Mark character
            }
            else 
            {
                if (alphabet[index] > 0) 
                {
                    count += index + 1;
                    break;
                }
            }
        }
    }
    std::cout << "Task 3.1 for 2022" << std::endl;
    std::cout << "Answer : " << count << std::endl;
}

void year2022::task6()
{
    std::istringstream input(fileToString("year2022_3.txt"));
    std::string line_one, line_two, line_three;
    int count = 0;
    while (getline(input, line_one))
    {
        getline(input, line_two);
        getline(input, line_three);
        std::array<int, 52>bag_one = sToAlphabeth(line_one);
        std::array<int, 52> bag_two = sToAlphabeth(line_two);
        std::array<int, 52> bag_three = sToAlphabeth(line_three);
        for (int i = 0; i < 52; i++) {
            if (
                bag_one[i] > 0 &&
                bag_two[i] > 0 &&
                bag_three[i] > 0 
            ) {
                count += i + 1;
            }
        }
    }
    std::cout << "Task 3.2 for 2022" << std::endl;
    std::cout << "Answer : " << count << std::endl;
}

std::array<int, 52> year2022::sToAlphabeth(std::string line)
{
    std::array<int, 52> alphabet{ };
    for (int i = 0; i < 52; i++) {
        alphabet[i] = 0;
    }
    int index;
    for (int i = 0; i < line.length(); i++)
    {
        index = line[i] - 'a';
        if (index < 0)
        {                                                           // If lesser then 0 it must be uppercase
            index = line[i] - 'A' + 26;
        }
        alphabet[index] += 1;                                       // Mark character
    }
    return alphabet;
}

void year2022::task7()
{
    std::cout << "Task 3.1 for 2022" << std::endl;
    std::cout << "Answer : " << std::endl;
}

void year2022::task8()
{
    std::cout << "Task 3.2 for 2022" << std::endl;
    std::cout << "Answer : " << std::endl;
}