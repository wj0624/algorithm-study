#회문검사

T = int(input())

for test_case in range(1, T+1):
    s = input()
    ans = 0
    if s == s[::-1]:
        ans = 1
    print(f"#{test_case} {ans}")