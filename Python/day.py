import time
class Day:
    """Day class"""
    def __init__(self, year, day, test):
        self.year = year
        self.day = day
        self.test = test
        self.fileName = str(self.year) + "//" + str(self.day)
        if self.test :
            print("Preparing Test Data for day", self.day, "-", self.year)
            self.fileName += "//test.txt"
        else :
            print("Preparing Real Data for day", self.day, "-", self.year)
            self.fileName += "//real.txt"
    def fileToList(self, cast='string'):
        list = [];
        with open(self.fileName, "r") as file:
            for line in file:
                value = line.rstrip()
                if cast == 'int':
                    value = int(value)
                list.append(value)
        return list
    def getLine(self):
        with open(self.fileName, "r") as file:
            return file.readline()
    def run(self):
        start = time.process_time()
        self.partOne()
        self.partTwo()
        print(time.process_time() - start, "seconds execution time")
