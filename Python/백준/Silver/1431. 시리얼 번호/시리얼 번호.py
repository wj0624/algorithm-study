# 모든 자리수의 합 구하기
def sum(a):
    result = 0
    for i in a:
        if i.isdigit() : # 숫자인 것만 더하기
            result += int(i)
    return result

#입력
N = int(input())
arr = []
for i in range(N):
    arr.append(input())

# 정렬조건 : 길이 짧은 것 > 모든 자리수의 합 > 사전순 
arr.sort(key = lambda x :(len(x), sum(x), x))
print("\n".join(arr))