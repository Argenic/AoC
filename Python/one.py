"""day module. Scaffold for daily puzzles"""

class One:
    """Day class"""
    def __init__(self, year, day, test):
        self.year = year
        self.day = day
        self.test = test
        if self.test :
            print("Preparing Test Data for day ", self.day, "-", self.year)
        else :
            print("Preparing Real Data for day ", self.day, "-", self.year)
