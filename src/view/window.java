package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class window {

	private JFrame frame;
	public void window1() {
		frame = new JFrame();
		frame.setBounds(100, 100, 340, 138);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("查询成功");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
	}
	public void window2() {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("添加成功");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void window3() {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("添加失败");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void window4() {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("删除成功");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void window5() {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("删除失败");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void window6() {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改成功");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public void window7() {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 133);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改失败");
		lblNewLabel.setBounds(126, 33, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}

}
