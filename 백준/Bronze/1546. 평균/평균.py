n = int(input())
n_list = list(map(int,input().split()))
m = max(n_list)
for i in range(n):
    n_list[i] = n_list[i]/m*100
avg = sum(n_list)/n
print(avg)