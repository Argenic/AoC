
input_file_path = "InputDay11.txt"
 
with open(input_file_path, "r") as file:
    input_data = file.read()
 
test_data = """...#......
.......#..
#.........
..........
......#...
.#........
.........#
..........
.......#..
#...#....."""

data = input_data.split('\n')

# Find line numbers that should be duplicated
line_increase = []
empty_line = False
for id, line in enumerate(data) :
    if '#' not in line:
        line_increase.append(id)
        empty_line = line
    
# Duplicate lines that have to be.
counter = 0
for increase in line_increase :
    data.insert(increase + counter, empty_line)
    counter += 1

# Rotate the text 90 degrees, so columns are now rows
height = len(data)
width = len(data[0])
rotated_data = [
    "".join(data[row][col] for row in range(height - 1, -1, -1))
    for col in range(width)
]

# Find line numbers (previous columns) that should be duplicated
line_increase = []
empty_line = False
for id, line in enumerate(rotated_data) :
    if '#' not in line:
        line_increase.append(id)
        empty_line = line

# Duplicate the relevant lines.
counter = 0
for increase in line_increase :
    rotated_data.insert(increase + counter, empty_line)
    counter += 1

needles = []
for x, line in enumerate(rotated_data) :
    for y, cell in enumerate(line) :
        if rotated_data[x][y] == '#':
            needles.append({'x': x, 'y': y})

score = 0
for id, needle in enumerate(needles[:-1]) :
    for next in needles[id + 1:] :
        value = abs(needle['x'] - next['x'])
        value += abs(needle['y'] - next['y'])
        score += value

print(f"Part 1: Score {score}")