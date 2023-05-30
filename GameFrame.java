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

	static JLabel[][] piece = new JLabel[4][4];
	static GameElement element;
	static public JButton type_1;
	static public JButton type_2;
	static public JButton type_3;
	static public JButton type_4;
	static boolean select = true;
	static ImageIcon img = new ImageIcon("src/ui/chessBoard.jpg");
	static ImageIcon Type1_icon_t = new ImageIcon("src/ui/pieceType1.png");
    static Image Type1_img_t = Type1_icon_t.getImage();
    static Image Type1_img = Type1_img_t.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    static ImageIcon Type1_icon = new ImageIcon(Type1_img);
    
    static ImageIcon Type2_icon_t = new ImageIcon("src/ui/pieceType2.png");
    static Image Type2_img_t = Type2_icon_t.getImage();
    static Image Type2_img = Type2_img_t.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    static ImageIcon Type2_icon = new ImageIcon(Type2_img);
    
    static ImageIcon Type3_icon_t = new ImageIcon("src/ui/pieceType3.png");
    static Image Type3_img_t = Type3_icon_t.getImage();
    static Image Type3_img = Type3_img_t.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    static ImageIcon Type3_icon = new ImageIcon(Type3_img);
    static JButton whichButton;
    JPanel chessboard;
    static Image chessBoard_img;
    ArrayList<Point> points = new ArrayList<>();
    boolean showimage;
    
    static int xPosition;
    static int yPosition;
    static boolean click =true;
    chessBoard mp = new chessBoard();
    static Boolean ttyy = true;
   
    chessBoard Board = new chessBoard();
    
    
    
    class MyButtonClicker extends MouseAdapter implements ActionListener{
  	  JLabel ttyy;
  	  chessBoard f;
  	  Timer timer;
  	  GameMap map;
  	  public MyButtonClicker(chessBoard f)
  	  {
  		  this.f = f;
  		 timer =new Timer(40,(ActionListener)this);
  		  GameFrame.type_1.addActionListener(this);
  		  GameFrame.type_2.addActionListener(this);
  		  GameFrame.type_3.addActionListener(this);

  	  }
  	@Override
  	public void actionPerformed(ActionEvent e) {
  		  if(yPosition < 210)
  		  {
  			  GameFrame.element = new GameElement(GameFrame.Type1_icon);
  		  }
  		  if(yPosition > 250&&yPosition < 300)
  		  {
  			  GameFrame.element = new GameElement(GameFrame.Type2_icon);
  		  }
  		  if(yPosition > 300 &&yPosition < 320)
  		  {
  			  GameFrame.element = new GameElement(GameFrame.Type3_icon);
  		  }
  		  
  		  {
  		  if(select == true)
  			  if(GameFrame.element != null)
  		  ttyy = new JLabel(GameFrame.element.type_img);
  		  f.add(ttyy);
  		  select = false;
  		  }
  	      if(ttyy!=null)
  		  ttyy.setBounds(GameFrame.xPosition,GameFrame.yPosition,50,50);
  		  f.setVisible(true);
  		  f.revalidate();
  		  f.repaint();
  		  timer.start();
  		  System.out.print("执行");
  		  if(GameFrame.click == false)
  		  {
  			  timer.stop();
  			  select = true;
  			  GameFrame.click = true;
  		  }		  
  		  }
  	  }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public GameFrame(GameMap map) {
     	
    	Board.setBounds(0, 0, 800, 800);
    	Board.addMouseMotionListener(new MyMouseListener());
    	Board.addMouseListener(new MyMouseClicker(this,map,mp));
    	Board.setLayout(null);
    	Board.setOpaque(false);
    	add(Board);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,800,800);
        JLabel TRY = new JLabel(Type1_icon);
        TRY.setBounds(50, 50, 100, 100);
