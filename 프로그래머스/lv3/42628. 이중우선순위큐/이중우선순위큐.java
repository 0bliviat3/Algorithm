class Solution {
    public int[] solution(String[] operations) {
        
        int size = operations.length;
        DualHeap heap = new DualHeap();
        heap.clear(size);
        String[] order;
        int[] answer = new int[2];
        
        for(int i = 0; i < size; i++){
            order = operations[i].split(" ");
            int num = Integer.parseInt(order[1]);
            if(order[0].equals("I")){
                heap.add(num);
            }else{
                if(num > 0){
                    heap.pop(0);
                }else{
                    heap.pop(1);
                }
            }
        }
        
        Integer num1 = heap.pop(0);
		Integer num2 = null;
		if(num1 != null) {
			heap.add(num1);
			num2 = heap.pop(1);				
		}
		if(num1 != null || num2 != null) {
            answer[0] = num1;
            answer[1] = num2;
		}
        
        
        return answer;
    }
}

class MyData { 
	
	// 시퀀스로 데이터마다 유일키를 갖도록 해서 같은 데이터를 구분한다.
	
	int id;
	Integer data;
	
	MyData(int id, Integer data){
		this.id = id;
		this.data = data;
	}
}

abstract class Heap {
	
	private int node;
	
	private MyData[] heap;
	
	public void reset(int k) {
		node = 0;
		heap = new MyData[k + 1];
	}
	
	public boolean isEmpty() {
		if(heap[1] != null) return false;
		return true;
	}
	
	private void exchange(int a, int b) {
		MyData temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	protected abstract boolean compare(MyData p, MyData c);
	protected abstract boolean compare2(MyData p, MyData c);
	
	public void add(int id,int data) {
		heap[++node] = new MyData(id,data);
		for(int i = node; i > 1; i/=2) {
			if(compare(heap[i / 2],heap[i])) {
				exchange(i/2,i);
			}
		}
	}
	
	public MyData getRoot() {
		if(node == 0) return null;
		MyData root = heap[1];
		heap[1] = heap[node];
		heap[node--] = null;
		int now = 1;
		while(now * 2 <= node) {
			int left = now * 2;
			int right = now * 2 + 1;
			if(compare(heap[now],heap[left]) || compare(heap[now],heap[right])) {
				if(compare2(heap[left],heap[right])) {
					exchange(now,left);
					now = left;
				}else {
					exchange(now,right);
					now = right;
				}
			}else {
				break;
			}
		}
		return root;
	}
	
}

class MinHeap extends Heap{

	@Override
	protected boolean compare(MyData p, MyData c) {
		// null은 가장 큰값을 의미 리프노드로 보내야 한다.
		if(p == null) return true; // 부모 또는 왼쪽이 더 큰값인 경우
		if(c == null) return false; // 자식 또는 오른쪽이 더 큰값인 경우
		return p.data > c.data;
	}

	@Override
	protected boolean compare2(MyData p, MyData c) {
		if(p == null) return false; // 부모 또는 왼쪽이 더 큰값인 경우
		if(c == null) return true; // 자식 또는 오른쪽이 더 큰값인 경우
		return p.data < c.data;
	}


	
}

class MaxHeap extends Heap{

	@Override
	protected boolean compare(MyData p, MyData c) {
		// null은 가장 작은 값을 의미 리프노드로 보낸다.
		if(p == null) return true; // 부모 또는 왼쪽이 가장 작은 값인 경우
		if(c == null) return false; // 자식 또는 오른쪽이 가장 작은 값인 경우
		return p.data < c.data;
	}

	@Override
	protected boolean compare2(MyData p, MyData c) {
		if(p == null) return false; // 부모 또는 왼쪽이 가장 작은 값인 경우
		if(c == null) return true; // 자식 또는 오른쪽이 가장 작은 값인 경우
		return p.data > c.data;
	}


	
}


class DualHeap {
	
	private Heap[] heap = {new MaxHeap(), new MinHeap()};
	
	private int sequence;
	private boolean[] idArr;
	
	public void clear(int k) {
		sequence = 0;
		idArr = new boolean[k + 1];
		heap[0].reset(k + 1);
		heap[1].reset(k + 1);
	}
	
	public void add(int data) {
		heap[0].add(sequence, data);
		heap[1].add(sequence, data);
		sequence++;
	}
	
	public Integer pop(int idx) { // 0 이면 max pop , 1이면 min pop
		if(!heap[idx].isEmpty()) {
			MyData data = heap[idx].getRoot();
			while(!heap[idx].isEmpty() && idArr[data.id]) {
				data = heap[idx].getRoot();
			}
			if(!idArr[data.id]) { // 삭제되지 않은 데이터의 경우 방문처리
				idArr[data.id] = true;
				return data.data;
			}
			
		}
		return null;
	}
	
	
}

