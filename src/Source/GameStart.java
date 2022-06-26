import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import javax.swing.AbstractButton;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.util.Random;


public class GameStart extends KeyAdapter implements ActionListener 
{
String playerName[];
int nuop,tmp, tmp1;

boolean pStatus1=false;
boolean pStatus2=false;
boolean pStatus3=false;
boolean pStatus4=false;

boolean pStatusF1=false;
boolean pStatusF2=false;
boolean pStatusF3=false;
boolean pStatusF4=false;

JFrame frame;
JButton []btn,btn1;
JLabel playerNameL[];

JPanel winPanel;
KeyEvent kevt;
ActionEvent aevt;


JButton pasaaShow;
ImageIcon []pasaaIcon,plrStatusImage , btnIcon;

String pl[]={BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.EAST,BorderLayout.WEST,BorderLayout.CENTER};
Color pcolor[]={Color.red,Color.yellow,Color.green,Color.blue,Color.magenta};



int plrIndex[]={101,101,101,101};

int playerStart[] = {6,6,6,6};

int snack[]={4,20,29,43,75};
int snackLoc[]={76,22,48,62,88};

int liftLoc[]={1,15,32,35,56,62,74};
int lift[]={34,37,50,53,78,80,85};

JButton winButton[];


GameStart(int nop,String pon[])
 {

playerName=pon;
nuop=nop;

frame=new JFrame("Developed by Anand Bind");
frame.setBounds(30,0,1015,732);
frame.setLayout(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel panel[]=new JPanel[5];
for(tmp=0;tmp<5;tmp++)
   {
panel[tmp]=new JPanel();
panel[tmp].setBackground(pcolor[tmp]);
if(tmp==0 || tmp==1)
{}
else{
  panel[tmp].setLayout(null);
}
   }

   panel[4].addKeyListener(this);

panel[0].setBounds(0,0,1000,40);
panel[1].setBounds(0,650,1000,40);
panel[2].setBounds(0,40,195,640);
panel[3].setBounds(805,40,195,640);
panel[4].setBounds(200,45,600,600);


pasaaShow = new JButton();  
pasaaShow.setBackground(Color.white);     
pasaaShow.setBorder(null);  
pasaaShow.setBounds(20,410, 150,150);
panel[2].add(pasaaShow);


 


winPanel = new JPanel();  
winPanel.setBackground(Color.white);     
winPanel.setLayout(new GridLayout(2,2));  
winPanel.setBounds(20,30, 150,150);
panel[2].add(winPanel);

Font f2=new Font("Arial",Font.BOLD,25);
winButton=new JButton[playerName.length];
for(tmp=0;tmp<playerName.length;tmp++)   {
winButton[tmp] = new JButton(String.valueOf(tmp+1)); 
winButton[tmp].setEnabled(false); 
winButton[tmp].setFont(f2);
winButton[tmp].setBackground(Color.orange);   
winButton[tmp].setBorder(null); 
winPanel.add(winButton[tmp]);

}



pasaaIcon=new ImageIcon[6];
int tmp2=1;
for(tmp=0;tmp<6;tmp++)
   {
pasaaIcon[tmp]=new ImageIcon(String.valueOf("pasaaImage\\"+ tmp2++ +".png"));
   }


int x1_x21=300;
int y1_y21=5;

Font f1=new Font("Arial",Font.BOLD,25);
playerNameL=new JLabel[playerName.length];
for(tmp=0;tmp<playerName.length;tmp++){
playerNameL[tmp]=new JLabel(playerName[tmp]);
playerNameL[tmp].setFont(f1);
playerNameL[tmp].setBounds(x1_x21 ,y1_y21, 170 ,30);
if(tmp==1)
   {  x1_x21=10;   y1_y21=350;  }
   panel[tmp].add(playerNameL[tmp]);
   }

int x1_x2=485;
int y1_y2=5;

Font f=new Font("Arial",Font.BOLD,23);

btn1=new JButton[playerName.length];
for(tmp=0;tmp<playerName.length;tmp++)   {
btn1[tmp] = new JButton("...... "+String.valueOf(tmp+1)+" ......");  
btn1[tmp].setFont(f);
btn1[tmp].addActionListener(this);
if(tmp==0){
  btn1[tmp].setEnabled(true);
  btn1[tmp].setBackground(Color.magenta);
}
else
  btn1[tmp].setEnabled(false);
btn1[tmp].setBackground(Color.white);   
playerNameL[tmp].setForeground(Color.black);    
btn1[tmp].setBorder(null);  

btn1[tmp].setBounds(x1_x2,y1_y2, 100,30);

if(tmp==1)
    {  x1_x2=30;  
     y1_y2=305;  }
    panel[tmp].add(btn1[tmp]); 

   }


for(tmp=0;tmp<5;tmp++){
frame.add(panel[tmp]);
 }


panel[4].setLayout(new GridLayout(10,10,0,0));


btnIcon= new ImageIcon[100];
int t=100;
for ( tmp =0 ; tmp<100 ; tmp++){
btnIcon[tmp] = new ImageIcon(String.valueOf("newImage\\"+ t-- +".png"));
}


btn=new JButton[100];
int titileb=100;
for(tmp=0;tmp<100;tmp++){
btn[tmp]=new JButton();
btn[tmp].setHorizontalAlignment(SwingConstants.RIGHT);
btn[tmp].setVerticalTextPosition(AbstractButton.NORTH);
btn[tmp].setHorizontalTextPosition(AbstractButton.LEADING);
btn[tmp].setBorder(null);
btn[tmp].setIcon((ImageIcon)btnIcon[tmp]);
panel[4].add(btn[tmp]);
}

    plrStatusImage=new ImageIcon[4];
   
     
      plrStatusImage[0]=new ImageIcon("plr\\1.png");
      plrStatusImage[1]=new ImageIcon("plr\\2.png");
      plrStatusImage[2]=new ImageIcon("plr\\3.png");
      plrStatusImage[3]=new ImageIcon("plr\\4.png");

    


   frame.setVisible(true);

  }

  public void actionPerformed(ActionEvent evt) 
  {
    aevt=evt;
matchplr(evt);


  }



        @Override
        public void keyPressed(KeyEvent evt1) {

            System.out.println("keyPressed");
           


   Random ran = new Random();
    int randomNumber = ran.nextInt(pasaaIcon.length);
    ImageIcon passIconrandom = pasaaIcon[randomNumber];
    pasaaShow.setIcon(passIconrandom);




if(pStatus1){
  btn1[1].setEnabled(true);
  btn1[1].setBackground(Color.magenta);
}

if(pStatus2){
  btn1[2].setEnabled(true);
  btn1[2].setBackground(Color.magenta);
}
if(pStatus3){
  btn1[3].setEnabled(true);
  btn1[3].setBackground(Color.magenta);
}
if(pStatus4){
  btn1[0].setEnabled(true);
  btn1[0].setBackground(Color.magenta);
}




        int key = kevt.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            play3( aevt , randomNumber+1  );
        }

        if (key == KeyEvent.VK_RIGHT) {
           play4( aevt , randomNumber+1  );
        }

        if (key == KeyEvent.VK_UP) {
            play1( aevt , randomNumber+1  );
        }

        if (key == KeyEvent.VK_DOWN) {
             play2( aevt , randomNumber+1  );
        }


        
        }

      



