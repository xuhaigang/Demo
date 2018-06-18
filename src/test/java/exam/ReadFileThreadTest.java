package exam;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ReadFileThreadTest {

	public String result = "";
	@Test
	public void testReadFile() {

		File file = new File("in.txt");
		FileInputStream is;
		List<String> list = new ArrayList<String>();
		try {
			is = new FileInputStream(file);
			InputStreamReader streamReader = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(streamReader);
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			reader.close();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		Vector<Thread> threadVector = new Vector<Thread>();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Thread childThread = new ReadFileThread(list.get(i),"第"+ (i+1) +"个线程：");
				threadVector.add(childThread);
				childThread.start();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				result = result+((ReadFileThread) childThread).getResult()+"\n";
			}

			for (Thread thread : threadVector) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			//System.out.println("排序后："+result);

			try {
				File outFile = new File("out.txt");
				PrintStream ps = new PrintStream(new FileOutputStream(outFile));
				ps.println(result);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
