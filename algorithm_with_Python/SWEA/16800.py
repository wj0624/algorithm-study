#구구단 걷기

T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    arr = []
    for i in range(1, int(N**0.5)+1):
        if N%i == 0:
            arr.append((i-1)+(N//i)-1)
    print(f"#{test_case} {min(arr)}")