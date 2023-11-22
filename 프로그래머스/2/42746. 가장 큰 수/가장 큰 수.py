def solution(li):
    if sum(li) == 0:
        return "0"
    else:
        li_re = []
        for i in li:
            li_re.append(str(i)*3)
        li_re.sort(reverse=True)
        answer = ""
        for word in li_re:
            answer += word[:len(word)//3]
        return answer