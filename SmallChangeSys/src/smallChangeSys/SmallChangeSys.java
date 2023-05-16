package smallChangeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
	public static void main(String[] args) {
		
		boolean loop = true;
		
		Scanner in=new Scanner(System.in);
		String key=null;
		
		String details="==========零钱通明细========";
		
		double money=0;
		double balance=0;
		Date date=null;
		String note=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		do {
			
			System.out.println("\n==========零钱通菜单========");
			System.out.println("\t1 零钱通明细");
			System.out.println("\t2 收益入账");
			System.out.println("\t3 消费");
			System.out.println("\t4 退    出");
			
			System.out.println("请选择(1-4): ");
			key=in.next();
			
			switch(key){
			
				case"1":
						System.out.println(details);
						break;
				
				case"2":
						System.out.println("收益入账金额:");
						money=in.nextDouble();
						if(money<=0) {
							System.out.println("收益入账金额 需大于 0");
							break;
						}
						date=new Date();
						balance+=money;
						details+="\n收益入账:\t"+money+"\t"+sdf.format(date)+"\t余额:"+balance;
						break;
						
				case"3":
						System.out.println("消费金额:");
						money=in.nextDouble();
						if(money<=0||money>balance) {
							System.out.println("你的消费金额应该在0-"+balance);
							break;
						}
						System.out.println("消费说明:");
						note=in.next();
						balance-=money;
						date=new Date();
						details+="\n"+note+"\t-"+money+"\t"+sdf.format(date)+"\t余额:"+balance;
						break;
				
				case"4":
						String choice="";
						while(true) {
							System.out.println("你确定要退出吗？ y/n");
							choice=in.next();
							if(choice.equals("y")||choice.equals("n")) {
								break;
							}
						}
						if(choice.equals("y")) {
						loop=false;
						}
						break;
						
				default:
						System.out.println("菜单选择有误，请重新选择！");
				
			}
			
		}while(loop);
		
		System.out.println("-----退出了零钱通项目-----");
		
		in.close();
	}
}
