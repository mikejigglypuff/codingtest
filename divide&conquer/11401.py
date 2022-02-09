import sys

bignum = 1000000007

def fac(n):
    result = 1
    for i in range(2, n + 1):
        result = (result * i) % bignum
    return result

def restpow(n, p):
    if(p == 1):
        return n % bignum
    
    tmp = restpow(n, p // 2)
    
    if(p % 2 == 1):
        return tmp * tmp * n % bignum
    else:
        return tmp * tmp % bignum

n, k = map(int, sys.stdin.readline().split())

num1, num2 = fac(n), fac(k) * fac(n - k) % bignum
print(num1 * restpow(num2, bignum - 2) % bignum)

#https://velog.io/@ledcost/%EB%B0%B1%EC%A4%80-11401-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EC%9D%B4%ED%95%AD-%EA%B3%84%EC%88%98-3-%EA%B3%A8%EB%93%9C1-%EB%B6%84%ED%95%A0-%EC%A0%95%EB%B3%B5 를 참고