#include "year.h"

std::string year::fileToString(std::string fileLocation)
{
	std::ifstream t(fileLocation);
	std::string str((std::istreambuf_iterator<char>(t)),
		std::istreambuf_iterator<char>());
	return str;
}