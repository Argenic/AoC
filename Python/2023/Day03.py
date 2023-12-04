# Setup input and test data
file_path = "inputDay03.txt"

with open(file_path, "r") as file:
    input_lines = file.read().split('\n')

test_lines = """467..114..
...*......
..35..633.
......#...
617*......
.....+.58.
..592.....
......755.
...$.*....
.664.598..""".split('\n')

lines = input_lines

# Translate the input to numbers and gears
numbers = []
for current_line in range(len(lines)):
    number = {}
    # Scrap the line and find a number
    for current_cell in range(len(lines[current_line])):
        cell = lines[current_line][current_cell]
        # Check if were already collecting a number
        if not number:
            # Only start building a number when we find a new digit
            if cell.isdigit():
                number['number'] = cell
                number['line'] = current_line
                number['cell'] = current_cell
        else:
            # If were still looking at digits we have to append
            if cell.isdigit():
                number['number'] += cell
                # Wrap up if line finish
                if current_cell == len(lines[current_line]) - 1:
                    numbers.append(number)
            # Not a number anymore, lets append and reset
            else:
                numbers.append(number)
                number = {}

# Get the needles
needles = [
    {'line': current_line, 'column': current_cell} 
    for current_line, line in enumerate(lines) 
    for current_cell, cell in enumerate(line) 
    if not cell.isdigit() and cell != '.' ]

# Iterate all known needles
score = 0
valid_numbers = []
for needle in needles:
    # Iterate all numbers to find valid ones
    for number in numbers:
        # Check if the line is in the needles range
        if(number['line'] == needle['line'] - 1 
            or number['line'] == needle['line'] 
            or number['line'] == needle['line'] + 1
            ) :
            
            if (number['cell'] <= needle['column'] + 1 
                and number['cell'] + len(number['number']) - 1 >= needle['column'] - 1
                ) :
            
                valid_numbers.append(int(number['number']))

score = sum(valid_numbers)
print(f"Part 1: Final Score {score}")

# Get the gears
gears = [
    {'line': current_line, 'column': current_cell} 
    for current_line, line in enumerate(lines) 
    for current_cell, cell in enumerate(line) 
    if cell == "*"]

# Iterate all known gears
score = 0
for gear in gears:
    # Iterate all numbers to find valid ones
    valid_numbers = set()
    for number in numbers:
        # Check if the line is in the gears range
        if(number['line'] == gear['line'] - 1 
            or number['line'] == gear['line'] 
            or number['line'] == gear['line'] + 1
            ) :
            
            if (number['cell'] <= gear['column'] + 1 
                and number['cell'] + len(number['number']) - 1 >= gear['column'] - 1
                ) :
                
                valid_numbers.add(number['number'])
            
    # When we got to numbers we can update the score accordingly
    if(len(valid_numbers) == 2) :
        score += int(valid_numbers.pop()) * int(valid_numbers.pop())

print(f"Part 2: Final Score {score}")