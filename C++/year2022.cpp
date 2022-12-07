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
    return -1;
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
    std::istringstream input(fileToString("year2022_4.txt"));
    std::string line;
    int count = 0;
    while (getline(input, line))
    {
        std::array<int,4> points = sToPoints(line);
        if ((points[0] <= points[2] && points[1] >= points[3]) ||   
            (points[2] <= points[0] && points[3] >= points[1]))
        {
            count++;
        }
    }
    std::cout << "Task 4.1 for 2022" << std::endl;
    std::cout << "Answer : " << count << std::endl;
}

void year2022::task8()
{
    std::istringstream input(fileToString("year2022_4.txt"));
    std::string line;
    int count = 0;
    while (getline(input, line))
    {
        std::array<int, 4> points = sToPoints(line);
        if (doesLineOverlap(std::array<int, 2>{points[0], points[1]}, std::array<int, 2>{points[2], points[3]}))
        {
            count++;
        }
    }
    std::cout << "Task 4.2 for 2022" << std::endl;
    std::cout << "Answer : " << count << std::endl;
}

std::array<int, 4> year2022::sToPoints(std::string line)
{
    std::array<int, 4> points{ 0 };
    std::string inputDelimiter = ",";
    std::string valueDelimiter = "-";
    std::string token;
    // Get first int
    size_t pos = line.find(valueDelimiter);
    token = line.substr(0, pos);
    points[0] = stoi(token);
    line.erase(0, pos + inputDelimiter.length());
    // Get the second int
    pos = line.find(inputDelimiter);
    token = line.substr(0, pos);
    points[1] = stoi(token);
    line.erase(0, pos + inputDelimiter.length());
    // Get the third int
    pos = line.find(valueDelimiter);
    token = line.substr(0, pos);
    points[2] = stoi(token);
    line.erase(0, pos + inputDelimiter.length());
    // Get the last int
    points[3] = stoi(line);
    return points;
}

bool year2022::doesLineOverlap(std::array<int, 2> first, std::array<int, 2> second)
{
    for (int i = first[0]; i <= first[1]; i++) {                // Rewrite to if check after realizing i read the task wrong
        if (i >= second[0] && i <= second[1]) {
            return true;                                      
        }
    }
    return false;
}

void year2022::task9()
{
    std::istringstream input(fileToString("year2022_5.txt"));
    std::string line;
    int count = 0;
    getline(input, line);
    int size = 9; // magic number....
    std::vector<std::vector<char>> stacks(size);
    while (line.at(1) != '1')
    {
        for (int i = 0; i < size; i++)
        {
            // Over complicate the mapping.
            char c = line[i * 4 + 1];
            if (c != ' ')
            {
                stacks[i].push_back(c);       
            }  
        }
        getline(input, line);
    }
    // Reverse stacks
    for (int i = 0; i < stacks.size(); i++)
    {
        std::reverse(stacks[i].begin(), stacks[i].end());
    }
    // Remove empty line
    getline(input, line);
    // Execute rearrangement
    while (getline(input, line))
    {
        std::array<int, 3> rearrangement = sToRearrangement(line);
        for(int i = 0 ; i < rearrangement[0] + 1 ; i++)
        {
            char v = stacks[rearrangement[1]].back();
            stacks[rearrangement[1]].pop_back();
            stacks[rearrangement[2]].push_back(v);
        }
    }

    std::string answer{ "" };
    for (int i = 0; i < stacks.size(); i++)
    {
        answer.push_back(stacks[i].back());
    }
    std::cout << "Task 5.1 for 2022" << std::endl;
    std::cout << "Answer : " << answer << std::endl;
}

void year2022::task10()
{
    std::cout << "Task 5.2 for 2022" << std::endl;
    std::cout << "Answer : " << std::endl;
}

std::array<int, 3> year2022::sToRearrangement(std::string line)
{
    std::string delimiter = " ";
    size_t pos = 0;
    std::string token;
    std::vector<std::string> words;
    while ((pos = line.find(delimiter)) != std::string::npos)
    {
        token = line.substr(0, pos);
        words.push_back(token);
        line.erase(0, pos + delimiter.length());
    }
    words.push_back(line);
    return { stoi(words[1]) - 1, stoi(words[3]) - 1, stoi(words[5]) - 1 };
}

void year2022::task11()
{
    std::cout << "Task 6.1 for 2022" << std::endl;
    std::cout << "Answer : " << std::endl;
}

void year2022::task12()
{
    std::cout << "Task 6.2 for 2022" << std::endl;
    std::cout << "Answer : " << std::endl;
}