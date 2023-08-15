# - 기준으로 나눠서 첫번째 숫자에서 모두 빼기
arr = input().split('-')
#print(arr)
ans = sum(map(int, arr[0].split('+')))
for i in arr[1:]:
    a = sum(map(int, i.split('+')))
    ans -= a
print(ans)