import sys
input =sys.stdin.readline

N = int(input())
li_dict = dict()
li = list(map(str,input().rstrip().split()))
for word in li:
    lword = len(word)
    if lword >= 6:
        new_word = word[lword-6:]
        if new_word == "Cheese":
            if word not in li_dict.keys():
                li_dict[word] = 1

if len(li_dict) >= 4:
    print("yummy")
else:
    print("sad")