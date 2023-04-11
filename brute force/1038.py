#조합을 사용해서 시간 초과 문제 해결
#백트래킹, 시간 초과 실패
#가장 큰 감소하는 수 9876543210
from itertools import combinations
n = int(input())
ans = []
for i in range(1, 11):
    #combinations(list, n): list 중에서 n개 조합
    for j in combinations(range(10), i): #(0)부터 (0~9)까지 조합
        num = ''.join(list(map(str, reversed(list(j))))) #만든 조합을 거꾸로 정렬 후 문자열로 만들기
        ans.append(int(num))
ans.sort() #리스트 정렬
if n >= len(ans):
    print(-1)
else:
    print(ans[n])

# num = 1
# cnt = 0
# if n > 1022:
#     print(-1)
# elif n == 0:
#     print(0)
# else:
#     while True:
#         num_list = list(str(num))
#         if len(num_list) == 1: #한자릿수는 무조건 감소하는 수
#             cnt += 1
#         else:
#             for i in range(1, len(num_list)):
#                 if num_list[i-1] <= num_list[i]: #감소하는 수가 아니면 break
#                     break
#             else:
#                 cnt += 1 #감소하는 수면
#         num += 1
#         if cnt == n:
#             break
#     print(num)