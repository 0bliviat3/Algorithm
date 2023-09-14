public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		int num=0;//generator의 제네레이터
		int temp=0;//자릿수구하는 임의의 변수
		int generator=0;
		int[] allNum=new int[10000];
		//배열값 입력
		for(int i=0;i<allNum.length;i++) {
			allNum[i]=i+1;
		}
		//generator만들기
		for(int i=1;i<=10000;i++) {
			num=i;
			generator=num;//자기자신+
			while(num>0) {
				temp=num%10;
				num/=10;
				generator+=temp;
			}
			//배열에 저장된 값들중 self-number가 아닌경우 0대입
			for(int j=0;j<allNum.length;j++) {
				if(generator==allNum[j]) {
					allNum[j]=0;
				}
			}
		}
		for(int i=0;i<allNum.length;i++) {
			if(allNum[i] != 0) {
				sb.append(allNum[i]+"\n");
			}
		}
		System.out.print(sb);
	}

}