input_file_path = "InputDay07.txt" 

with open(input_file_path, "r") as file:
    input_data = file.read()

test_data = """32T3K 765
T55J5 684
KK677 28
KTJJT 220
QQQJA 483"""

data = input_data

high_cards = []
pairs = []
double_pair = []
three_of_kind = []
full_houses = []
four_of_kind = []
five_of_kind = []

# Process and box cards based on result
for line in data.split('\n') :
    line = line.replace("A", "E")
    line = line.replace("K", "D")
    line = line.replace("Q", "C")
    line = line.replace("J", "B")
    line = line.replace("T", "A")
    
    card = line.split()[0]
    unique_card = set(card)
    
    if(len(unique_card) == 1) :
        five_of_kind.append(line)

    if(len(unique_card) == len(card)) :
        high_cards.append(line)

    if(len(unique_card) == len(card) - 1) :
        pairs.append(line)
        
    if(len(unique_card) == len(card) - 2) :
        for unique in unique_card:
            if card.count(unique) == 2:
                double_pair.append(line)
                break
            if card.count(unique) == 3:
                three_of_kind.append(line)
                break

    if(len(unique_card) == len(card) - 3) :        
        for unique in unique_card:
            if card.count(unique) == 2 or card.count(unique) == 3:
                full_houses.append(line)
                break
            if card.count(unique) == 4:
                four_of_kind.append(line)
                break


high_cards = sorted(high_cards)
pairs = sorted(pairs)
double_pair = sorted(double_pair)
three_of_kind = sorted(three_of_kind)
full_houses = sorted(full_houses)
four_of_kind = sorted(four_of_kind)
five_of_kind = sorted(five_of_kind)

rank = 1
score = 0
for card in high_cards:
    score += int(card.split()[1]) * rank
    rank += 1
for card in pairs:
    score += int(card.split()[1]) * rank
    rank += 1
for card in double_pair:
    score += int(card.split()[1]) * rank
    rank += 1
for card in three_of_kind:
    score += int(card.split()[1]) * rank
    rank += 1
for card in full_houses:
    score += int(card.split()[1]) * rank
    rank += 1
for card in four_of_kind:
    score += int(card.split()[1]) * rank
    rank += 1
for card in five_of_kind:
    score += int(card.split()[1]) * rank
    rank += 1

print(f"Part 1: Score = {score}")


high_cards = []
pairs = []
double_pair = []
three_of_kind = []
full_houses = []
four_of_kind = []
five_of_kind = []

# Process and box cards based on result
for line in data.split('\n') :
    line = line.replace("A", "E")
    line = line.replace("K", "D")
    line = line.replace("Q", "C")
    line = line.replace("J", "1")
    line = line.replace("T", "A")
    
    card = line.split()[0]
    unique_card = set(card)
    
    if(len(unique_card) == 1) :
        # 5 of a kind is not effected, since there isnt anything better.
        five_of_kind.append(line)    
        
    if(len(unique_card) == len(card)) :
        # Only 1 Joker can exist, so if it does then add it to pairs instead
        if '1' not in card :
            high_cards.append(line)
        else:
            pairs.append(line)

    if(len(unique_card) == len(card) - 1) :
        # If this line contains a joker, we can always assume the new hand type would be 3 of a kind
        if '1' not in card :
            pairs.append(line)
        else:
            three_of_kind.append(line)
        
    if(len(unique_card) == len(card) - 2) :
        for unique in unique_card:
            if card.count(unique) == 2:
                # If this contains no joker then stays a double pair. 
                # If it contains 1 joker, it becomes a full house. 
                # If it contains 2 jokers then it becomes 4 of a kind
                if '1' not in card :
                    double_pair.append(line)
                elif card.count('1') == 1 :
                    full_houses.append(line)
                else :
                    four_of_kind.append(line)
                break
            if card.count(unique) == 3:
                # if this line contains a joker we can assume it becomes 4 of a kind
                if '1' not in card:
                    three_of_kind.append(line)
                else:
                    four_of_kind.append(line)
                break

    if(len(unique_card) == len(card) - 3) :        
        for unique in unique_card:
            if card.count(unique) == 2 or card.count(unique) == 3:
                # If this line contains a joker we can assume it becomes 5 of a kind
                if '1' not in card:
                    full_houses.append(line)
                else :
                    five_of_kind.append(line)
                break
            if card.count(unique) == 4:
                # If this line contains a joker we can assume it becomes 5 of a kind
                if '1' not in card:
                    four_of_kind.append(line)
                else:
                    five_of_kind.append(line)
                break

high_cards = sorted(high_cards)
pairs = sorted(pairs)
double_pair = sorted(double_pair)
three_of_kind = sorted(three_of_kind)
full_houses = sorted(full_houses)
four_of_kind = sorted(four_of_kind)
five_of_kind = sorted(five_of_kind)

rank = 1
score = 0
for card in high_cards:
    score += int(card.split()[1]) * rank
    rank += 1
for card in pairs:
    score += int(card.split()[1]) * rank
    rank += 1
for card in double_pair:
    score += int(card.split()[1]) * rank
    rank += 1
for card in three_of_kind:
    score += int(card.split()[1]) * rank
    rank += 1
for card in full_houses:
    score += int(card.split()[1]) * rank
    rank += 1
for card in four_of_kind:
    score += int(card.split()[1]) * rank
    rank += 1
for card in five_of_kind:
    score += int(card.split()[1]) * rank
    rank += 1

print(f"Part 2: Score {score}")