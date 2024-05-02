package practice;

public class SBIAccount {

	int counter = 0;
	public   void checkBalance() {
		
		synchronized(SBIAccount.class){

			System.out.println("Lock Acquired");
			System.out.println("Thread Name : "+ Thread.currentThread().getName());
			try {
				Thread.sleep(4000);
			}
			catch(InterruptedException e) {
				
			}
			System.out.println("Lock Removed");
		}
	}
	
	public  void counter() {
		try {
			System.out.println("counter started by "+Thread.currentThread().getName());
			//Thread.sleep(1000);
			counter++;
		}
		catch(Exception e) {
			
		}
		
	}
	
	public int getCounter() {
		return counter;
	}
	
}
