import java.util.Scanner;

public class Doctor {
	String name;
	String contact_no;
	String login_id;
	String password;
	Doctor d;
	Scanner sc=new Scanner(System.in);
	public Doctor(String s,String c,String l,String p){
		this.name=s;
		this.contact_no=c;
		this.login_id=l;
		this.password=p;
	}
	public void sendMessage(Person p,String s) {
		p.receiveMessageDoctor(d,s);
	}
	public void receiveMessage(Person p,String s) {
		System.out.println(p.name+": "+s);
		System.out.println("please enter message");
		String sd=sc.nextLine();
		sendMessage(p,sd);
	}
}
