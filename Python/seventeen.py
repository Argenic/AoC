import day
class One(day.Day):
    """Solution for 2017 day 1"""
    def __init__(self, test=True):
        day.Day.__init__(self, 2017, 1, test)
        self.line = self.getLine()
    def partOne(self):
        solution = 0
        for x in range(len(self.line)):
            if(x == 0):
                if(self.line[0] == self.line[-1]):
                   solution += int(self.line[x])
            else:
                if(self.line[x] == self.line[x-1]):
                   solution += int(self.line[x])
        print("Part 1: Solution", solution)
    def partTwo(self):
        solution = 0
        for x in range(int(len(self.line)/2)):
            if(self.line[x] == self.line[int(x+(len(self.line)/2))]):
                solution += 2 * int(self.line[x])
        print("Part 2: Solution", solution)
class Two(day.Day):
    """Solution for 2017 day 2"""
    def __init__(self, test=False):
        day.Day.__init__(self, 2017, 2, test)
        self.lines = self.fileToList()
    def partOne(self):
        checksum = 0
        for line in self.lines :
            numbers = [int(x) for x in line.split()]
            numbers.sort()
            checksum += numbers[-1] - numbers[0]
        print("Part 1: Checksum", checksum)
    def partTwo(self):
        checksum = 0
        for line in self.lines:
            numbers = [int(x) for x in line.split()]
            numbers.sort(reverse=True)
            flag = False
            for x in range(len(numbers)):
                left = numbers[x]
                for y in range(x + 1, len(numbers)):
                    if(left % numbers[y] == 0) :
                        checksum += left / numbers[y]
                        flag = True
                        break
                if flag:
                    break
        print("Part 2: Checksum", int(checksum))
class Three(day.Day):
    """Solution for 2017 day 3"""
    def __init__(self, test=True):
        day.Day.__init__(self, 2017, 3, test)
        self.input = 325489
    def reset(self):
        self.min_x = 0
        self.max_x = 0
        self.min_y = 0
        self.max_y = 0
        self.x = 0
        self.y = 0
        self.direction = "right"
    def walk(self):
        #print("NUMBER", needle)
        if self.direction == "up":
            if self.y <= self.max_y :
                self.y += 1
                #print("UP")
            if self.y > self.max_y :
                self.max_y += 1
                self.direction = "left"
                #print("TURN LEFT")
        elif self.direction == "down":
            if self.y >= self.min_y :
                self.y -= 1
                #print("DOWN")
            if self.y < self.min_y :
                self.min_y -= 1
                self.direction = "right"
                #print("TURN RIGHT")
        elif self.direction == "left":
            if self.x >= self.min_x:
                self.x -= 1
                #print("LEFT")
            if self.x < self.min_x:
                self.min_x -= 1
                self.direction = "down"
                #print("TURN DOWN")
        elif self.direction == "right":
            if self.x <= self.max_x:
                self.x += 1
                #print("RIGHT")
            if self.x > self.max_x:
                self.max_x += 1
                self.direction = "up"
                #print("TURN UP")
        #print(x, "x", y)
    def partOne(self):
        self.reset()
        for needle in range(2, self.input + 1):
            self.walk()
        print("Part 1: Distance", abs(self.x)+abs(self.y))
    def partTwo(self):
        self.reset()
        list = {}
        column = {}
        column[self.y] = 1;
        list[self.x] = column
        score = 0
        while score < self.input:
            self.walk()
            # First or create central column
            if list.get(self.x) is None:
                column = {}
            else:
                column = list[self.x]
            # First or create left column
            if list.get(self.x - 1) is None:
                left_column = {}
            else:
                left_column = list[self.x - 1]
            # First or create right column
            if list.get(self.x + 1) is None:
                right_column = {}
            else:
                right_column = list[self.x + 1]
            score = 0
            # Add top and bottom
            if column.get(self.y + 1):
                score += column.get(self.y + 1)
            if column.get(self.y -1):
                score += column.get(self.y - 1)
            # Add left side top, middle and bottom
            if left_column.get(self.y + 1):
                score += left_column.get(self.y + 1)
            if left_column.get(self.y):
                score += left_column.get(self.y)    
            if left_column.get(self.y - 1):
                score += left_column.get(self.y - 1)  
            # Add right side top, middle and bottom
            if right_column.get(self.y + 1):
                score += right_column.get(self.y + 1)
            if right_column.get(self.y):
                score += right_column.get(self.y)    
            if right_column.get(self.y - 1):
                score += right_column.get(self.y - 1)  
            column[self.y] = score
            list[self.x] = column
        print("Part 2: First increment", score)
