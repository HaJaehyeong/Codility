import java.util.*;

class Solution {
	
	private List<Integer> list;
	
	// コンストラクタ
	Solution () {
		this.list = new ArrayList<Integer>();
	}
	
	// メソッド
	public int solution(int[] A) {
		for (int i = 0 ; i < A.length ; i++) {
			// 正数だけ入れる
			if (A[i] > 0) {
				this.list.add(A[i]);
			} 
		}		
		
		// ゼロあるいは負数しかなければ
		if (this.list.isEmpty()) {
			// ないと最高の正数は１
			return 1;
		}
		
		// 重複除去
		HashSet<Integer> distinctList = new HashSet<Integer>(list);
        	list = new ArrayList<Integer>(distinctList);
        
        	// ソート、昇順
		Ascending ascending = new Ascending();
        	Collections.sort(list, ascending);

        	// ない数探し
		for (int i = 0 ; i < this.list.size() ; i++) {
			if (this.list.get(i) != i+1) {
				return i+1;			
			} else if (i == this.list.size()-1) {
				return i+2;
			} else {
				continue;
			}
		}
		
		return 0;
		
	}
}

// ソート、昇順
class Ascending implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}

class TEST {
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		// テスト
		int[] A = new int[7];
		A[0] = -1;
		A[1] = 0;
		A[2] = 1;
		A[3] = 2;
		A[4] = 5;
		A[5] = 6;
		A[6] = 7;
		
		System.out.println(s.solution(A));
		
	}
}
