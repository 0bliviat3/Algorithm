ches_list = [1,1,2,2,2,8]
now_list = list(map(int,input().split()))
need = ""
for i in range(6):
    need+=str(ches_list[i]-now_list[i])
    need+=' '
print(need)