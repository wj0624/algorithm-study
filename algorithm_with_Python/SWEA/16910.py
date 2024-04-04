#원안의 점

T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    cnt=0
    for x in range(1, N+1) :
        for y in range(N+1):
            if (x*x+y*y) <= (N*N) :
                cnt += 1
    print(f"#{test_case} {cnt*4+1}")