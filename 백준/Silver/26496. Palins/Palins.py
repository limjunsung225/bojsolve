import sys
input= sys.stdin.readline

while True:
        li_dict = dict()
        word = input().rstrip()
        if len(word)==0:
            break
        for i in range(len(word)): #단어를 돌면서
            for j in range(i,len(word)):
                new_word = word[i:j+1] # M , MO , MOM ,  //  M , MA, MAD, MADA, MADAM.... 순으로 탐색
                if new_word == new_word[::-1]: # 펠린드롬이면
                    if new_word not in li_dict.keys(): #딕셔너리에 없으면
                        li_dict[new_word] = 1
        
        li_dict = dict(sorted(li_dict.items(),key = lambda x:(len(x[0]))))  #단어 길이순으로 정렬, 먼저 나온순으로 이므로 사전순으로는 정렬하면 안된다.
        answer = []
        for key, values in li_dict.items():
            temp = '"' + key + '"' #출력 형식에 맞춰 쌍따옴표로 감싸준다.
            answer.append(temp)
        
        print("{} - {}".format(len(li_dict)," ".join(map(str,answer))))