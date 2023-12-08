input_file_path = "InputDay08.txt"
 
with open(input_file_path, "r") as file:
    input_data = file.read()
 
test_data = """LLR
 
AAA = (BBB, BBB)
BBB = (AAA, ZZZ)
ZZZ = (ZZZ, ZZZ)"""
 
data = test_data
instruction = data.split('\n')[0]
lines = data.split('\n')[2:]
 
map_values = {}
for line in lines:
    key = line.split(' = ')[0]
    values = line.split(' = ')[1].replace('(', '').replace(')', '').split(', ')
    map_values[key] = {'left' : values[0], 'right' : values[1]}
 
iterations = 0
current_key = "AAA"
breaker = True
while breaker :
    for char in instruction:
        if char == "L" :
            current_key = map_values[current_key]['left']
        if char == "R" :
            current_key = map_values[current_key]['right']
        iterations += 1
        if current_key == "ZZZ" :
            breaker = False
            break
 
print(f"Part 1: Iterations {iterations}")

current_keys = []
for key, map in map_values.items() :
    if(key[2] == 'A') :
        current_keys.append(key)

breaker = True
iterations = 0
while breaker :
    for char in instruction:
        for id, key in enumerate(current_keys):
            if char == "L" :
                current_keys[id] = map_values[key]['left']
            if char == "R" :
                current_keys[id] = map_values[key]['right']
        
        iterations += 1

        valid = True
        for key in current_keys:
            if key[2] != 'Z':
                valid = False

        if valid:
            breaker = False

print(f"Part 2: Iterations {iterations}")