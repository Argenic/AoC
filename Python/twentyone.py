import day
import math
class One(day.Day):
    """Solution for 2021 day 1"""
    def __init__(self, test=True):
        day.Day.__init__(self, 2021, 1, test)
        self.lines = self.fileToList()
    def partOne(self):
        previousValue = int(self.lines[0])
        increases = 0
        for x in range(1, len(self.lines)):
            if int(self.lines[x]) > previousValue:
                increases += 1
            previousValue = int(self.lines[x])
        print("Part 1: Increases", increases)
    def partTwo(self):
        previousSum = int(self.lines[0]) + int(self.lines[1]) + int(self.lines[2])
        increases = 0
        for x in range(3, len(self.lines)):
            sum = int(self.lines[x]) + int(self.lines[x-1]) + int(self.lines[x-2])
            if sum > previousSum:
                increases += 1
            previousSum = sum
                
        print("Part 2: Increases", increases)
class Two(day.Day):
    """Solution for 2021 day 2"""
    def __init__(self, test=False):
        day.Day.__init__(self, 2021, 2, test)
        self.lines = self.fileToList()
    def partOne(self):
        horizontal = 0
        depth = 0
        for line in self.lines:
            instruction = line.split(' ')
            if instruction[0] == "forward":
                horizontal += int(instruction[1])
            elif instruction[0] == "up":
                depth -= int(instruction[1])
            elif instruction[0] == "down":
                depth += int(instruction[1])
        print("Part 1: Depth * Horizontal =", depth * horizontal)
    def partTwo(self):
        horizontal = 0
        depth = 0
        aim = 0
        for line in self.lines:
            instruction = line.split(' ')
            if instruction[0] == "forward":
                horizontal += int(instruction[1])
                depth += aim * int(instruction[1])
            elif instruction[0] == "up":
                aim -= int(instruction[1])
            elif instruction[0] == "down":
                aim += int(instruction[1])
        print("Part 2: Depth * Horizontal =", depth * horizontal)
class Three(day.Day):
    """Solution for 2021 day 3"""
    def __init__(self, test=False):
        day.Day.__init__(self, 2021, 3, test)
        self.lines = self.fileToList()
    def partOne(self):
        print("Part 1:")
    def partTwo(self):
        print("Part 2:")
