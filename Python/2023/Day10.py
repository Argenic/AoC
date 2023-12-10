input_file_path = "InputDay10.txt"
 
with open(input_file_path, "r") as file:
    input_data = file.read()
 
test_data = """-L|F7
7S-7|
L|7||
-L-J|
L|-JF"""

test_data = """7-F7-
.FJ|7
SJLL7
|F--J
LJ.LJ"""

def next_node(current_node) :
    new_node = {'distance': current_node['distance'] + 1}
    # Up
    if (current_node['value'] == '|' and current_node['incoming'] == 'bottom')  \
        or (current_node['value'] == 'J' and current_node['incoming'] == 'left') \
        or (current_node['value'] == 'L' and current_node['incoming'] == 'right') :
        new_node['x'] = current_node['x']
        new_node['y'] = current_node['y'] - 1
        new_node['incoming'] = 'bottom'
    # Right
    if (current_node['value'] == 'F' and current_node['incoming'] == 'bottom')  \
        or (current_node['value'] == 'L' and current_node['incoming'] == 'top') \
        or (current_node['value'] == '-' and current_node['incoming'] == 'left') :
        new_node['x'] = current_node['x'] + 1
        new_node['y'] = current_node['y']
        new_node['incoming'] = 'left'
    # Down
    if (current_node['value'] == '|' and current_node['incoming'] == 'top')  \
        or (current_node['value'] == 'F' and current_node['incoming'] == 'right') \
        or (current_node['value'] == '7' and current_node['incoming'] == 'left') :
        new_node['x'] = current_node['x']
        new_node['y'] = current_node['y'] + 1
        new_node['incoming'] = 'top'
    # Left
    if (current_node['value'] == '7' and current_node['incoming'] == 'bottom')  \
        or (current_node['value'] == 'J' and current_node['incoming'] == 'top') \
        or (current_node['value'] == '-' and current_node['incoming'] == 'right') :
        new_node['x'] = current_node['x'] - 1
        new_node['y'] = current_node['y']
        new_node['incoming'] = 'right'
    new_node['value'] = map[new_node['y']][new_node['x']]
    return new_node


data = input_data

# Build map
map = []
for y, line in enumerate(data.split('\n')) :
    map.append([])
    for char in line:
        map[y].append(char)
map_height = len(map)
map_width = len(map[0])

# Collect start and create nodes array
start = {}
nodes = [start]
for id,  line in enumerate(map) :
    if 'S' in line:
        start['x'] = line.index('S')
        start['y'] = id
        start['distance'] = 0
        start['value'] = 'S'
        break

# Find beginnings
x = start['x']
y = start['y']
# Up
if y - 1 > 0 and (map[y - 1][x] == "|" or map[y - 1][x] == "F" or map[y - 1][x] == "7") :
    current_node = {'x': x, 'y': y - 1, 'distance': 1, 'incoming': 'bottom', 'value': map[y - 1][x]}
# Right
if x + 1 < map_width and (map[y][x + 1] == "-" or map[y][x + 1] == "J" or map[y][x + 1] == "7") :
    current_node = {'x': x + 1, 'y': y, 'distance': 1, 'incoming': 'left', 'value': map[y][x + 1]}
# Down
if y + 1 < map_height and (map[y + 1][x] == "|" or map[y + 1][x] == "J" or map[y + 1][x] == "L") :
    current_node = {'x': x, 'y': y + 1, 'distance': 1, 'incoming': 'top', 'value': map[y + 1][x]}
# Left
if x - 1 > 0 and (map[y][x - 1] == "-" or map[y][x - 1] == "F" or map[y][x - 1] == "L") :
    current_node = {'x': x - 1, 'y': y, 'distance': 1, 'incoming': 'right', 'value': map[y][x - 1]}

while current_node['value'] != 'S' :
    current_node = next_node(current_node)
    nodes.append(current_node)

print(f"Part 1: Steps {int(current_node['distance'] / 2)}")