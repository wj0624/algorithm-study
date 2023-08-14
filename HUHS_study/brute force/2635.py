n = int(input())
ans = [] #정답 리스트
for i in range(1, n+1):
    nums = [n, i]
    j = 0 #리스트 인덱스
    while True:
        if nums[j]-nums[j+1] >= 0: #(앞의 앞의 수 - 앞의 수)가 양수일 때
            nums.append(nums[j]-nums[j+1]) #리스트에 추가
            j+=1 #인덱스 ++
        else:
            break
    if len(ans) < len(nums): #이전 리스트보다 개수가 더 많을 때
        ans = nums #정답 리스트에 추가
print(len(ans))
print(' '.join(map(str, ans)))