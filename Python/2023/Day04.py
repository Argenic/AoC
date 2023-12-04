# Specify the path to your input file
input_file_path = "InputDay04.txt"  # Change this to the actual file name

# Use the open function to open the file
with open(input_file_path, "r") as file:
    # Read the contents of the file
    input_data = file.read()

test_data = """Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"""

score = 0
for line in input_data.split('\n'):
    winning_numbers = line.split(' | ')[0].split(': ')[1].split()
    my_numbers = line.split(' | ')[1].split()

    card_score = 0
    for my_number in my_numbers:
        if my_number in winning_numbers:
            card_score += 1
    
    if(card_score > 0) :
        score += 2 ** (card_score -1)
    
print(f"Part 1: Total Score {score}")

card_count = [1] * len(input_data.split('\n'))
for line in input_data.split('\n'):
    winning_numbers = line.split(' | ')[0].split(': ')[1].split()
    card_number = int(line.split(' | ')[0].split(': ')[0].split()[1])
    my_numbers = line.split(' | ')[1].split()

    card_score = 0
    for my_number in my_numbers:
        if my_number in winning_numbers:
            card_score += 1

    while card_score > 0:
        card_count[card_number - 1 + card_score] += card_count[card_number - 1] * 1
        card_score -= 1

print(f"Part 2: Total Score {sum(card_count)}")