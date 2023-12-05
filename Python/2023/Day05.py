import time

input_file_path = "InputDay05.txt" 

with open(input_file_path, "r") as file:
    input_data = file.read()

test_data = """seeds: 79 14 55 13

seed-to-soil map:
50 98 2
52 50 48

soil-to-fertilizer map:
0 15 37
37 52 2
39 0 15

fertilizer-to-water map:
49 53 8
0 11 42
42 0 7
57 7 4

water-to-light map:
88 18 7
18 25 70

light-to-temperature map:
45 77 23
81 45 19
68 64 13

temperature-to-humidity map:
0 69 1
1 0 69

humidity-to-location map:
60 56 37
56 93 4"""

data = input_data.split('\n\n')
seeds = [int(seed) for seed in data[0].split(': ')[1].split(' ')]
steps = []

# Helper
def resolve_seed(steps, value) :
    for step in steps:
        for instruction in step:
            if value in range(instruction['source'], instruction['source'] + instruction['range']):
                value += (instruction['destination'] - instruction['source'])
                break
    return value

# Extract steps into range dictionaries
for map in data[1:]:
    step = []
    step_data = map.splitlines()[1:]
    for data in step_data:
        values = data.split(' ')
        step.append({'destination': int(values[0]), 'source': int(values[1]), 'range': int(values[2])})
    steps.append(step)

# Run Part 1
scores = []
for seed in seeds:
    scores.append(resolve_seed(steps, seed))

print(f"Part 1: Lowest score {min(scores)}")


seed_ranges = [seeds[i:i+2] for i in range(0, len(seeds), 2)]
for seed_range in seed_ranges:
    #for value in range(seed_range[0], seed_range[0] + seed_range[1]):
    value = resolve_seed(steps, seed_range[0])
    second = resolve_seed(steps, seed_range[0] + seed_range[1] - 1)
    diff = second - value + 1

    print(seed_range)
    print(f"{seed_range[0]} {seed_range[0] + seed_range[1] - 1}")
    print(f"{value} {second}")
    print(f"Same?!?! {diff == seed_range[1]}")

    middle = resolve_seed(steps, seed_range[0] + (diff // 2))
    print(f"{middle} {seed_range[0] + diff // 2}")

    print(f"---")
