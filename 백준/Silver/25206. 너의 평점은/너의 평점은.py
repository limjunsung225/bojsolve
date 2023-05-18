alp = ""
avg = 0.0
sumGrade = 0.0
score = [0.0] * 20
grade = [0.0] * 20

for i in range(20):
    alp, grade[i], input_val = map(str,input().split())
    grade[i] = float(grade[i])

    if input_val == "A+":
        score[i] = 4.5
    elif input_val == "A0":
        score[i] = 4.0
    elif input_val == "B+":
        score[i] = 3.5
    elif input_val == "B0":
        score[i] = 3.0
    elif input_val == "C+":
        score[i] = 2.5
    elif input_val == "C0":
        score[i] = 2.0
    elif input_val == "D+":
        score[i] = 1.5
    elif input_val == "D0":
        score[i] = 1.0
    elif input_val == "F":
        score[i] = 0.0
    elif input_val == "P":
        score[i] = 0.0
        grade[i] = 0.0

    avg += score[i] * grade[i]
    sumGrade += grade[i]

avg = avg / sumGrade

print("{:.6f}".format(avg))