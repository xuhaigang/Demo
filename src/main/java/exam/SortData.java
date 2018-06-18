package exam;

public class SortData {

	public static String doSort(String data) {
		char[] chars = data.toCharArray();
		String result = quickSort(chars, 0, chars.length - 1);
		return result;
	}

	/**
	 *
	 * @author xuhaigang
	 * @creatTime 2018年06月18日15:12
	 * @param a
	 * @param start
	 * @param end
	 * @return java.lang.String
	 *
	 */
	public static String quickSort(char[] a, int start, int end){

		if(start < end){
			int baseNum = a[start];//选基准值
			char midNum;//记录中间值
			int i = start;
			int j = end;
			do{
				while((a[i] < baseNum) && i < end){
					i++;
				}
				while((a[j] > baseNum) && j > start){
					j--;
				}
				if(i <= j){
					midNum = a[i];
					a[i] = a[j];
					a[j] = midNum;
					i++;
					j--;
				}
			} while(i <= j);

			if(start < j){
				quickSort(a, start, j);
			}
			if(end > i){
				quickSort(a, i, end);
			}
		}
		return new String(a);
	}

}