  public void matchplr( ActionEvent evt)
  {

    Random ran = new Random();
    int randomNumber = ran.nextInt(pasaaIcon.length);
    ImageIcon passIconrandom = pasaaIcon[randomNumber];
    pasaaShow.setIcon(passIconrandom);



if(pStatus1){
  btn1[1].setEnabled(true);
  btn1[1].setBackground(Color.magenta);
}

if(pStatus2){
  btn1[2].setEnabled(true);
  btn1[2].setBackground(Color.magenta);
}
if(pStatus3){
  btn1[3].setEnabled(true);
  btn1[3].setBackground(Color.magenta);
}
if(pStatus4){
  btn1[0].setEnabled(true);
  btn1[0].setBackground(Color.magenta);
}



    if(evt.getSource()==btn1[0]  )
    { 
        play1( evt , randomNumber+1  );
     }

    else if(evt.getSource()==btn1[1] )
    {
     play2( evt , randomNumber+1  );
    }

  else if(evt.getSource()==btn1[2]  )
  {
  play3( evt , randomNumber+1  );
  }

  else if(evt.getSource()==btn1[3]  )
  {
  play4( evt , randomNumber+1  );
  }



  }




public void play1(ActionEvent evt, int passa){

   int i=plrIndex[0];
      i=i-passa;

      if( i==-1 || i==-2 || i==-3  || i==-4 || i==-5 || i==-6  || i==-7 )
      {
        System.out.print("ifcondition");
      }
      else
      {
        if(i==0)
        {
          JOptionPane.showMessageDialog(frame,"1 player Win ");
          btn1[0].setVisible(false);
          pStatus1=true;
          winButton[0].setEnabled(true);
          winButton[0].setIcon(plrStatusImage[0]);


          if(nuop==2)
          {  
            btn1[1].setEnabled(true);
            btn1[1].setBackground(Color.magenta);
          }  
          else if(nuop==1)
          {
            btn1[0].setEnabled(true);
            btn1[0].setBackground(Color.orange);
          }
          else
          { 
 
            btn1[1].setEnabled(true);
            btn1[1].setBackground(Color.magenta);
          
          }



        }

        if( passa == playerStart[0] ) 
        {   
          playerStart[0]=10;
          plrIndex[0]=99;
          btn[plrIndex[0]].setIcon(plrStatusImage[0]);
          btn1[0].setEnabled(true);
        }
        else if(playerStart[0]==10)
        {   
          if(passa == 6)
          {
            btn[plrIndex[0]].setIcon(btnIcon[plrIndex[0]]);
            plrIndex[0]=plrIndex[0]-passa;
            btn[plrIndex[0]].setIcon(plrStatusImage[0]);
            btn1[0].setEnabled(true);
          }
          else 
          {
          
            btn[plrIndex[0]].setIcon(btnIcon[plrIndex[0]]);
            plrIndex[0]=plrIndex[0]-passa;
            btn[plrIndex[0]].setIcon(plrStatusImage[0]);
            for( tmp =0 ;tmp< snack.length ; tmp++)
              if ( plrIndex[0] == snack[tmp] )
              {          
                btn[plrIndex[0]].setIcon(btnIcon[plrIndex[0]]); 
                plrIndex[0]=snackLoc[tmp];
                btn[plrIndex[0]].setIcon(plrStatusImage[0]);
              }         
            for( tmp =0 ;tmp< lift.length ; tmp++)
              if ( plrIndex[0] == lift[tmp] )
              {          
                btn[plrIndex[0]].setIcon(btnIcon[plrIndex[0]]); 
                plrIndex[0]=liftLoc[tmp];
                btn[plrIndex[0]].setIcon(plrStatusImage[0]);
             }

          }
                  
      
        }
        
      }
      if(passa==6 && evt.getSource()==btn1[0] ){ 
             if(nuop==1){}
            else{
            btn1[1].setEnabled(false);
            btn1[1].setBackground(Color.white);
          }

          btn1[0].setEnabled(true);
          btn1[0].setBackground(Color.magenta);
        }  
        else if(nuop==1){
          btn1[0].setEnabled(true);
          btn1[0].setBackground(Color.magenta);
        }
        else{ 
          btn1[0].setEnabled(false);
          btn1[0].setBackground(Color.white);
          if(nuop==1){}
            else{
            btn1[1].setEnabled(true);
            btn1[1].setBackground(Color.magenta);
          }
        }
    }

public void play2(ActionEvent evt, int passa){

    int i=plrIndex[1];
    i=i-passa;
    if( i==-1 || i==-2 || i==-3  || i==-4 || i==-5 || i==-6  || i==-7 )
    {
      System.out.print("ifcondition");
    }
  else 
  {
    if(i==0)
    {
      JOptionPane.showMessageDialog(frame,"2 player Win ");
      btn1[1].setVisible(false);
      pStatus2=true;
      winButton[1].setEnabled(true);
      winButton[1].setIcon(plrStatusImage[1]);



          if(nuop==2)
          {  
            btn1[0].setEnabled(true);
            btn1[0].setBackground(Color.magenta);
          }  
          else
          { 
 
            btn1[2].setEnabled(true);
            btn1[2].setBackground(Color.magenta);
          
          }



    }
    if ( passa == playerStart[1] ) 
    {   
      playerStart[1]=10;
      plrIndex[1]=99;
      btn[plrIndex[1]].setIcon(plrStatusImage[1]);
      btn1[1].setEnabled(true);
    }
    else if(playerStart[1]==10)
    {   
      if(passa == 6)
        {
          btn[plrIndex[1]].setIcon(btnIcon[plrIndex[1]]);
          plrIndex[1]=plrIndex[1]-passa;
          btn[plrIndex[1]].setIcon(plrStatusImage[1]);
          btn1[1].setEnabled(true);
        }
        else 
        {
           
        
           
        btn[plrIndex[1]].setIcon(btnIcon[plrIndex[1]]);
        plrIndex[1]=plrIndex[1]-passa;
        btn[plrIndex[1]].setIcon(plrStatusImage[1]);
     
        for( tmp =0 ;tmp< snack.length ; tmp++)
          if ( plrIndex[1] == snack[tmp] )
          {          
            btn[plrIndex[1]].setIcon(btnIcon[plrIndex[1]]); 
            plrIndex[0]=snackLoc[tmp];
            btn[plrIndex[1]].setIcon(plrStatusImage[1]);
          } 
            

        for( tmp =0 ;tmp< lift.length ; tmp++)
          if ( plrIndex[1] == lift[tmp] )
          {          
            btn[plrIndex[1]].setIcon(btnIcon[plrIndex[1]]); 
            plrIndex[1]=liftLoc[tmp];
            btn[plrIndex[1]].setIcon(plrStatusImage[1]);
          }
        }
        

      }
     
      
  }

  if(passa==6 && evt.getSource()==btn1[1] ){ 
             if(nuop==2){}
            else{
            btn1[0].setEnabled(false);
            btn1[2].setEnabled(false);
            btn1[0].setBackground(Color.white);
            btn1[2].setBackground(Color.white);
            }

          btn1[1].setEnabled(true);
          btn1[1].setBackground(Color.magenta);
        }  
        else if(nuop==2){
          btn1[0].setEnabled(true);
          btn1[1].setEnabled(false);
           btn1[0].setBackground(Color.magenta);
            btn1[1].setBackground(Color.white);
          
        }
        else{ 
          btn1[1].setEnabled(false);
          btn1[2].setEnabled(true);
          btn1[2].setBackground(Color.magenta);
            btn1[1].setBackground(Color.white);
          
    }
}

public void play3(ActionEvent evt, int passa)
{
    int i=plrIndex[2];
    i=i-passa;
    if( i==-1 || i==-2 || i==-3  || i==-4 || i==-5 || i==-6  || i==-7 )
    {
       System.out.print("ifcondition");
    }
    else
    {
      if(i==0)
      {
        JOptionPane.showMessageDialog(frame,"3 player Win ");
        btn1[2].setVisible(false);
        pStatus3=true;
        winButton[2].setEnabled(true);
        winButton[2].setIcon(plrStatusImage[2]);



         if(nuop==3)
          {  
            btn1[0].setEnabled(true);
            btn1[0].setBackground(Color.magenta);
          }  
         


      }
      else
      if ( passa == playerStart[2] ) 
      {   
        playerStart[2]=10;
        plrIndex[2]=99;
        btn[plrIndex[2]].setIcon(plrStatusImage[2]);
        btn1[2].setEnabled(true);
        
        
      }

      else if(playerStart[2]==10)
      {   
        if(passa == 6)
        {
          btn[plrIndex[2]].setIcon(btnIcon[plrIndex[2]]);
          plrIndex[2]=plrIndex[2]-passa;
          btn[plrIndex[2]].setIcon(plrStatusImage[2]);
          
        }
        else 
        {
          
           
          
          i=plrIndex[2]-passa; 
          btn[plrIndex[2]].setIcon(btnIcon[plrIndex[2]]);
          plrIndex[2]=plrIndex[2]-passa;
          btn[plrIndex[2]].setIcon(plrStatusImage[2]);
     
          for( tmp =0 ;tmp< snack.length ; tmp++)
            if ( plrIndex[2] == snack[tmp] )
            {          
              btn[plrIndex[2]].setIcon(btnIcon[plrIndex[2]]); 
              plrIndex[2]=snackLoc[tmp];
              btn[plrIndex[2]].setIcon(plrStatusImage[2]);
            } 
            

          for( tmp =0 ;tmp< lift.length ; tmp++)
            if ( plrIndex[2] == lift[tmp] )
            {          
              btn[plrIndex[2]].setIcon(btnIcon[plrIndex[2]]); 
              plrIndex[2]=liftLoc[tmp];
              btn[plrIndex[2]].setIcon(plrStatusImage[2]);
            }

        }
        
      }
        
    }
    if(passa==6 && evt.getSource()==btn1[2] ){ 
            if(nuop==3){
              btn1[0].setEnabled(false);
            btn1[1].setEnabled(false);
            }
            else{
            btn1[0].setEnabled(false);
            btn1[1].setEnabled(false);
            }
          btn1[2].setBackground(Color.magenta);
          btn1[2].setEnabled(true);
        }  
        else if(nuop==3){
           btn1[0].setEnabled(true);
           btn1[2].setEnabled(false);
           btn1[0].setBackground(Color.magenta);
            btn1[2].setBackground(Color.white);
          
        }
        else{ 
          btn1[3].setBackground(Color.magenta);
            btn1[2].setBackground(Color.white);

          btn1[2].setEnabled(false);
          btn1[3].setEnabled(true);
          
    }
}


public void play4(ActionEvent evt, int passa){
    int i=plrIndex[3];
    i=i-passa;
    if( i==-1 || i==-2 || i==-3  || i==-4 || i==-5 || i==-6  || i==-7 )
      {
        System.out.print("ifcondition");
      }
    else 
    {

      if(i==0){
        JOptionPane.showMessageDialog(frame,"4 player Win ");
        btn1[3].setEnabled(false);
        pStatus4=true;
        winButton[3].setEnabled(true);
        winButton[3].setIcon(plrStatusImage[3]);


          if(nuop==4)
          {  
            btn1[0].setEnabled(true);
            btn1[0].setBackground(Color.magenta);
          }  
         

    }

    if ( passa == playerStart[3] ) 
    {   
      playerStart[3]=10;
      plrIndex[3]=99;
      btn[plrIndex[3]].setIcon(plrStatusImage[3]);
      btn1[3].setEnabled(true);
      
    }

    else if(playerStart[3]==10)
    {   
      if(passa == 6)
      {
        btn[plrIndex[3]].setIcon(btnIcon[plrIndex[3]]);
        plrIndex[3]=plrIndex[3]-passa;
        btn[plrIndex[3]].setIcon(plrStatusImage[3]);
        btn1[3].setEnabled(true);
      }
      else 
      {
        
          
          
        i=plrIndex[3]-passa; 
        btn[plrIndex[3]].setIcon(btnIcon[plrIndex[3]]);
        plrIndex[3]=plrIndex[3]-passa;
        btn[plrIndex[3]].setIcon(plrStatusImage[3]);
     
        for( tmp =0 ;tmp< snack.length ; tmp++)
          if ( plrIndex[3] == snack[tmp] )
          {          
            btn[plrIndex[3]].setIcon(btnIcon[plrIndex[3]]); 
            plrIndex[3]=snackLoc[tmp];
            btn[plrIndex[3]].setIcon(plrStatusImage[3]);
          } 
            

          for( tmp =0 ;tmp< lift.length ; tmp++)
          if ( plrIndex[3] == lift[tmp] )
          {          
             btn[plrIndex[3]].setIcon(btnIcon[plrIndex[3]]); 
             plrIndex[3]=liftLoc[tmp];
            btn[plrIndex[3]].setIcon(plrStatusImage[3]);
          }

        }
       
      }
       
    }
    if(passa==6 && evt.getSource()==btn1[3] ){ 
            
            btn1[0].setEnabled(false);
            btn1[1].setEnabled(false);
            btn1[2].setEnabled(false);
            btn1[3].setEnabled(true);
            btn1[0].setBackground(Color.white);
            btn1[1].setBackground(Color.white);
            btn1[3].setBackground(Color.magenta);
             btn1[2].setBackground(Color.white);
        }  

        else{ 
          btn1[3].setEnabled(false);
          btn1[0].setEnabled(true);
          btn1[3].setBackground(Color.white);
          btn1[0].setBackground(Color.magenta);
          
    }
}

 

}



