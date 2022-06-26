import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.*;

class AnandBind implements ActionListener{

JFrame frame;
JPanel firstPagePanel;

JButton playerButton[];
JButton startGame, close;

JTextField playerName[];
boolean playflag[];

int tmp,check=0;
int check1=0;
String playerNameCount[];

public AnandBind(){

frame=new JFrame("Developed by Anand Bind");
frame.setLayout(null);
frame.setBounds(30,10,360,500);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	firstPage();
}

void firstPage(){

firstPagePanel=new JPanel();
firstPagePanel.setBounds(20,20,300,420);
firstPagePanel.setBackground(Color.red);
firstPagePanel.setLayout(null);

String labName[]={"! Anand Bind Software !","! Solution Institute Pvt.Ltd !","Select Player"};

JLabel []labInto=new JLabel[3];
int fontSize[]={25,18,15};


for(tmp=0;tmp<3;tmp++){
labInto[tmp]=new JLabel(labName[tmp]);
labInto[tmp].setFont(new Font("Arial",Font.BOLD,fontSize[tmp]));
labInto[tmp].setForeground(Color.yellow);
labInto[tmp].setBackground(Color.green);
}

labInto[0].setBounds(10,40,300,30);
labInto[1].setBounds(20,60,300,40);
labInto[2].setBounds(20,140,300,25);

for(tmp=0;tmp<3;tmp++){
firstPagePanel.add(labInto[tmp]);
}


JPanel buttonlay=new JPanel();
buttonlay.setBounds(0,170,360,50);
buttonlay.setLayout(null);
buttonlay.setBackground(Color.yellow);

playerButton=new JButton[4];
int locb=60;
for(tmp=0;tmp<4;tmp++){
playerButton[tmp]=new JButton(String.valueOf(tmp+1));
playerButton[tmp].addActionListener(this);
playerButton[tmp].setFont(new Font("Arial",Font.BOLD,11));
playerButton[tmp].setForeground(Color.black);
playerButton[tmp].setBackground(Color.pink);
playerButton[tmp].setBounds(locb,10,40,30);
locb=locb+45;
buttonlay.add(playerButton[tmp]);

}
firstPagePanel.add(buttonlay);



JLabel l[]=new JLabel[4];
String pnt[]={"Enter 1 Player Name","Enter 2 Player Name","Enter 3 Player Name","Enter 4 Player Name"};
int htf=10;

playerName=new JTextField[4];

JPanel info=new JPanel();
info.setBounds(0,235,360,140);
info.setLayout(null);
info.setBackground(Color.yellow);

for(tmp=0;tmp<4;tmp++){
	l[tmp]=new JLabel(pnt[tmp]);
	l[tmp].setBounds(20,htf,140,20);
    info.add(l[tmp]);

	playerName[tmp]=new JTextField();
	playerName[tmp].setBounds(145,htf,140,20);
	playerName[tmp].setEditable(false);
	htf=htf+30;
    info.add(playerName[tmp]);
}  firstPagePanel.add(info);



startGame=new JButton("Play Game");
startGame.addActionListener(this);
startGame.setFont(new Font("Arial",Font.BOLD,11));
startGame.setForeground(Color.black);
startGame.setBackground(Color.pink);
startGame.setBounds(140,385,120,25);
firstPagePanel.add(startGame);

close=new JButton("Close");
close.addActionListener(this);
close.setFont(new Font("Arial",Font.BOLD,11));
close.setForeground(Color.black);
close.setBackground(Color.pink);
close.setBounds(40,385,80,25);
firstPagePanel.add(close);



frame.add(firstPagePanel);
frame.setVisible(true);


}


public void actionPerformed(ActionEvent evt) {

if(evt.getSource()==playerButton[0]){ playerCreate(1); check1=1; }
if(evt.getSource()==playerButton[1]){ playerCreate(2); check1=1; }
if(evt.getSource()==playerButton[2]){ playerCreate(3);  check1=1;}
if(evt.getSource()==playerButton[3]){ playerCreate(4); check1=1; }
if(evt.getSource()==close){ System.exit(0); }

if(evt.getSource()==startGame){ 
if(check1==1){
getPlyrName();
}
else 
JOptionPane.showMessageDialog(firstPagePanel,"Please Select anyone player");
}




}

public void playerCreate(int lm){
check=lm;
if(check==1 || check==2 || check==3 || check==4)
{
for(tmp=0;tmp<4;tmp++)        {
playerButton[tmp].setEnabled(false);
   }


for(tmp=0;tmp<check;tmp++)        {

playerName[tmp].setEditable(true);
   }
}

}

void getPlyrName(){
playerNameCount=new String[check];
for(tmp=0;tmp<check;tmp++)
{
if(0==playerName[tmp].getText().trim().length())
JOptionPane.showMessageDialog(firstPagePanel,"Please Enter Player Name "+tmp);
else
playerNameCount[tmp]=playerName[tmp].getText();
}
startGame.setEnabled(false);
new GameStart(check,playerNameCount);
}


	public static void main(String []args)
	{
new AnandBind();
	}
}

