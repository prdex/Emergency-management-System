import java.util.Scanner;

public class NGO {
	String name;
	String contact_no;
	String login_id;
	String password;
	String Ba_De;
	String imp_doc;
	String Amount;
	Scanner sc=new Scanner(System.in);
	public NGO(String n,String c,String l,String p,String b,String i,String ss){
		this.name=n;
		this.contact_no=c;
		this.login_id=l;
		this.password=p;
		this.Ba_De=b;
		this.imp_doc=i;
		this.Amount=ss;
	}
	public void feature() {
		System.out.println("press 0 to EXIT");
		System.out.println("press 1 to see total amount donated");
		//System.out.println("press 2 to sent SolveQuery");
		String d=sc.nextLine();
		if(d.equals("0"))
			return ;
		else if(d.equals("1"))
			seeTotalAmount();
		else
			System.out.println("please enter the valid command");
		feature();
	}
	public void seeTotalAmount(){
		System.out.println(Amount);
	}
	public String SolveQuery(String s){
		String[] ss=s.split(":");
		System.out.println("You have receive query from "+ss[0]);
		System.out.println("place type the message to answer the query");
		String sss=sc.nextLine();
		return sss;
	}
}
