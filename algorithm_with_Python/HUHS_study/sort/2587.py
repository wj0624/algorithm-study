num = []
for i in range(5):
    num.append(int(input()))
num.sort()
print(int(sum(num)/len(num))) #평균: 모든 수의 합/개수
print(num[2]) #5개의 중앙값: 3번째 수