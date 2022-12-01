import day
class LazyError(Exception):
     pass
class One(day.Day):
    """Solution for 2016 day 1"""
    def __init__(self, test=True):
        day.Day.__init__(self, 2016, 1, test)
        line = self.getLine()
        self.instructions = line.split(", ")
    def reset(self):
        self.direction = 0
        self.horizontal = 0
        self.vertical = 0
        self.locations = []
    def turn(self, change):
        if change == "R":
            self.direction += 90
        elif change == "L":
            self.direction -= 90
        return self.direction % 360
    def walk(self, angle, distance):
        if angle == 0:
            for x in range(distance):
                self.vertical += 1
                self.markLocation()
        elif angle == 180:
            for x in range(distance):
                self.vertical -= 1
                self.markLocation()
        elif angle == 90:
            for x in range(distance):
                self.horizontal += 1
                self.markLocation()
        elif angle == 270:
            for x in range(distance):
                self.horizontal -= 1
                self.markLocation()
    def markLocation(self):        
        loc = str(self.horizontal) + "x" + str(self.vertical)
        if loc in self.locations and self.escape:
            raise LazyError
        else:
            self.locations.append(loc)
    def partOne(self):
        self.reset()
        self.escape = False
        for instruction in self.instructions:
            self.walk(self.turn(instruction[0]), int(instruction[1:]))
        print("Part 1: Distance =", abs(self.horizontal) + abs(self.vertical))
    def partTwo(self):
        self.reset()
        self.escape = True
        for instruction in self.instructions:
            try:
                self.walk(self.turn(instruction[0]), int(instruction[1:]))
            except LazyError as error:
                break
        print("Part 2: Distance =", abs(self.horizontal) + abs(self.vertical))
class Two(day.Day):
    """Solution for 2016 day 2"""
    def __init__(self, test=False):
        day.Day.__init__(self, 2016, 2, test)
        self.lines = self.fileToList()
    def partOne(self):
        min = 0
        max = 2
        x = 1
        y = 1
        for line in self.lines:
            for char in line:
                if char == 'U' and y < max:
                    y += 1
                elif char == 'D' and y > min:
                    y -= 1
                elif char == 'R' and x < max:
                    x += 1
                elif char == 'L' and x > min:
                    x -= 1
        print("Part 1:")
    def partTwo(self):
        print("Part 2:")
     
