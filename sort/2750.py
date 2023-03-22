n = int(input()) #수의 개수 입력
num = [] #입력된 숫자 list
for i in range(n):
    num.append(int(input())) #숫자 입력 n번 반복

num.sort() #정렬(기본 오름차순)
for i in range(len(num)):
    print(num[i]) #정렬된 숫자 한 개씩 출력