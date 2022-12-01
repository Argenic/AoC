#include "AdventOfCode.h"

using namespace std;

void AdventOfCode::run()
{
	// Greet the user
	greeting();

	// Setup basic loop
	bool gameloop = true;
	string command;


	while (gameloop)
	{
		// Prompt
		cout << "command :> ";
		cin >> command;

		// Input processing clean up!
		if (command == "exit") {
			// Terminate program
			gameloop = false;
		}
		else if (command == "h") {
			// Prompt help
			help();
		}
		else if (command == "2015") {
			year2015 year;
			year.task1();
			year.task2();
			year.task3();
			year.task4();
		}
		else if (command == "2016") {
			cout << "2016, To be continued!" << endl;
			//year2016 year;
			//year.task1();
			//year.task2();
		}
		else if (command == "2017") {
			cout << "2017, To be continued!" << endl;
		}
		else if (command == "2018") {
			cout << "2018, To be continued!" << endl;
		}
		else if (command == "2019") {
			cout << "2019, To be continued!" << endl;
		}
		else if (command == "2020") {
			cout << "2020, To be continued!" << endl;
		}
		else if (command == "2021") {
			cout << "2021, To be continued!" << endl;
		}
		else if (command == "2022") {
			year2022 year;
			year.task1();
			year.task2();
			//year.task3();
			//year.task4();
			cout << "More coming!!!" << endl;
		}
		else {
			cout << "!!! SYNTAX ERROR !!!" << endl;
		}
	}
}

void AdventOfCode::help()
{
	cout << "Commands:" << endl;
	cout << "	* 2015-2022 =	Submenu for yearly puzzles." << endl;
	cout << "	* exit      =	Exit program" << endl;
}

void AdventOfCode::greeting()
{
	// Retrieve user credentials
	//login();

	// Introduce
	//greet();
}

void AdventOfCode::login()
{
	cout << "Welcome to my advent of code solutions, whats your username?" << endl;
	cout << "Username : ";
	cin >> username;
}

void AdventOfCode::greet()
{
	cout << "Welcome " << username << "!" << endl;
	cout << "Check out my solutions of the Advent of Code between 2015 and 2022!" << endl;
	cout << "	* h for help" << endl;
}