//        add(TRY);
//        TRY.revalidate();
//        TRY.repaint();
        mp.setLayout(null);
        
        type_1 = new JButton(Type1_icon);
        type_2 = new JButton(Type2_icon);
        type_3 = new JButton(Type3_icon);
        type_1.setBounds(600,200,40,40);
        type_1.setBackground(Color.white);
        type_1.setOpaque(false);
        type_1.setBorderPainted(false);
        type_2.setBounds(600,260,40,40);
        type_2.setBackground(Color.white);
        type_2.setOpaque(false);
        type_2.setBorderPainted(false);
        type_3.setBounds(600,320,40,40);
        type_3.setBackground(Color.white);
        type_3.setOpaque(false);
        type_3.setBorderPainted(false);
        MyButtonClicker ButtomListen = new MyButtonClicker(Board);
        type_1.addMouseListener(ButtomListen);
  //      type_1.addActionListener(ActionListen);
        Board.add(type_1);
        type_2.addMouseListener(ButtomListen);
    //    type_2.addActionListener(ActionListen);
        Board.add(type_2);
        type_3.addMouseListener(ButtomListen);
    //    type_3.addActionListener(ActionListen);
        Board.add(type_3);
        mp.setBounds(0,0,400,400);
        ImageIcon img = new ImageIcon("src/ui/chessBoard.jpg");
        Image temp_img = img.getImage();
        ImageIcon final_img = new ImageIcon(temp_img.getScaledInstance(200,200,Image.SCALE_DEFAULT));    
        chessBoard_img = final_img.getImage();
        JLabel mppicture = new JLabel(final_img);
         mppicture.setBounds(0,0,600,600);        
       //add(mp);
        add(mppicture);
    }
    public static void main(String[] args) {
    	//GameMap gamemap = new GameMap();
       // SwingUtilities.invokeLater(() -> new GameFrame(gamemap).setVisible(true));
        System.out.print("hello");
        GameMap gamemap = new GameMap();
        GameFrame a = new GameFrame(gamemap);
        a.setVisible(true);
        
    }
//    public void paint(Graphics g) 
//	  {
//	    super.paint(g);
//	    g.drawImage(GameFrame.chessBoard_img,0,0,null);
//  }
}

  class MyMouseClicker extends MouseAdapter{
	   GameMap map;
	   GameFrame _frame;
	   chessBoard panel;
		public MyMouseClicker(GameFrame _frame, GameMap map,chessBoard panel)
		{
			this._frame = _frame;
			this.map = map;
			this.panel = panel;
		}
	  public void mouseClicked (MouseEvent e) {
		      GameFrame.click = false;
	    	 if(GameFrame.click == false && GameFrame.xPosition < 300)
			   {
	    		 
				   int x = (int)(GameFrame.xPosition / 62.5);
				   int y = (int)(GameFrame.yPosition / 62.5);
//				       (map.getMap())[x][y] = GameFrame.element;
//				    	   if (GameFrame.piece[x][y] != null)
//					   {
//				    		System.out.print("移除");
//						   _frame.remove(GameFrame.piece[x][y]);
//						   GameFrame.piece[x][y].revalidate();
//						   
//						   GameFrame.piece[x][y] = null;
//					   }
				   
	    }
	  }
  }
 
	
	  
  
   class MyMouseListener extends MouseMotionAdapter{
    public void mouseMoved(MouseEvent e) {
    	{
    	GameFrame.xPosition = e.getX();
    	GameFrame.yPosition = e.getY();
    	}
    }
}
  
	
	  
	   
		  
	   
//   public void set(GameFrame a) {
//	    if(GameFrame.whichButton == GameFrame.type_1)
//	    {
//	    this.type_img = GameFrame.Type1_icon;
//	    }
//	    if(GameFrame.whichButton == GameFrame.type_2)
//	    {
//	    this.type_img = GameFrame.Type2_icon;
//	    }
//	    if(GameFrame.whichButton == GameFrame.type_3)
//	    {
//	    this.type_img = GameFrame.Type3_icon;
//	    }
//	   
 	   
	   
	   
   
   class chessBoard extends JPanel
   {
//   public void paintComponent(Graphics g) 
//	  {
//	    super.paintComponent(g);
//	  //  g.drawImage(GameFrame.chessBoard_img,0,0,null);
//	   if(GameFrame.whichButton == GameFrame.type_1)
//          g.drawImage(GameFrame.Type1_img,GameFrame.xPosition-30,GameFrame.yPosition-30,null);
//  	    else if(GameFrame.whichButton == GameFrame.type_2)
//  	    g.drawImage(GameFrame.Type2_img,GameFrame.xPosition-30,GameFrame.yPosition-30,null);
//  	    else if(GameFrame.whichButton == GameFrame.type_3)
//      	g.drawImage(GameFrame.Type3_img,GameFrame.xPosition-30,GameFrame.yPosition-30,null);
//    }
   }
   
   
