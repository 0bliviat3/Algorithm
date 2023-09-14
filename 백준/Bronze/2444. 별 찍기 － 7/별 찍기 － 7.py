n = int(input())
for i in range(1,2*n):
    print(' '*abs(n-i),end='')
    if i <= n :
        print('*'*(i*2-1))
    else :
        print('*'*((2*n-i)*2-1))