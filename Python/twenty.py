import day
import math
class One(day.Day):
    """Solution for 2020 day 1"""
    def __init__(self, test=True):
        day.Day.__init__(self, 2020, 1, test)
        self.lines = self.fileToList(cast='int')
        self.lines.sort()
    def partOne(self):
        win = 0
        for x in range(len(self.lines)):
            left = self.lines[x]
            for y in range(x + 1, len(self.lines)):
                right = self.lines[y]
                if left + right == 2020:
                    win = left * right
                    break
                elif left + right > 2020:
                    break
            if win > 0:
                break
        print("Part 1: Multiplication", win)
    def partTwo(self):
        win = 0
        for x in range(len(self.lines)):
            left = self.lines[x]
            for y in range(x + 1, len(self.lines)):
                middle = self.lines[y]
                for z in range(y + 1, len(self.lines)):
                    right = self.lines[z]
                    if left + middle + right == 2020:
                        win = left * middle * right
                        break
                    elif left + middle + right > 2020:
                        break
                if win > 0:
                    break
            if win > 0:
                break
        print("Part 2: Multiplication", win)
class Two(day.Day):
    def __init__(self, test=False):
        day.Day.__init__(self, 2020, 2, test)
        self.lines = self.fileToList()
    def partOne(self):
        count = 0
        for line in self.lines:
            parts = line.split(': ')
            instruction = parts[0].split(' ')
            sizes = instruction[0].split('-')
            if parts[1][int(sizes[0])] == instruction[1] or parts[1][int(sizes[1])] == instruction[1]:
                print(line)
                count += 1
            
            #if parts[1].count(instruction[1]) >= int(sizes[0]) and parts[1].count(instruction[1]) <= int(sizes[1]):
            #    print(line)
            #    count += 1
        print("Part 1: Valid", count)
    def partTwo(self):
        print("Part 2:")
