import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rank {
	JFrame jf = new JFrame();
	GameStart gs;
	JLabel[] jLabels;
	int j = 4;
	public Rank() {
		jf.setLayout(null);
		addshow();
		FrameCommon.initFrame(jf, "排行榜", 300, 400);
	}
	//将分数以及玩家姓名写入到txt文件中
	public void write(GameStart gs){
		this.gs = gs;
		int score = gs.getScore();
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter("Rank.txt",true));
			bw.write(score + "\r\n");	
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//读取文件
	public void read(){
		List<Integer> list = new ArrayList<Integer>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("Rank.txt"));
			String s;
			while((s = br.readLine()) != null){
				int score = Integer.parseInt(s);
				list.add(score);
			}
			Collections.sort(list);
			for (int i = list.size()-1; i > list.size()-6; i--) {
				jLabels[j-3].setText("第" + (j-3) + "名：" + list.get(i));
				j++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//排行榜界面
	public void addshow() {
		jLabels = new JLabel[5];
		for (int i = 0; i < jLabels.length; i++) {
			jLabels[i] = new JLabel();
			jLabels[i].setSize(300, 50);
			jf.add(jLabels[i]);
		}
		jLabels[0].setLocation(0, 50);
		jLabels[1].setLocation(0, 100);
		jLabels[2].setLocation(0, 150);
		jLabels[3].setLocation(0, 200);
		jLabels[4].setLocation(0, 250);
	}
}
