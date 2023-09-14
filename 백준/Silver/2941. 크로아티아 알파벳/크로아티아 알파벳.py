cro_alpha = input()
chk_list = ['c=','c-','d-','lj','nj','s=','z=']
cnt = 0
for j in range(len(cro_alpha)) :
    for i in chk_list :
        if i in cro_alpha :
            if i == 'z=' :
                idx = cro_alpha.find(i)
                if cro_alpha[idx-1] == 'd' :
                    cro_alpha = cro_alpha[:idx-1]+'*'+cro_alpha[idx+2:]
                    cnt+=1
                else :
                    cro_alpha = cro_alpha[:idx]+'*'+cro_alpha[idx+2:]
                    cnt+=1
            else : 
                idx = cro_alpha.find(i)
                cro_alpha = cro_alpha[:idx]+'*'+cro_alpha[idx+2:]
                cnt+=1
print(cnt+len(cro_alpha)-cro_alpha.count('*'))