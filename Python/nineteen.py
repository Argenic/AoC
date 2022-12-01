import day
import math
class One(day.Day):
    """Solution for 2019 day 1"""
    def __init__(self, test=True):
        day.Day.__init__(self, 2019, 1, test)
        self.list = self.fileToList()
    def calculateFuel(self, weight):
        return math.floor(weight / 3) - 2
    def partOne(self):
        fuel = 0
        for line in self.list:
            fuel += self.calculateFuel(int(line))
        print("Part 1: Fuel required", fuel)
    def partTwo(self):
        fuel = 0
        for line in self.list:
            fuelForStage = self.calculateFuel(int(line))
            while fuelForStage > 0:
                fuel += fuelForStage
                fuelForStage = self.calculateFuel(fuelForStage)
                
        print("Part 2: Fuel required", fuel)
class Two(day.Day):
    """Solution for 2019 day 2"""
    def __init__(self, test=False):
        day.Day.__init__(self, 2019, 2, test)
        self.line = self.getLine()
    def partOne(self):
        values = [int(x) for x in self.line.split(',')]
        values[1] = 12
        values[2] = 2
        for x in range(0, len(values), 4):
            optcode = values[x]
            if optcode == 99:
                break
            if optcode != 1 and optcode != 2:
                print("Failure")
                break
            left = values[values[x+1]]
            right = values[values[x+2]]
            destination = values[x+3]
            if optcode == 1:
                value = left + right
            elif optcode == 2:
                value = left * right
            values[destination] = value
        print("Part 1: Postion zero", values[0])
    def partTwo(self):
        print("Part 2:")
