#등차수열 y-x = z-y
T = int(input())
for test_case in range(1,T+1):
    a, b, c = map(int, input().split())
    if b-a == c-b :
        print(f"#{test_case} {0.0}")
    else:
        print(f"#{test_case} {abs(b-((a+c)/2))}")

#a, b, c 사이의 거리가 같아야 하므로 b가 (a+c)/2 와 같아야 함.
#그러므로 b와 (a+c)/2의 차의 절댓값이 정답이 된다.