#백트래킹, 시간 초과 실패
#가장 큰 감소하는 수 9876543210 n=1022
n = int(input())
num = 0
cnt = 0
if n > 1022:
    print(-1)
elif n == 0:
    print(0)
else:
    while True:
        num_list = list(str(num))
        if len(num_list) == 1: #한자릿수는 무조건 감소하는 수
            cnt += 1
        else:
            for i in range(1, len(num_list)):
                if num_list[i-1] <= num_list[i]:
                    break
            else:
                cnt += 1
        num += 1
        if cnt == n:
            break
    print(num)