package testfile;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
//import static javafx.application.Platform.exit;

public class GameFrame extends JFrame{
//    Color[] colors = {Color.white, Color.blue, Color.green, Color.yellow, Color.red};           // 这个就是测试用你后面要把它替换成贴图文件
//    int[][] map = {{1, 2, 3, 4}, {2, 3, 4, 1}, {3, 4, 1, 2}, {4, 1, 2, 3}};                     // 这个要换成GameMap里的map
//    int[][] rsv = {{3, 4}, {1, 2}};  // 同上
	
    ImageIcon Type1_icon = new ImageIcon("src/ui/pieceType1.png");
    Image Type1_img = Type1_icon.getImage();
    //rsvButton type1 = new rsvButton();
    ImageIcon Type1 = new ImageIcon(Type1_img.getScaledInstance(65,65,Image.SCALE_DEFAULT));
    JPanel selectedPanel = null;
    ArrayList<Point> points = new ArrayList<>();
    boolean showimage;
    public Timer timer;
    public GameFrame() {
    	this.addMouseListener(new MyMouseListener());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,800,800);
//        ((JPanel)this.getContentPane()).setOpaque(false);
//        ImageIcon img = new ImageIcon("src/ui/chessBoard.jpg");
//        Image temp_img = img.getImage();
//        
//        ImageIcon final_img = new ImageIcon(temp_img.getScaledInstance(250,250,Image.SCALE_DEFAULT));
//        JLabel background = new  JLabel(final_img);      
//        this.getLayeredPane().add(background, Integer.MIN_VALUE);
//        background.setBounds(100,100,250,250);
       // setSize(800, 800);
       // setLocationRelativeTo(null);
        JPanel mp = new JPanel(null);
        
        
        
       timer = new Timer(100,new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e)
        	{
        		;
        	}
        });
        
 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      
        mp.setBounds(0,0,500,500);
        ImageIcon img = new ImageIcon("src/ui/chessBoard.jpg");
        Image temp_img = img.getImage();
        ImageIcon final_img = new ImageIcon(temp_img.getScaledInstance(250,250,Image.SCALE_DEFAULT));    
        JLabel mppicture = new JLabel(final_img);
        mppicture.setBounds(0,0,300,300);
        JButton[][] MB = new JButton[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // todo 这里要根据你的Element的Type替换成贴图
            	MB[i][j] = new JButton(); 
                MB[i][j].setOpaque(false);
            	MB[i][j].setRolloverIcon(null);
            	MB[i][j].setContentAreaFilled(false);
                MB[i][j].setBorderPainted(false);
                (MB[i][j]).setBounds(25 + j * 63, 25 + i * 62,65,65);
                (MB[i][j]).addActionListener(new ActionListener(){
                	public void actionPerformed(ActionEvent e)
                	{
                		((JButton)e.getSource()).setIcon(Type1);
                	}
                });
                (MB[i][j]).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                    	((JButton)e.getSource()).setContentAreaFilled(false);
                    }
                });     
                 mp.add(MB[i][j]);
//                panel.addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        if (SwingUtilities.isLeftMouseButton(e)) {
//                            // todo 这里替换成放置动画，添加从rsv到map的逻辑
//                            panel.setBackground(Color.red);
//                        } else if (SwingUtilities.isRightMouseButton(e)) {
//                            // todo 这里替换成移除动画， 添加是否可以移除的判断，添加移动图块到rsv的逻辑
//                            panel.setBackground(Color.black);
//                        }
//                        if (selectedPanel != null) {
//                            // todo 这里是动画结束后的贴图
//                            panel.setBackground(selectedPanel.getBackground());
//                        }
//                    }
//                });
                
            }
        }
        mp.add(mppicture);
        add(mp);
    }        
              

     

       

    private void showSettleWindow() {
        JFrame settleWindow = new JFrame();
        settleWindow.setTitle("结算");
        settleWindow.setSize(200, 200);
        settleWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settleWindow.setLocationRelativeTo(null);

        JLabel textLabel;
        textLabel = new JLabel("你的分数是: " + 0);

        setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));

        JButton settleButton = new JButton("好的");
        settleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settleWindow.dispose();
                dispose();
                // todo 这里添加你想回到的地方或者退出程序
            }
        });
        buttonPanel.add(textLabel);
        buttonPanel.add(settleButton);

        // 将按钮面板添加到小窗口中心
        settleWindow.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        settleWindow.getContentPane().add(buttonPanel);

        // 显示结算窗口
        settleWindow.setVisible(true);
    }

    
    
    public void paint(Graphics g) {
        //画画，监听鼠标的事件
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            Point point = (Point) iterator.next();
            g.setColor(Color.orange);
            g.fillOval(point.x,point.y,10,10);
        }
    }
    //添加一个点到界面上
    public void addPaint(Point point){
        points.add(point);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameFrame().setVisible(true));
    }
}

//import javax.swing.*;
//import java.awt.*;
//
//public class ImageLabelExample {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Image Label Example");
//        frame.setSize(300, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // 加载图片
//        ImageIcon icon = new ImageIcon("image.png");
//        // 转换为Image对象
//        Image image = icon.getImage();
//        // 调整图片大小
//        image = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//        // 转换为Icon对象
//        Icon icon2 = new ImageIcon(image);
//
//        JLabel label = new JLabel();
//        label.setIcon(icon2);
//
//        frame.getContentPane().add(label, BorderLayout.CENTER);
//        frame.setVisible(true);
//    }
//}


//class rsvButton extends JButton{
//	Image ima;
//    private boolean showimage;
//	public void paintComponent(Graphics g,Image ima) {
//	    super.paintComponent(g);
//	    if (showimage) {
//	        // 绘制图片
//	        g.drawImage(ima, getX(), getY(), this);
//	    }
//	}
//	public void setImage(Image ima)
//	{
//		this.ima = ima;
//	}
//	public void setshowimage(boolean b)
//	{
//		this.showimage = b;
//	}
//
//}


//public MyFrame(String title)  {
//    super(title);
//    setBounds(200,200,400,400);
//
//    //存鼠标点击的点
//    
//
//    //鼠标监听器
//   c
//
//    setVisible(true);
//}
//
//@Override
//
//
//
   class MyMouseListener extends MouseAdapter {//Adapter适配器；适配器模式；   MouseAdapter鼠标适配器
    //鼠标的3个基本动作：按下，弹起，按住不放
    @Override
    public void mouseClicked(MouseEvent e) {
    	while(true)
    	{
        GameFrame frame = (GameFrame) e.getSource();//作用：拿到窗口   （点击时会在界面上产生一个点）
        //这个点就是鼠标的点
        frame.addPaint(new Point(e.getX(),e.getY()));
        
        //每次点击鼠标都需要重画一遍
        frame.repaint();//刷新
        frame.timer.start();
    	}
  }
}

//}




