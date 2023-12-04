# Setup input and test data
file_path = "inputDay02.txt"

with open(file_path, "r") as file:
    input_data = file.read()

test_data = """Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"""

# Threshold Values
red_max = 12
green_max = 13
blue_max = 14

score = 0

# Iterate games for part #1
for line in input_data.split('\n'):
    # Slice up the game
    id = int(line.split(": ")[0].split(" ")[1])
    bags = line.split(": ")[1].split("; ")
    valid = True
    for bag in bags:
        # Process and check bag values on Threshold
        red = 0
        green = 0
        blue = 0
        samples = bag.split(", ")
        for sample in samples:
            values = sample.split(" ")
            if values[1] == "red":
                red += int(values[0])
            if values[1] == "green":
                green += int(values[0])
            if values[1] == "blue":
                blue += int(values[0])
        if(red > red_max or green > green_max or blue > blue_max): 
            # If we hit our thresholds for a bag we mark the line as invalid
            valid = False
    if(valid):
        # Only count valid line ids
        score += id
print(f"Part 1: Final Score = {score}")

score = 0

# Iterate games for part #2
for line in input_data.split('\n'):
    # Slice up the game
    id = int(line.split(": ")[0].split(" ")[1])
    bags = line.split(": ")[1].split("; ")
    # Setup variables that will be the minimum size per color
    highest_red = 0
    highest_green = 0
    highest_blue = 0
    for bag in bags:
        red = 0
        green = 0
        blue = 0
        samples = bag.split(", ")
        for sample in samples:
            values = sample.split(" ")
            if values[1] == "red":
                red += int(values[0])
            if values[1] == "green":
                green += int(values[0])
            if values[1] == "blue":
                blue += int(values[0])
        # Decide if we have to update any highest sizes for this bag
        if(red > highest_red) :
            highest_red = red
        if(green > highest_green) :
            highest_green = green
        if(blue > highest_blue) :
            highest_blue = blue
    score += highest_red * highest_green * highest_blue
print(f"Part 2: Final Score = {score}")