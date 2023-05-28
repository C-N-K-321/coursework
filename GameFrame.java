package testfile;

//import com.example.model.GamePlayer;  

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

//import static javafx.application.Platform.exit;

public class GameFrame extends JFrame{
	JButton type_1;
	JButton type_2;
	JButton type_3;
	JButton type_4;
	ImageIcon img = new ImageIcon("src/ui/chessBoard.jpg");
    ImageIcon Type1_icon_t = new ImageIcon("src/ui/pieceType1.png");
    Image Type1_img_t = Type1_icon_t.getImage();
    Image Type1_img = Type1_img_t.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    ImageIcon Type1_icon = new ImageIcon(Type1_img);
    
    ImageIcon Type2_icon_t = new ImageIcon("src/ui/pieceType2.png");
    Image Type2_img_t = Type2_icon_t.getImage();
    Image Type2_img = Type2_img_t.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    ImageIcon Type2_icon = new ImageIcon(Type2_img);
    
    ImageIcon Type3_icon_t = new ImageIcon("src/ui/pieceType3.png");
    Image Type3_img_t = Type3_icon_t.getImage();
    Image Type3_img = Type3_img_t.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    ImageIcon Type3_icon = new ImageIcon(Type3_img);
    
    
//    ImageIcon Type1_icon_t = new ImageIcon("src/ui/pieceType1.png");
//    Image Type1_img_t = Type1_icon_t.getImage();
//    Image Type1_img = Type1_img_t.getScaledInstance(65,65,Image.SCALE_DEFAULT);
//    ImageIcon Type1_icon = new ImageIcon(Type1_img_t);
    static JButton whichButton;
    JPanel chessboard;
    Image chessBoard_img;
    ArrayList<Point> points = new ArrayList<>();
    boolean showimage;
    public Timer timer;
    static int xPosition;
    static int yPosition;
    static boolean click =false;
    
    
    public GameFrame() {
    	Action ActionListen = new Action(chessboard,this);
    	MyButtonClicker ButtomListen = new MyButtonClicker();
    	addMouseMotionListener(new MyMouseListener());
    	addMouseListener(new MyMouseClicker());
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
        type_1 = new JButton(Type1_icon);
        type_2 = new JButton(Type2_icon);
        type_3 = new JButton(Type3_icon);
//        type_4 = new JButton(Type4_icon);
        type_1.setBounds(600,200,50,50);
        type_1.setBackground(Color.white);
        type_1.setOpaque(false);
        type_1.setBorderPainted(false);
        type_2.setBounds(600,260,50,50);
        type_2.setBackground(Color.white);
        type_2.setOpaque(false);
        type_2.setBorderPainted(false);
        type_3.setBounds(600,320,50,50);
        type_3.setBackground(Color.white);
        type_3.setOpaque(false);
        type_3.setBorderPainted(false);
//        type_4.setBounds(600,380,50,50);
        type_1.addActionListener(ActionListen);
        type_1.addMouseListener(ButtomListen);
        add(type_1);
        type_2.addActionListener(ActionListen);
        type_2.addMouseListener(ButtomListen);
        add(type_2);
        type_3.addActionListener(ActionListen);
        type_3.addMouseListener(ButtomListen);
        add(type_3);
//        type_4.addActionListener(new Action(chessboard,this));
//        add(type_4);
        
        
        
        
      
        mp.setBounds(0,0,400,400);
        ImageIcon img = new ImageIcon("src/ui/chessBoard.jpg");
        Image temp_img = img.getImage();
        ImageIcon final_img = new ImageIcon(temp_img.getScaledInstance(250,250,Image.SCALE_DEFAULT));    
        chessBoard_img = final_img.getImage();
        JLabel mppicture = new JLabel(final_img);
        mppicture.setBounds(0,0,300,300);
        //mp.add(mppicture);
        
        
        
        
        JButton[][] MB = new JButton[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
            	MB[i][j] = new JButton(); 
            	(MB[i][j]).setBounds(25 + j * 63, 25 + i * 62,65,65);
                MB[i][j].setOpaque(false);
               //mp.add(MB[i][j]);
            	MB[i][j].setRolloverIcon(null);
            	MB[i][j].setContentAreaFilled(false);
                MB[i][j].setBorderPainted(false);      
                (MB[i][j]).addActionListener(new ActionListener(){
                	public void actionPerformed(ActionEvent e)
                	{
                		((JButton)e.getSource()).setIcon(Type1_icon);
                	}
                });
                (MB[i][j]).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                    	((JButton)e.getSource()).setContentAreaFilled(false);
                    }
                });     
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
       add(mp);
    }
    public void paint(Graphics g) {
    	    super.paint(g);
    	    g.drawImage(chessBoard_img,0,0,null);
    	    if(whichButton == type_1)
            g.drawImage(Type1_img,xPosition-30,yPosition-30,null);
    	    else if(whichButton == type_2)
    	    g.drawImage(Type2_img,xPosition-30,yPosition-30,null);
    	    else if(whichButton == type_3)
        	g.drawImage(Type3_img,xPosition-30,yPosition-30,null);
            
    }
//    //添加一个点到界面上
//    public void addPaint(Point point){
//        points.add(point);
//
//    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameFrame().setVisible(true));
        System.out.print("hello");
    }
}

  class MyMouseClicker extends MouseAdapter{
	  public void mouseClicked (MouseEvent e) {
	    	System.out.printf("成功");
	    	GameFrame.click = !(GameFrame.click);
	    }
  }
  class MyButtonClicker extends MouseAdapter{
	  public void mouseClicked (MouseEvent e) {
		  GameFrame.whichButton = (JButton)e.getSource();
		  System.out.print(GameFrame.whichButton);
	    }
  }
   class MyMouseListener extends MouseMotionAdapter{
    public void mouseMoved(MouseEvent e) {
    	if(GameFrame.click = true)
    	{
    	GameFrame.xPosition = e.getX();
    	GameFrame.yPosition = e.getY();
    	}
    }
//    public void mouseExited(MouseEvent e)
//    {
//    	GameFrame.click = false;
//    }
}
   class Action implements ActionListener{
	    JPanel _panel;
		JFrame _frame;
		Timer timer =new Timer(40,this);
		public Action(JPanel p, JFrame f)
		{
			_panel = p;
			_frame = f;
		}
	   @Override
	   public void actionPerformed(ActionEvent e)
	   {
	    	System.out.print(GameFrame.click);
		   if (GameFrame.click)
		   {
	    	if(GameFrame.xPosition > 0)
	    	{
	    		_frame.repaint();
	    	}
	    	else
	    	{
	    		//_panel.repaint();
	    	}
	    	timer.start();   
	    	}
	   }
   }
//////////////////////////////////////////////////////////////////////
   class chessBoard extends JPanel
   {
	   public chessBoard()
	   {
		  // this.add
	   }
   }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//        GameFrame frame = (GameFrame) e.getSource();//作用：拿到窗口   （点击时会在界面上产生一个点）
//        //这个点就是鼠标的点
//        frame.addPaint(new Point(e.getX(),e.getY()));
//        
//        //每次点击鼠标都需要重画一遍
//        frame.repaint();//刷新
//    	}
//  }
//}

//}




