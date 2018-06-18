package exam;

public class ReadFileThread extends Thread{

	/** 读取文件内容 */
	private String data;

	private String result;

	private String name;

	public ReadFileThread(String data, String name) {

		this.data = data;
		this.name = name;
	}


	@Override
	public void run() {
		result = SortData.doSort(data);
		System.out.println(name+result);
	}

	public String getResult() {
		return result;
	}
}
