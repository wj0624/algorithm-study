#패턴의 길이
T = int(input())

for test_case in range(1, T+1):
    string = input()
    pattern = string[0]
    for i in range(1, len(string)):
        if string[i:i+len(pattern)] == pattern:
            print(f"#{test_case} {len(pattern)}")
            break
        pattern += string[i]