#문자열문자열

T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    str = list(input())
    ans = "No"
    mid = int(N/2)
    if N%2 == 0:
        for i in range(mid) :
            if(str[i]==str[i+mid]):
                ans = "Yes"
            else :
                ans = "No"
                break

    print(f"#{test_case} {ans}")
