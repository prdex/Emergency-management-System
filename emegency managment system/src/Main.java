import java.io.IOException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		LoginRegsister LR=new LoginRegsister();
		String sr=LR.feature();
		if(sr==null) {
			System.out.println("session has been ended");
			return ;
		}
		String[] st=sr.split(",");
		String[] ss=st[2].split("@");
		if(ss[0].equals("Person")) {
			Person p=new Person(st[0],st[1],st[2],st[3],st[4]);
			p.ob=p;
			p.feature();
			System.out.println("your session has been ended");
		}
		else if(ss[0].equals("DiasterTeam")) {
			Disaster_Team d=new Disaster_Team(st[0],st[1],st[2],st[3],st[4]);
			d.feature();
			System.out.println("your session has been ended");
		}
		else if(ss[0].equals("NGO")) {
			NGO n=new NGO(st[0],st[1],st[2],st[3],st[4],st[5],st[6]);
			n.feature();
			System.out.println("your session has been ended");
		}
		else if(ss[0].equals("reliefTeam")) {
			Relief_Team r=new Relief_Team(st[0],st[1],st[2],st[3],st[4],st[5]);
			r.d=r;
			r.feature();
			System.out.println("your session has been ended");
		}
		else {
			Doctor d=new Doctor(st[0],st[1],st[2],st[3]);
			d.d=d;
			System.out.println("your session has been ended");
		}
	}
}
