import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Relief_Team {
	String name;
	String contact_no;
	String login_id;
	String password;
	String he_me;
	String location;
	Relief_Team d;
	Scanner sc=new Scanner(System.in);
	public Relief_Team(String n,String c,String l,String p,String h,String ll){
		this.name=n;
		this.contact_no=c;
		this.login_id=l;
		this.password=p;
		this.he_me=h;
		this.location=ll;
	}
	public void feature() throws IOException {
		System.out.println("press 0 to exit");
		System.out.println("press 1 to sent UploadVideo");
		System.out.println("press 2 to sent SeeTotalPeople");
		String d=sc.nextLine();
		if(d.equals("0"))
			return ;
		else if(d.equals("1"))
			UploadVideos();
		else if(d.equals("2"))
			SeeTotalPeople();
		else
			System.out.println("please enter valid command");
		feature();
	}
	public void UploadVideos() throws IOException{
		System.out.println("Enter the name of the video");
		String s=sc.nextLine();
		int count=0;
		FileReader f=new FileReader("video_uploaded");
		BufferedReader b=new BufferedReader(f);
		while(true) {
			String l=b.readLine();
			if(l==null)
				break;
			count++;
		}
		b.close();
		f.close();
		count++;
		String login1=Integer.toString(count);
		FileWriter fw=new FileWriter("video_uploaded",true);
		BufferedWriter bb=new BufferedWriter(fw);
		bb.write(login1+","+s+","+name+","+login_id+"\n");
		System.out.println("video has been uploaded with id: "+login1);
		bb.close();
		fw.close();
	}
	public void SeeTotalPeople() throws IOException{
		System.out.println("Please enter the location in which you want to know number of people");
		String s=sc.nextLine();
		int total=0;
		FileReader f=new FileReader("Person");
		BufferedReader b=new BufferedReader(f);
		while(true) {
			String ss=b.readLine();
			if(ss==null)
				break;
			String[] sr=ss.split(",");
			if(sr[4].equals(s)) {
				Person p=new Person(sr[0],sr[1],sr[2],sr[3],sr[4]);
				total++;
			}
		}
		b.close();
		System.out.println("total number of people in "+s+" is "+total);
	}
	public void ReceiveNotification(String s){
		System.out.println(name+": "+s);
	}
	public void sendMessage(Person p,String s) {
		p.receiveMessageRelief(d,s);
	}
	public void receiveMessage(Person p,String s) {
		System.out.println(p.name+": "+s);
		System.out.println("please enter message");
		String sd=sc.nextLine();
		sendMessage(p,sd);
	}
}
