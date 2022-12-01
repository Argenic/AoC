import day
class One(day.Day):
    """Solution for 2018 day 1"""
    def __init__(self, test=True):
        day.Day.__init__(self, 2018, 1, test)
        self.list = self.fileToList()
    def partOne(self):
        frequency = 0
        for line in self.list:
            if line[0] == '+':
                frequency += int(line[1:])
            else:
                frequency -= int(line[1:])
        print("Part 1: Frequency", frequency)
    def partTwo(self):
        # if ... in ... is to slow for this. List reaches > 100k
        #print("Part 2: !!!NEED TO BE IMPROVED!!!")
        #return
        frequency = 0
        frequencies = []
        flag = True
        while flag:
            for line in self.list:
                if line[0] == '+':
                    frequency += int(line[1:])
                else:
                    frequency -= int(line[1:])
                if frequency in frequencies:
                    flag = False
                    break
                else:
                    frequencies.append(frequency)
        print("Part 2: Frequency ", frequency)
class Two(day.Day):
    """Solution for 2018 day 2"""
    def __init__(self, test=False):
        day.Day.__init__(self, 2018, 2, test)
        self.lines = self.fileToList()
    def partOne(self):
        twos = 0
        threes = 0
        for line in self.lines:
            two = False
            three = False
            for char in line:
                if line.count(char) == 2:
                    two = True
                elif line.count(char) == 3:
                    three = True
            if two:
                twos += 1
            if three:
                threes += 1
        print("Part 1: Checksum", twos * threes)
    def partTwo(self):
        flag = False
        lineOne = ""
        lineTwo = ""
        for x in range(len(self.lines)):
            lineOne = self.lines[x]
            for y in range(x + 1, len(self.lines)):
                differences = 0
                lineTwo = self.lines[y]
                for z in range(len(lineOne)):
                    if lineOne[z] != lineTwo[z]:
                        differences += 1
                        if differences > 1:
                            break
                if(differences == 1):
                    flag = True
                    break
            if flag:
                break
        answer = "";
        for x in range(len(lineOne)):
            if lineOne[x] == lineTwo[x]:
                answer += lineOne[x]
        print("Part 2: Password", answer)
