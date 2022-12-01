import day
class One(day.Day):
    """Solution for 2015 day 1"""
    def __init__(self, test=False):
        day.Day.__init__(self, 2015, 1, test)
        self.line = self.getLine()
    def partOne(self):
        floor = 0
        for char in self.line:
            if char == '(':
                floor += 1
            elif char == ')':
                floor -= 1
        print("Part 1: Final floor", str(floor))
    def partTwo(self):
        position = 1
        floor = 0
        for char in self.line:
            if char == '(':
                floor += 1
            elif char == ')':
                floor -= 1
            if floor < 0:
                break
            position += 1
        print("Part 2: Basement position", str(position))
class Two(day.Day):
    """Solution for 2015 day 2"""
    def __init__(self, test=False):
        day.Day.__init__(self, 2015, 2, test)
        self.lines = self.fileToList()
        self.ribbon = 0
        self.paper = 0
        for line in self.lines:
            sizes = [int(x) for x in line.split('x')]
            sizes.sort()
            self.paper += 2 * sizes[0] * sizes[1]
            self.paper += 2 * sizes[0] * sizes[2]
            self.paper += 2 * sizes[1] * sizes[2]
            self.paper += sizes[0] * sizes[1]
            self.ribbon += sizes[0] * 2 + sizes[1] * 2
            self.ribbon += sizes[0] * sizes[1] * sizes[2]
    def partOne(self):
        print("Part 1: Paper required", self.paper)
    def partTwo(self):
        print("Part 2: Ribbon required", self. ribbon)
class Three(day.Day):
    """Solution for 2015 day 3"""
    def __init__(self, test=False):
        day.Day.__init__(self, 2015, 3, test)
        self.line = self.getLine()
    def partOne(self):
        x = 0
        y = 0
        houses = ['0x0']
        for char in self.line:
            if char == ">":
                x += 1
            elif char == "<":
                x -= 1
            elif char == "^":
                y += 1
            elif char == "v":
                y -= 1
            houses.append(str(x) + "x" + str(y))
        print("Part 1: Unique houses", len(set(houses)))
    def partTwo(self):
        x = 0
        y = 0
        x_r = 0
        y_r = 0
        robot = False
        houses = ['0x0']
        for char in self.line:
            if char == ">":
                if robot:
                    x_r += 1
                else:
                    x += 1
            elif char == "<":
                if robot:
                    x_r -= 1
                else:
                    x -= 1
            elif char == "^":
                if robot:
                    y_r += 1
                else:
                    y += 1
            elif char == "v":
                if robot:
                    y_r -= 1
                else:
                    y -= 1
            if robot:
                houses.append(str(x_r) + "x" + str(y_r))
            else:
                houses.append(str(x) + "x" + str(y))
            robot = not robot
        print("Part 2: Unique houses", len(set(houses)))