class Four(day.Day):
    """Solution for 2017 day 4"""
    def __init__(self, test=True):
        day.Day.__init__(self, 2017, 4, test)
        self.lines = self.fileToList()
    def partOne(self):
        valid = 0
        for line in self.lines:
            phrase = line.split(" ")
            if len(phrase) == len(set(phrase)):
               valid += 1
        print("Part 1: Valid", valid)
    def partTwo(self):
        valid = 0
        for line in self.lines:
            phrase = line.split(" ")
            sortedPhrase = []
            for word in phrase:
                sortedWord = ''.join(sorted(word))
                sortedPhrase.append(sortedWord)
            if len(sortedPhrase) == len(set(sortedPhrase)):
                valid += 1
        print("Part 2: Valid", valid)
class Five(day.Day):
    """Solution for 2017 day 5"""
    def __init__(self, test=True):
        day.Day.__init__(self, 2017, 5, test)
    def partOne(self):
        self.lines = self.fileToList('int')
        index = 0
        running = True
        count = 0
        while running:
            if index < len(self.lines):
                value = self.lines[index]
                self.lines[index] += 1
                index += value
                count += 1
            else:
                running = False
        print("Part 1: Count", count)
    def partTwo(self):
        self.lines = self.fileToList('int')
        index = 0
        running = True
        count = 0
        while running:
            if abs(index) < len(self.lines):
                value = self.lines[index]
                if value >= 3:
                    self.lines[index] -= 1
                else:
                    self.lines[index] += 1
                index += value
                count += 1
            else:
                running = False
        print("Part 2: Count", count)
class Six(day.Day):
    """Solution for 2017 day 6"""
    def __init__(self, test=True):
        day.Day.__init__(self, 2017, 6, test)
    def partOne(self):
        values = list(map(int, self.getLine().split('\t')))
        flag = True
        states = []
        count = 0
        while flag:
            count += 1
            highest = max(values)
            index = values.index(highest)
            values[index] = 0
            for x in range(highest):
                index += 1
                if index >= len(values):
                    index = 0
                values[index] += 1
            state = ""
            for value in values:
                state += str(value) + ","
            states.append(state)
            if len(states) != len(set(states)):
                flag = False
        print("Part 1: Count", count)
    def partTwo(self):
        values = list(map(int, self.getLine().split('\t')))
        flag = True
        states = []
        count = 0
        while flag:
            count += 1
            highest = max(values)
            index = values.index(highest)
            values[index] = 0
            for x in range(highest):
                index += 1
                if index >= len(values):
                    index = 0
                values[index] += 1
            state = ""
            for value in values:
                state += str(value) + ","
            states.append(state)
            if len(states) != len(set(states)):
                flag = False
        print("Part 2: Count", len(states) - states.index(state) - 1)
class Seven(day.Day):
    """Solution for 2017 day 7"""
    def __init__(self, test=True):
        day.Day.__init__(self, 2017, 7, test)
        self.lines = self.fileToList()
    def createNodes(self):
        nodes = {}
        for line in self.lines:
            node = Node(line)
            nodes[node.name] = node
        return nodes
    def topDog(self):
        nodes = self.createNodes()
        copy = self.createNodes()
        for node in copy:
            node = copy.get(node)
            if node.children:
                for child_key in node.children_keys:
                    del(nodes[child_key])
        return(nodes.get(list(nodes)[0]).name)        
    def partOne(self):
        print("Part 1: Top dog", self.topDog())
    def partTwo(self):
        print("Part 2:")
class Node():
    def __init__(self, line):
        self.name = line.split(' ')[0]
        children_string = line.split(' -> ')
        children_keys = None
        self.children = False
        if len(children_string) > 1:
            children_keys = children_string[1].split(', ')
            self.children = True
        self.children_keys = children_keys


