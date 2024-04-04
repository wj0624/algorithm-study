T = int(input())

for test_case in range(1, T+1):
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    memo = [[]*N for _ in range(N)] #가능한 팀 조합 저장
    arr.sort(reverse=True) #내림차순 정렬(실력 높은 순부터)
    for i in range(N):
        sub = arr[i:]
        for j in range(len(sub)):
            if sub[0]-sub[j] <= K : # 실력 차이 K이하 선발
                memo[i].append(sub[j])
            else : # 실력차 K 초과 선수 만나면 탐색 멈춤
                break
    ans = 0
    for i in range(len(memo)): #가능한 팀들 중 최대 인원 탐색
        ans = max(ans, len(memo[i]))
    print(f"#{test_case} {ans}")