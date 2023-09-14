n = int(input())
jul = input().split()
cnt = 1 # 번호카운트 변수
cnt2 = 0 # 쳐맞을 사람 카운트할 변수
for i in jul:
    if cnt != int(i):
        cnt2+=1
    cnt+=1
print(cnt2)