input_data = """Time:        54     94     65     92
Distance:   302   1476   1029   1404"""

test_data = """Time:      7  15   30
Distance:  9  40  200"""

data = input_data

times = data.split('\n')[0].split()[1:]
distances = data.split('\n')[1].split()[1:]

posibilities = []
iterator = 0
while iterator < len(times):
    time = int(times[iterator])
    distance = int(distances[iterator])
    valid = 0
    for velocity in range(0, time):
        distance_moved = (time - velocity) * velocity
        if distance_moved > distance :
            valid += 1

    posibilities.append(valid)
    iterator += 1
    
score = 1
for posibility in posibilities :
    score *= posibility

print(f"Part 1: Score {score}")

# Part 2
score = 1
time_parts = data.split('\n')[0].split()[1:]
distance_parts = data.split('\n')[1].split()[1:]
time = ''
distance = ''
for part in time_parts:
    time += part
for part in distance_parts:
    distance += part
time = int(time)
distance = int(distance)

valid = 0
for velocity in range(0, time):
    distance_moved = (time - velocity) * velocity
    if distance_moved > distance :
        valid += 1

print(f"Part 2: Score {valid}")