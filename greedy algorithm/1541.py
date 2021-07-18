import sys

def strtoequ(equation): # 입력된 식을 숫자와 기호로 분리해 배열에 추가하는 함수
    num, splits = 0, []
    for i in range(len(equation)):
        if(equation[i] == '+' or equation[i] == '-'):
            splits.append(num)
            splits.append(equation[i])
            num = 0
        else:
            num = num * 10 + int(equation[i])
    splits.append(num)
    return splits


def brace(equation):
    r, oper1, oper2, l = [equation[0]], "", "", len(equation)
    for i in range(2, l - 1, 2):
        oper1, oper2 = equation[i - 1], equation[i + 1]
        if(oper1 == "-"):
            r.append(oper1)         
            r.append(equation[i])
        else:
            r[len(r) - 1] += equation[i]
    if(oper2 == "-"):
        r.append(oper2)
        r.append(equation[l - 1])
    elif(oper2 == "+"):
        r[len(r) - 1] += equation[l - 1]
    else:
        if(l > 1): # 식에 기호가 없는 경우를 위한 조건문
            oper1 = equation[1]
            if(oper1 == "-"):
                r.append(oper1)
                r.append(equation[l - 1])
            else:
                r[len(r) - 1] += equation[l - 1]
    return r

equation = sys.stdin.readline().rstrip()
equations = strtoequ(equation)
result = brace(equations)
num = result[0]
for i in range(1, len(result), 2):
    num -= result[i + 1]
print(num)
