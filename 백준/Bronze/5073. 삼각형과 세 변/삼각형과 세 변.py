while True:
    a1, a2, a3 = map(int, input().split())
    if a1 > 0 and a2 > 0 and a3 > 0:
        if a1==a2==a3 :
            print('Equilateral')
        else : 
            a = [a1,a2,a3]
            max_a = 0 # 가장 긴변 구하기
            for i in a:
                if max_a<i:
                    max_a = i
            now_sum = 0 # 가장 긴변을 제외한 변들의 합 구하기
            long_cnt = 0 # 가장 긴변을 제외한 개수
            for i in a:
                if i != max_a:
                    now_sum+=i
                    long_cnt+=1
            if now_sum>max_a :
                if a1==a2 or a1==a3 or a2==a3 :
                    print('Isosceles')
                else :
                    print('Scalene')
            else :
                if long_cnt == 1 :
                    print('Isosceles')
                else :
                    print('Invalid')
    elif a1 == 0 and a2 == 0 and a3 == 0 :
        break;

