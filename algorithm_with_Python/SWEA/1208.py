#Flatten - 평탄화 작업

T = 10
for test_case in range(1, T+1):
    dump = int(input())
    arr = list(map(int, input().split()))
    high = low = 0
    for i in range(dump):
        high = arr.index(max(arr))
        low = arr.index(min(arr))
        if arr[high] - arr[low] <= 1 :
            break
        arr[high] -= 1
        arr[low] += 1

    high = arr.index(max(arr))
    low = arr.index(min(arr))
    print(f"#{test_case} {arr[high]-arr[low]}")
