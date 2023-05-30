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
	ImageIcon[][] Type_icon_t = new ImageIcon[4][9];
	Image[][] Type_img_t = new Image[4][9];
	Image[][] Type_img = new Image[4][9];
	ImageIcon[][] Type_icon = new ImageIcon[4][9];
	static boolean select = true;
	static ImageIcon img = new ImageIcon("src/ui/chessBoard.jpg");
	static ImageIcon Type1_icon_t = new ImageIcon("src/ui/pieceType1.png");
    static Image Type1_img_t = Type1_icon_t.getImage();
    static Image Type1_img = Type1_img_t.getScaledInstance(130,130,Image.SCALE_SMOOTH);
    static ImageIcon Type1_icon = new ImageIcon(Type1_img);
    
    
    
    static ImageIcon Type2_icon_t = new ImageIcon("src/ui/pieceType2.png");
    static Image Type2_img_t = Type2_icon_t.getImage();
    static Image Type2_img = Type2_img_t.getScaledInstance(120,120,Image.SCALE_SMOOTH);
    static ImageIcon Type2_icon = new ImageIcon(Type2_img);
    
    static ImageIcon Type3_icon_t = new ImageIcon("src/ui/pieceType3.png");
    static Image Type3_img_t = Type3_icon_t.getImage();
    static Image Type3_img = Type3_img_t.getScaledInstance(120,120,Image.SCALE_SMOOTH);
    static ImageIcon Type3_icon = new ImageIcon(Type3_img);
    static JButton whichButton;
    static Image chessBoard_img;
    static boolean put = false;
    static int xPosition;
    static int yPosition;
    static boolean click =false;
    chessBoard mp = new chessBoard();
    JLabel ttyy;
    static int x;
    static int y; 
    chessBoard Board = new chessBoard();
    GameMap map;
    JLabel[][] Label_map = new JLabel[4][4];
    
    class MyButtonClicker extends MouseAdapter implements ActionListener{
  	  
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
  			  GameFrame.element = new GameElement(Type_icon[1]);
  		  }
  		  if(e.getSource() == type_2)
  		  {
  			  GameFrame.element = new GameElement(Type_icon[2]);
  		  }
  		  if(e.getSource() == type_3)
  		  {
  			  GameFrame.element = new GameElement(Type_icon[3]);
  		  }
  		  
  	}
  	public void actionPerformed(ActionEvent e)
  		{
  		  timer.start();
  		  put = false;
  		  if(select == true)
  		  {	  
  		  if(GameFrame.element != null)
 
  		  ttyy = new JLabel(GameFrame.element.type_img[1]);
  		  f.add(ttyy);
  		  System.out.print(f.getComponentCount());
  		  select = false;
  		  System.out.print("hhhh");
  		  }
  	    //  if(ttyy!=null)
  		  ttyy.setBounds(GameFrame.xPosition - 60,GameFrame.yPosition-60,130,130);
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
        	x = (int)((GameFrame.xPosition-20)/150);
        	GameFrame.yPosition = e.getY();
        	y = (int)((GameFrame.yPosition-50)/150);
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
    
    public class MyKeyListener implements KeyListener {
        
        @Override
        public void keyTyped(KeyEvent e) {
//        	element.setDir(((element.getDir()+1)%8));
//    		ttyy.setIcon(new ImageIcon("src/ui/pieceType2_dir2.png"));
        }

        @Override
        public void keyPressed(KeyEvent e) {
//        	element.setDir(((element.getDir()+1)%8));
//    		ttyy.setIcon(new ImageIcon("src/ui/pieceType2_dir2.png"));
        }

        @Override
        public void keyReleased(KeyEvent e) {
        	System.out.print("啦啦啦");
        	if(ttyy!=null)
        	{
            element.setDir(((element.getDir()+1)%8));
    		ttyy.setIcon(element.type_img[element.getDir()]);
        	}
        }
    }
    


    
    public GameFrame(GameMap map) {
    	for(int i=1;i<4;i++)
    	{
    		for(int j=1;j<9;j++)
    		{
    			Type_icon_t[i][j] = new ImageIcon("src/ui/pieceType"+i+"_dir"+j+".png");
    			Type_img_t[i][j] = Type_icon_t[i][j].getImage();
    			Type_img[i][j] = Type_img_t[i][j].getScaledInstance(130,130,Image.SCALE_SMOOTH);
    			Type_icon[i][j] = new ImageIcon(Type_img[i][j]);
    		}
    	}    	
     	this.map = map;
    	Board.setBounds(0,0,800,800);
    	Board.addMouseMotionListener(new MyMouseListener());
    	Board.addMouseListener(new MyMouseClicker(this,map));
    	Board.setLayout(null);
    	Board.setOpaque(false);
    	
    	add(Board);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,800,800);
        JLabel TRY = new JLabel(Type1_icon);
        mp.setLayout(null);
        
        type_1 = new JButton(Type_icon[1][1]);
        type_2 = new JButton(Type_icon[2][1]);
        type_3 = new JButton(Type_icon[3][1]);
        type_1.setBounds(600,120,100,100);
        type_1.setBackground(Color.white);
        type_1.setOpaque(false);
        type_1.setBorderPainted(false);
        type_2.setBounds(600,280,100,100);
        type_2.setBackground(Color.white);
        type_2.setOpaque(false);
        type_2.setBorderPainted(false);
        type_3.setBounds(600,440,100,100);
        type_3.setBackground(Color.white);
        type_3.setOpaque(false);
        type_3.setBorderPainted(false);
        MyButtonClicker ButtomListen = new MyButtonClicker(Board);
        type_1.setFocusable(true);
        type_1.requestFocus();
    	type_1.addKeyListener(new MyKeyListener());
    	type_2.setFocusable(true);
        type_2.requestFocus();
    	type_2.addKeyListener(new MyKeyListener());
    	type_3.setFocusable(true);
        type_3.requestFocus();
    	type_3.addKeyListener(new MyKeyListener());
  
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
        ImageIcon final_img = new ImageIcon(temp_img.getScaledInstance(600,600,Image.SCALE_DEFAULT));    
        chessBoard_img = final_img.getImage();
        JLabel mppicture = new JLabel(final_img);
         mppicture.setBounds(0,50,600,600);        
       //add(mp);
        add(mppicture);
    }
    public static void main(String[] args) {
    	//GameMap gamemap = new GameMap();
       // SwingUtilities.invokeLater(() -> new GameFrame(gamemap).setVisible(true));
        System.out.print("hello");
        GameMap gamemap = new GameMap();
        GameFrame a = new GameFrame(gamemap);
        a.setLocationRelativeTo(null);
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

//    class Piece_Label extends JPanel
//   {
//	   int direction;
//	   
//   }
//   
   
   
//   public  static class ObjectRotationExample extends Application {
//       private static final int ROTATION_ANGLE = 45; // 旋转角度
//       int currentIndex = 0;
//       @Override
//       public void start(Stage primaryStage) {
//           Group root = new Group();
//           Scene scene = new Scene(root, 400, 400, Color.WHITE);
//
//           Image image = new Image("file:src/text001a/sources/images/Type1.png");
//           ImageView object = new ImageView(image);
//           object.setTranslateX(175);
//           object.setTranslateY(175);
//           root.getChildren().add(object);
//
//           RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.5), object);
//           rotateTransition.setByAngle(ROTATION_ANGLE);
//
//           scene.setOnKeyPressed(event -> {
//               if (event.getCode() == KeyCode.SPACE) {
//                   rotateTransition.playFromStart(); // 从开始位置播放动画
//                    currentIndex++;
//               }
//           });
//
//           primaryStage.setTitle("Object Rotation Example");
//           primaryStage.setScene(scene);
//           primaryStage.show();
//       }
//
//       public static void main(String[] args) {
//       launch(args);
//   }
//}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   