package testfile;
//import com.example.model.GamePlayer;  
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.*;
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
    static boolean put = false;
    static int xPosition;
    static int yPosition;
    static boolean click =false;
    chessBoard mp = new chessBoard();
    static Boolean ttyy = true;
    static int x;
    static int y; 
    chessBoard Board = new chessBoard();
    GameMap map;
    JLabel[][] Label_map = new JLabel[4][4];
    
    
    class MyButtonClicker extends MouseAdapter implements ActionListener{
  	  JLabel ttyy;
  	  chessBoard f;
  	  Timer timer;
  	  GameMap map;
  	  public MyButtonClicker(chessBoard f)
  	  {
  		  this.f = f;
  		  timer = new Timer(40,this);
  		  GameFrame.type_1.addActionListener(this);
  		  GameFrame.type_2.addActionListener(this);
  		  GameFrame.type_3.addActionListener(this);

  	  }
  	@Override
  	public void mouseEntered(MouseEvent e) {
  		  if(e.getSource() == type_1 )
  		  {
  			  GameFrame.element = new GameElement(GameFrame.Type1_icon);
  		  }
  		  if(e.getSource() == type_2)
  		  {
  			  GameFrame.element = new GameElement(GameFrame.Type2_icon);
  		  }
  		  if(e.getSource() == type_3)
  		  {
  			  GameFrame.element = new GameElement(GameFrame.Type3_icon);
  		  }
  		  
  	}
  	public void actionPerformed(ActionEvent e)
  		{
  		  timer.start();
  		  put = false;
  		  if(select == true)
  		  {	  
  		  if(GameFrame.element != null)
  		  ttyy = new JLabel(GameFrame.element.type_img);
  		  f.add(ttyy);
  		  System.out.print(f.getComponentCount());
  		  select = false;
  		  }
  	    //  if(ttyy!=null)
  		  ttyy.setBounds(GameFrame.xPosition,GameFrame.yPosition,50,50);
  		  f.setVisible(true);
  		  f.revalidate();
  		  f.repaint();
  		 
  		  if(GameFrame.click == true)
  		  {
  			  select = true;
  			  GameFrame.click = false;
  			  timer.stop();
  			  put(ttyy);
  		  }		
  		}
    }
  	
    class MyMouseListener extends MouseMotionAdapter{
        public void mouseMoved(MouseEvent e) {
        	{
        	GameFrame.xPosition = e.getX();
        	x = (int)(GameFrame.xPosition / 62.5);
        	GameFrame.yPosition = e.getY();
        	y = (int)(GameFrame.yPosition / 62.5);
        	}
        }
    }
    
    
    
    class MyMouseClicker extends MouseAdapter{
 	   GameMap map;
 	   GameFrame _frame;
 		public MyMouseClicker(GameFrame _frame, GameMap mapl)
 		{
 			this._frame = _frame;
 			this.map = map;

 		}
 	  public void mouseClicked (MouseEvent e) {
 		     if(put == false)
 		     {
 		      GameFrame.click = true;
 		     }
 	    	 if(put == true)
 			   {
 	    		System.out.print("执行");
 				 if (Label_map[x][y] != null)
 			   {
 				  System.out.print(Board.getComponentCount());
 				  Board.remove(Label_map[x][y]);
 				 System.out.print(Board.getComponentCount());
 				  GameFrame.piece[x][y] = null;
 				  Label_map[x][y] = null;
 				  Board.revalidate();
				  Board.repaint();
				  _frame.repaint();
 			   }
 			   }
 	  }
    }
    
    
    
    
    
    
    
    public GameFrame(GameMap map) {
     	this.map = map;
    	Board.setBounds(0, 0, 800, 800);
    	Board.addMouseMotionListener(new MyMouseListener());
    	Board.addMouseListener(new MyMouseClicker(this,map));
    	Board.setLayout(null);
    	Board.setOpaque(false);
    	add(Board);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,800,800);
        JLabel TRY = new JLabel(Type1_icon);
        TRY.setBounds(50, 50, 100, 100);
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
//        type_1.addActionListener(ActionListen);
        Board.add(type_1);
        type_2.addMouseListener(ButtomListen);
//        type_2.addActionListener(ActionListen);
        Board.add(type_2);
        type_3.addMouseListener(ButtomListen);
//        type_3.addActionListener(ActionListen);
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
    public void put(JLabel ttyy)
    {
    	(map.getMap())[x][y] = element;
    	 put = true;
    	 Label_map[x][y] = ttyy;
    	 System.out.print("执行");
    }
}
    
    
 
 	   
	   
	   
   
   class chessBoard extends JPanel
   {
//   
	  ;
   }
   
   