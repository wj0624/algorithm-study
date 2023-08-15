#시간초과 ㅠㅠ
cnt1 = 1 #왜인지 모르겠지만.. 1을 더해줘야함
cnt2 = 0

def fib(n): #코드1
    global cnt1
    if n==1 or n==2:
        return 1
    else:
        cnt1 += 1
        return fib(n-1) + fib(n-2)

def fibonacci(n): # 코드2
    global cnt2
    f[1],f[2] = 1,1
    for i in range(3,n+1):
        f[i] = f[i-1]+f[i-2]
        cnt2 += 1
    return f[n]

n = int(input())
f = [0 for _ in range(41)]
fib(n)
fibonacci(n)
print(cnt1, cnt2)