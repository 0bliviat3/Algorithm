word = input().upper()
word_dic = dict()
for i in word:
    if i not in word_dic:
        word_dic[i] = 1
    else : 
        word_dic[i] += 1
now_max = max(word_dic.values())
word_list = list()
for i in word_dic:
    if word_dic[i] == now_max :
        word_list.append(i)
print(word_list[0] if len(word_list) == 1 else '?')