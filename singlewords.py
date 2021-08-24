from typing import final


dic = {}

x = 'alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta'

word = " "
finalWord = ""
for char in x:
    if char == ' ': 
        if word in dic:
            word = " "
        else:
            dic[word] = 1
            for i in word:
                finalWord += str(i)
            word = " "
    else:
        word = word + char

print (finalWord) 