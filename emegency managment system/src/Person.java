import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Person{
	String name;
	String contact_no;
	String login_id;
	String password;
	String location;
	int amount;
	Person ob;
	Scanner sc=new Scanner(System.in);
	public Person(String n,String c,String l,String p,String lo){
		name=n;
		contact_no=c;
		login_id=l;
		password=p;
		location=lo;
		amount=0;
	}
	public void feature() throws IOException {
		System.out.println("press 1 to chat with doctor");
		System.out.println("press 2 to chat with relief_team");
		System.out.println("press 3 to send warning to relatives");
		System.out.println("press 4 to select and donate money to NGO");
		System.out.println("press 5 to query to NGO");
		System.out.println("press 6 to search NGO");
		System.out.println("press 7 to see & search video");
		System.out.println("press 8 to see the weather data");
		System.out.println("press 0 to exit");
		String d=sc.nextLine();
		if(d.equals("0")) {
			return ;
		}
		else if(d.equals("1")) {
			FileReader f=new FileReader("Doctor");
			BufferedReader b=new BufferedReader(f);
			ArrayList<String> ar=new ArrayList<String>();
			Random ra=new Random();
			int total=0;
			while(true) {
				String s=b.readLine();
				if(s==null)
					break;
				else {
					total++;
					ar.add(s);
				}
			}
			int i=ra.nextInt(total);
			String[] gg=ar.get(i).split(",");
			Doctor doc=new Doctor(gg[0],gg[1],gg[2],gg[3]);
			doc.d=doc;
			sendMessageDoctor(doc,"hello");
		}
		else if(d.equals("2")) {
			FileReader f=new FileReader("reliefTeam");
			BufferedReader b=new BufferedReader(f);
			ArrayList<String> ar=new ArrayList<String>();
			Random ra=new Random();
			int total=0;
			while(true) {
				String s=b.readLine();
				if(s==null)
					break;
				else {
					total++;
					ar.add(s);
				}
			}
			int i=ra.nextInt(total);
			String[] gg=ar.get(i).split(",");
			Relief_Team doc=new Relief_Team(gg[0],gg[1],gg[2],gg[3],gg[4],gg[5]);
			doc.d=doc;
			sendMessageRelief(doc,"hello");
		}
		else if(d.equals("3")) {
			SendWarning();
		}
		else if(d.equals("4")) {
			SelectandDonateMoney();
		}
		else if(d.equals("5")) {
			sendNGOquery();
		}
		else if(d.equals("6")) {
			ArrayList<String> aa=SearchNgo();
			prints(aa);
		}
		else if(d.equals("7")) {
			SeeAndSearchVideo();
		}
		else if(d.equals("8"))
			seeweatherdata();
		else {
			System.out.println("please enter vaild choice");
		}
		feature();
	}
	public void SendWarning(){
		System.out.println("i am in danger "+name+" please help me");
	}
	public void RecieveNotification(String s){
		System.out.println(name+": "+s);
	}
	public void SelectandDonateMoney() throws IOException{
		ArrayList<String> sea=SearchNgo();
		prints(sea);
		for(int i=0;i<sea.size();i++) {
			System.out.println("press "+i+1+" to select NGO");
		}
		System.out.println("press 0 to EXIT");
		System.out.println("press '+' to search & select again");
		String ss=sc.nextLine();
		if(ss.equals("+"))
			SelectandDonateMoney();
		else {
			int dd=Integer.parseInt(ss);
			if(dd==0)
				return ;
			System.out.println("please enter the amount of money you want to donote");
			String ddd=sc.nextLine();
			int amountdonate=Integer.parseInt(ddd);
			String fff=sea.get(dd-1);
			String[] pr=fff.split(",");
			amountdonate+=Integer.parseInt(pr[6]);
			String ssss=Integer.toString(amountdonate);
			ArrayList<String> ar=new ArrayList<String>();
			FileReader f=new FileReader("NGO");
			BufferedReader b=new BufferedReader(f);
			while(true) {
				String jj=b.readLine();
				if(jj==null)
					break;
				String[] kk=jj.split(",");
				 if(kk[2].equals(pr[2])) {
					 kk[6]=ssss;
					 String ll="";
					 for(int i=0;i<=5;i++)
						 ll+=kk[i]+",";
					 ll+=kk[6]+"\n";
					 ar.add(ll);
				}
				 else
					ar.add(jj);
			}
			b.close();
			f.close();
			FileWriter fw=new FileWriter("NGO");
			BufferedWriter bb=new BufferedWriter(fw);
			for(int i=0;i<ar.size();i++)
				bb.write(ar.get(i));
			bb.close();
			fw.close();
			System.out.println("money has been donated");
			ar.clear();
		}
	}
	public void seeweatherdata() throws IOException{
		System.out.println("please enter the location for which you would like to see weather data");
		String sss=sc.nextLine();
		ArrayList<String> ar=new ArrayList<String>();
		FileReader f=new FileReader("DiasterTeam");
		BufferedReader b=new BufferedReader(f);
		int count=0;
		while(true) {
			String y=b.readLine();
			if(y==null)
				break;
			count++;
			ar.add(y);
		}
		b.close();
		Random ra=new Random();
		int a=ra.nextInt(count);
		String[] pp=ar.get(a).split(",");
		Disaster_Team dd=new Disaster_Team(pp[0],pp[1],pp[2],pp[3],pp[4]);
		String da=dd.SentForecastData();
		System.out.println(da);
	}
	public void sendNGOquery() throws IOException{
		ArrayList<String> ar=SearchNgo();
		prints(ar);
		for(int i=0;i<ar.size();i++) {
			System.out.println("press "+i+1+" to select NGO");
		}
		System.out.println("press 0 to EXIT");
		System.out.println("press '+' to search & select again");
		String ss=sc.nextLine();
		if(ss.equals("0"))
			return ;
		if(ss.equals("+"))
			sendNGOquery();
		else {
			int i=Integer.parseInt(ss);
			String[] pr=ar.get(i).split(",");
			talkWithNgo(pr);
			while(true) {
				System.out.println("press 0 for Exit");
				System.out.println("press + to continue your query");
				String sss=sc.nextLine();
				if(sss.equals("0"))
					return ;
				else
					talkWithNgo(pr);
			}
		}
	}
	public void talkWithNgo(String[] pr){
		NGO ngo=new NGO(pr[0],pr[1],pr[2],pr[3],pr[4],pr[5],pr[6]);
		System.out.println("please enter you query you need to get solve from NGO");
		String sak=name+":"+sc.nextLine();
		String dr=ngo.SolveQuery(sak);
		System.out.println(dr);
	}
	public void SeeAndSearchVideo() throws IOException{
		System.out.println("enter the name of video wich you want to search");
		String s=sc.nextLine();
		FileReader f=new FileReader("video_uploaded");
		BufferedReader b=new BufferedReader(f);
		while(true) {
			String r=b.readLine();
			if(r==null)
				break;
			String[] l=r.split(",");
			if(l[1].equals(s)) {
				System.out.println("VIDEO ID : "+l[0]);
				System.out.println("NAME : "+l[1]);
				System.out.println("UPLOADED BY : "+l[2]);
			}
		}
		b.close();
		f.close();
	}
	public void prints(ArrayList<String> a) {
		for(int i=0;i<a.size();i++) {
			String d=a.get(i);
			String[] dd=d.split(",");
			for(int j=0;j<dd.length-1;j++) {
				if(j==2 || j==3)
					continue;
				else
					System.out.print(dd[j]+" ");
			}
			System.out.println("\n");
		}
	}
	public ArrayList<String> SearchNgo() throws IOException{
		System.out.println("please enter the NGO name you want to search");
		String s=sc.nextLine();
		ArrayList<String> fi=new ArrayList<String>();
		FileReader f=new FileReader("NGO");
		BufferedReader b=new BufferedReader(f);
		while(true) {
			String d=b.readLine();
			if(d==null)
				break;
			String[] dd=d.split(",");
			if(dd[0].equals(s)) {
				fi.add(d);
			}
		}
		b.close();
		f.close();
		return fi;
	}
	public void sendMessageDoctor(Doctor d,String s) {
		d.receiveMessage(this.ob,s);
	}
	public void receiveMessageDoctor(Doctor d, String s) {
			System.out.println(d.name+": "+s);
			System.out.println("please enter message or if you want to exit type 'EXIT'");
			String sd=sc.nextLine();
			if(sd.equals("EXIT")) {
				System.out.println("chat session has been ended");
				return ;
			}
			sendMessageDoctor(d,sd);
	}
	public void sendMessageRelief(Relief_Team d,String s) {
		d.receiveMessage(this.ob,s);
	}
	public void receiveMessageRelief(Relief_Team d, String s) {
			System.out.println(d.name+": "+s);
			System.out.println("please enter message or if you want to exit type 'EXIT'");
			String sd=sc.nextLine();
			if(sd.equals("EXIT")) {
				System.out.println("chat session has been ended");
				return ;
			}
			sendMessageRelief(d,sd);
	}
}
