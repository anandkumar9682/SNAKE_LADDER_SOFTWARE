class b {
	void show( int a  ){
		System.out.print("b");
	}
}

class  a extends b {

void   show ( int y )
{
System.out.println("a");
}

public static void main( String [] aa)
{
b d=new a();
d.show(1);
}
}