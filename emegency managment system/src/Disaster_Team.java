import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Disaster_Team {
	String name;
	String contact_no;
	String login_id;
	String password;
	String he_me;
	Scanner sc=new Scanner(System.in);
	public Disaster_Team(String n,String co,String lo,String pas,String ge_me){
		name=n;
		contact_no=co;
		this.login_id=lo;
		this.password=pas;
		this.he_me=ge_me;
	}
	public void feature() throws IOException {
		System.out.println("press 0 to exit");
		System.out.println("press 1 to sent alert to people");
		//System.out.println("press 2 to sent forecast data");
		String d=sc.nextLine();
		if(d.equals("0"))
			return ;
		else if(d.equals("1")) {
			sentAlertMessage();
		}
		else
			System.out.println("please enter valid command");
		feature();
	}
	public void sentAlertMessage() throws IOException{
		System.out.println("please enter the message you want to send");
		String ss=sc.nextLine();
		System.out.println("please at the location which is in danger");
		String sss=sc.nextLine();
		FileReader f=new FileReader("Person");
		BufferedReader b=new BufferedReader(f);
		while(true) {
			String ssss=b.readLine();
			if(ssss==null)
				break;
			String[] sr=ssss.split(",");
			if(sr[4].equals(sss)) {
				Person p=new Person(sr[0],sr[1],sr[2],sr[3],sr[4]);
				p.RecieveNotification(ss);
			}
		}
		b.close();
		System.out.println("message send to People");
		f=new FileReader("reliefTeam");
		b=new BufferedReader(f);
		while(true) {
			String pr=b.readLine();
			if(pr==null)
				break;
			String[] sr=pr.split(",");
			if(sr[5].equals(sss)) {
				Relief_Team r=new Relief_Team(sr[0],sr[1],sr[2],sr[3],sr[4],sr[5]);
				r.ReceiveNotification(ss);
			}
		}
		b.close();
		System.out.println("Message sent to Relief Team");
	}
	public String SentForecastData(){
		Random rand=new Random();
		String s="";
		s+="Temperature :"+rand.nextInt(50)+" Humidity : "+rand.nextInt(100);
		return s;
	}
}
