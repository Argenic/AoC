# Setup input and test data
file_path = "inputDay01.txt"

with open(file_path, "r") as file:
    input_data = file.read()

test_data = """1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet"""

# Setup an output value
calibration_value = 0

# Iterate input for part #1
for line in input_data.split('\n'):
    digits = ''.join(filter(str.isdigit, line))
    value = digits[0] + digits[-1]
    calibration_value += int(value)

# Print result
print(f"Part 1 : Final Calibration Value of: {calibration_value}")

# Setup part #2
test_data = """two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen"""

# Setup an output value
calibration_value = 0

#iterate input for part #2
for line in input_data.split('\n'):
    line = line.replace('one', 'o1e')
    line = line.replace('two', 't2')
    line = line.replace('three', '3')
    line = line.replace('four', '4')
    line = line.replace('five', '5')
    line = line.replace('six', '6')
    line = line.replace('seven', '7')
    line = line.replace('eight', '8')
    line = line.replace('nine', '9')
    digits = ''.join(filter(str.isdigit, line))
    value = digits[0] + digits[-1]
    calibration_value += int(value)

# Print result
print(f"Part 2 : Final Calibration Value of: {calibration_value}")