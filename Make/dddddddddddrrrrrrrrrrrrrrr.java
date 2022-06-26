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

import javax.swing.SwingConstants;
import javax.swing.AbstractButton;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.util.Random;


 class GameStart implements ActionListener 
{
String playerName[];
int nuop,tmp, tmp1;

JFrame frame;
JButton []btn,btn1;
JLabel playerNameL[];


JButton pasaaShow;
ImageIcon []pasaaIcon,plrStatusImage , btnIcon;

String pl[]={BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.EAST,BorderLayout.WEST,BorderLayout.CENTER};
Color pcolor[]={Color.red,Color.yellow,Color.green,Color.blue,Color.pink};



int plrIndex[]={101,101,101,101};

int playerStart[] = {6,6,6,6};

int snack[]={4,20,29,43,75};
int snackLoc[]={76,22,48,62,88};

int liftLoc[]={1,15,32,35,56,62,74};
int lift[]={34,37,50,53,78,80,85};


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
panel[tmp].setLayout(null);
panel[tmp].setBackground(pcolor[tmp]);
   }

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

pasaaIcon=new ImageIcon[6];
int tmp2=1;
for(tmp=0;tmp<6;tmp++)
   {
pasaaIcon[tmp]=new ImageIcon(String.valueOf("pasaaImage/"+ tmp2++ +".png"));
   }


int x1_x21=300;
int y1_y21=5;

playerNameL=new JLabel[playerName.length];
for(tmp=0;tmp<playerName.length;tmp++){
playerNameL[tmp]=new JLabel(playerName[tmp]);
playerNameL[tmp].setFont(new Font("Arial",Font.BOLD,15));
playerNameL[tmp].setBounds(x1_x21 ,y1_y21, 170 ,30);
if(tmp==1)
   {  x1_x21=10;   y1_y21=350;  }
   panel[tmp].add(playerNameL[tmp]);
   }

int x1_x2=485;
int y1_y2=5;

btn1=new JButton[playerName.length];
for(tmp=0;tmp<playerName.length;tmp++)   {
btn1[tmp] = new JButton(String.valueOf(tmp+1));  
btn1[tmp].addActionListener(this);
btn1[tmp].setBackground(Color.white); 	
playerNameL[tmp].setForeground(Color.black);	  
btn1[tmp].setBorder(null);	
btn1[tmp].setBounds(x1_x2,y1_y2, 30,30);
if(tmp==1)
    {  x1_x2=80;   y1_y2=305;  }
    panel[tmp].add(btn1[tmp]);	
   }

for(tmp=0;tmp<5;tmp++){
frame.add(panel[tmp]);
 }


panel[4].setLayout(new GridLayout(10,10,0,0));


btnIcon= new ImageIcon[100];
int t=100;
for ( tmp =0 ; tmp<100 ; tmp++){
btnIcon[tmp] = new ImageIcon(String.valueOf("newImage/"+ t-- +".png"));
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
    for(tmp=0;tmp<4;tmp++)
    {
	   int i=1;
      plrStatusImage[tmp]=new ImageIcon("plr/"+ i++ +".png");
    }


   frame.setVisible(true);

  }

  public void actionPerformed(ActionEvent evt) 
  {


    if(evt.getSource()==btn1[0]){ matchplr( evt);  }
    else if(evt.getSource()==btn1[1]){ matchplr( evt);  }
    else if(evt.getSource()==btn1[2]){ matchplr( evt);  }
    else if(evt.getSource()==btn1[3]){ matchplr( evt);  }

  }



  public void matchplr( ActionEvent evt)
  {

    Random ran = new Random();
    int randomNumber = ran.nextInt(pasaaIcon.length);
    ImageIcon passIconrandom = pasaaIcon[randomNumber];
    pasaaShow.setIcon(passIconrandom);

    valueIcrease(evt , randomNumber+1 );
  }


  void valueIcrease( ActionEvent evt, int passa )
  {

    if(evt.getSource()==btn1[0])
    {

      if ( passa == playerStart[0] ) 
      {   
        playerStart[0]=10;
        plrIndex[0]=99;
        btn[plrIndex[0]].setIcon(plrStatusImage[0]);
       
        for(tmp =1; tmp<btn1.length ; tmp++ )
        {
         btn1[tmp].setEnabled(false);
        }
      }

     else if(playerStart[0]==10)
      {   
        if(passa == 6)
        {
          btn[plrIndex[0]].setIcon(btnIcon[plrIndex[0]]);
          plrIndex[0]=plrIndex[0]-passa;
          btn[plrIndex[0]].setIcon(plrStatusImage[0]);
          for(tmp =1; tmp<btn1.length ; tmp++ ) 
          {
            btn1[tmp].setEnabled(false); 
          }
        }
        else 
        {
          for(tmp =1; tmp<btn1.length ; tmp++ ) 
          btn1[tmp].setEnabled(true);   
          
          int i=plrIndex[0]-passa; 
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
    }else if( false ) {   }
  }
}






/*
if( i==0 ||  i==-1 || i==-2 || i==-3  || i==-4 || i==-5 || i==-6   )
           {
            btn1[i].setEnabled(false);
           } */