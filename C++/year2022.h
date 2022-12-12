#pragma once

#include "year.h"


class year2022 : year
{
public:
    // Day 1
    void task1();
    void task2();

    // Day 2
    void task3();
    void task4(); 
    int rpsToI(char c);

    // Day 3
    void task5();
    void task6();
    std::array<int, 52> sToAlphabeth(std::string line);
    
    // Day 4
    void task7();
    void task8();
    std::array<int ,4> sToPoints(std::string line);
    bool doesLineOverlap(std::array<int, 2> low, std::array<int, 2> high);

    // Day 5
    void task9();
    void task10();
    std::array<int, 3> sToRearrangement(std::string line);

    // Day 6
    void task11();
    void task12();
    int lineToMarker(std::string line, int offset);

    // Day 7
    void task13();
    void task14(); 
    struct Directory {
        Directory* parent{ };
        std::vector<Directory*> children{ };
        int size{ 0 };
        std::string name;
        Directory(std::string n);
        Directory(std::string n, Directory* p);
        void addSize(int file_size);
        void createChild(std::string n);        
        Directory* getChildByName(std::string n);
        void loopChildren(Directory* d, int* count);
        void loopChildrenForSingle(Directory* d, int* smallest, int minimum);
    };
    std::vector<std::string> sToCLI(std::string line);
    Directory buildFileStructure();

    // Day 8
    void task15();
    void task16();
    std::vector<std::vector<int>> getTreeHeight();

    // Day 9
    void task17();
    void task18();
};