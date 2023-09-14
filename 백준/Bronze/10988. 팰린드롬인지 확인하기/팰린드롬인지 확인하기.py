word = input()
re_word = ""
for i in range(len(word)):
    re_word+=word[-(i+1)]
print(int(word == re_word))