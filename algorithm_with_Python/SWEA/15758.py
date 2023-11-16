def gcd(n, m):
    while m > 0:
        n, m = m, n % m
    return n

def lcm(n, m):
    return int(n*m/gcd(n, m))

T = int(input())

for test_case in range(1, T+1):
    S, T = input().split()
    lcm1 = lcm(len(S), len(T))
    if S*(lcm1//len(S)) == T*(lcm1//len(T)) :
        print(f"#{test_case} yes")
    else :
        print(f"#{test_case} no")