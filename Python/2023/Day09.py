input_file_path = "InputDay09.txt"
 
with open(input_file_path, "r") as file:
    input_data = file.read()
 
test_data = """0 3 6 9 12 15
1 3 6 10 15 21
10 13 16 21 30 45"""

def check_row(rows):
    current_row = rows[-1]
    new_row = []
    for i in range(len(current_row) - 1) :
        new_row.append(current_row[i + 1] - current_row[i])
        
    rows.append(new_row)
    if len(set(new_row)) == 1:
        return rows
    else:
        return check_row(rows)

data = input_data

games = []
for line in data.split('\n') :
    string_values = line.split()
    values = []
    for value in string_values :
        values.append(int(value))
    iterations = check_row([values])
    iterations.reverse()
    games.append(iterations)

score = 0
for game in games:
    value = 0
    for round in game :
        value += round[-1]
    score += value

print(f"Part 1: Score = {score}")

score = 0
for game in games:
    value = 0
    for round in game :
        value = round[0] - value
    score += value

print(f"Part 2: Score = {score}")