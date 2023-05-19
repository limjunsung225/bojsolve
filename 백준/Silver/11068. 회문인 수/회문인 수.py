def is_palindrome(num):
    digits = []
    flag = True
    
    for base in range(2, 65):
        temp_num = num
        while temp_num != 0:
            r = temp_num % base
            temp_num = temp_num // base
            digits.append(r)
        
        left = 0
        right = len(digits) - 1
        flag = True
        
        while left <= right:
            if digits[left] == digits[right]:
                left += 1
                right -= 1
            else:
                flag = False
                break
        
        if flag:
            return True
        
        digits = []
    
    return False

t = int(input())
while t > 0:
    n = int(input())
    if is_palindrome(n):
        print("1")
    else:
        print("0")
    
    t -= 1