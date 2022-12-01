#pragma once

#include "year2015.h"
#include "year2016.h"
#include "year2022.h"
#include <iostream>


class AdventOfCode
{
    public:
        // Variables
        std::string username;
        // Functions
        void run();
    private:
        // Functions
        void help();
        void greeting();
        void login();
        void greet();
};