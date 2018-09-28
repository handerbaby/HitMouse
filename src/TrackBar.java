import javax.swing.JFrame;
import javax.swing.JSlider;

public class TrackBar extends JFrame{
	private JSlider js;
	public void addJSlider(){
		js = new JSlider();
		js.setBounds(0,30,280,50);
		js.setPaintTicks(true);//设置滑块绘制刻度标记  
        js.setPaintLabels(true); //设置主刻度标记的状态  
        js.setMajorTickSpacing(10);//设置主刻度标记的间隔  
        js.setMinorTickSpacing(2);//设置副刻度标记的间隔 
		js.setValue ((int)js.getValue());
		this.getContentPane().add(js);
	}

	public long getValue(){
		return js.getValue();
	}

	public TrackBar(){
		setLayout(null);
		addJSlider();
		setTitle("难度");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(230,340,300,130);
		//setVisible(true);
	}

	public static void main(String[] args){
		TrackBar tb = new TrackBar();
	}
}