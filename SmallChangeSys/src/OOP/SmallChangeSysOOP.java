package OOP;

import java.text.SimpleDateFormat;//导入SimpleDateFormat包
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
	boolean loop = true;//初始化loop
	
	Scanner in=new Scanner(System.in);
	String key=null;//初始化key
	
	String details="==========零钱通明细========";//初始化details
	
	double money=0;
	double balance=0;
	Date date=null;
	String note=null;
	
	//格式化日期 new SimpleDateFormat("yyyy-MM-dd HH:mm")
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//使用 do{}while(); 语句 循环打印菜单
	public void mainMenu() {
		do {
			
			System.out.println("\n==========零钱通菜单========");
			System.out.println("\t1 零钱通明细");
			System.out.println("\t2 收益入账");
			System.out.println("\t3 消费");
			System.out.println("\t4 退    出");
			
			System.out.println("请选择(1-4): ");
			key=in.next();//输入选项1 2 3 4 
			
			switch(key){
			
				case"1":
						this.detail();//调用零钱通明细的方法
						break;
				
				case"2":
						this.income();//调用收益入账的方法
						break;
						
				case"3":
						this.pay();//调用消费的方法
						break;
				
				case"4":
						this.exit();//调用退    出的方法
						break;
						
				default:
						System.out.println("菜单选择有误，请重新选择！");
				
			}
			
		}while(loop);//当loop==true,继续循环;当loop==false,退出循环
		
		//告诉User退出了零钱通项目
		System.out.println("-----退出了零钱通项目-----");
		
		//return;
	}
	
	public void detail() {
		System.out.println(details);//打印拼接后的零钱通明细
		//return;
	}
	
	public void income() {
		System.out.println("收益入账金额:");
		money=in.nextDouble();
		
		//过关斩将。如果不满足money>0,则退出income()方法
		//需重新选择income()方法,输入正确的money
		if(money<=0) {
			System.out.println("收益入账金额 需大于 0");
			return;//break;
		}
		
		date=new Date();//日期更新
		
		balance+=money;
		
		//拼接信息
		details+="\n收益入账:\t+"+money+"\t"+sdf.format(date)+"\t余额:"+balance;
		
		//return;
	}
	
	public void pay() {
		System.out.println("消费金额:");
		money=in.nextDouble();
		
		//过关斩将。如果不满足0<money<=balance,则退出pay()方法
		//需重新选择pay()方法,输入正确的money
		if(money<=0||money>balance) {
			System.out.println("你的消费金额应该在0-"+balance);
			return;//break;
		}
		
		System.out.println("消费说明:");
		note=in.next();//输入 做什么事情的内容;如吃饭、看电影......
		
		balance-=money;
		
		date=new Date();//日期更新
		
		//拼接信息
		details+="\n"+note+"\t-"+money+"\t"+sdf.format(date)+"\t余额:"+balance;
		
		//return;
	}
	
	public void exit() {
		String choice="";//初始化choice,它是引用数据类型
		
		//使用 while(){} 循环,判断User是否输入正确的选项 y/n
		while(true) {
			System.out.println("你确定要退出吗？ y/n");
			choice=in.next();
			if(choice.equals("y")||choice.equals("n")) {
				break;//输入正确的选项 y/n 后,退出循环
			}
		}
		
		//在String类中equals被重写,用equals来判断 两个字符串变量(地址有两个) 的内容是否相同
		//在String类中的"=="比较的是地址,两个字符串变量 是否 指向同一个地址
		//判断choice是否为y,如果choice=="y",则loop=false,否则,不退出 do{}while() 循环
		if(choice.equals("y")) {
			loop=false;
		}
		
		//return;
	}
}
