from random import randint

player = input()
computer = randint(0,2)

if computer == 0:
    computer = "Dam"
if computer == 1:
    conputer = "Keo"
if computer == 2:
    computer = "La"

print(computer)