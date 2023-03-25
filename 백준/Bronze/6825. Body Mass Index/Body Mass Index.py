import sys
input =sys.stdin.readline

wei = float(input())
hei = float(input())
bmi = wei / (hei * hei)

if bmi > 25:
    print("Overweight")
elif 18.5 <= bmi <= 25.0:
    print("Normal weight")
else:
    print("Underweight")