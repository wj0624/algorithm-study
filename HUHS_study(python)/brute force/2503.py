from itertools import permutations
n = int(input())
num = list(permutations(['1','2','3','4','5','6','7','8','9'], 3))

for _ in range(n):
    test, s, b = map(int, input().split())
    test = list(str(test))
    cnt = 0
    for i in range(len(num)):
        strike = ball = 0
        i -= cnt
        for j in range(3):
            if num[i][j] == test[j]:
                strike += 1
            elif test[j] in num[i]:
                ball += 1
        if (strike != s) or (ball != b):
            num.remove(num[i])
            cnt += 1
print(len(num))

#순열 사용 관련 참고링크 : https://ourcstory.tistory.com/414