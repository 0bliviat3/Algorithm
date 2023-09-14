tArr = []
a= float(input())
tt=[a]
tArr=tArr+tt
cnt = 1
while True:
    a = float(input())
    if int(a) == 999 and cnt>1:
        break;
    tt = [a]
    tArr = tArr+tt
    cnt+=1
for i in range(len(tArr)):
    if i+1<len(tArr) :
        gap = tArr[i+1] - tArr[i]
        print("%.2f" % gap)