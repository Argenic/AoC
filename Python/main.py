import day
import fifteen
import sixteen
import seventeen
import eighteen
import nineteen
import twenty
import twentyone
input
allDays = [
    # 2015
    fifteen.One(test=False),
    fifteen.Two(test=False),
    fifteen.Three(test=False),
    # 2016
    sixteen.One(test=False),
    # 2017
    seventeen.One(test=False),
    seventeen.Two(test=False),
    seventeen.Three(test=False),
    seventeen.Four(test=False),
    seventeen.Five(test=False),
    seventeen.Six(test=False),
    # 2018
    eighteen.One(test=False),
    eighteen.Two(test=False),
    # 2019
    nineteen.One(test=False),
    # 2020
    twenty.One(test=False),
    # 2021
    twentyone.One(test=False),
    twentyone.Two(test=False),
]
days = [
    twenty.Two(test=False),
]
print("-----------------------------!-----------------------------")
for day in days:
#for day in allDays:
    print("Starting day", str(day.day), "-", str(day.year))
    day.run()
    print("-----------------------------!-----------------------------")
