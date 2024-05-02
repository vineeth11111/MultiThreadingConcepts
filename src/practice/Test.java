package practice;

public class Test {
	
	public static void main(String[] args) throws Exception{
		SBIAccount sbiAccount = new SBIAccount();
		Thread thread1 = new Thread(
				
				() -> {
					System.out.println("Thread 1 started");
					for(int count = 1; count <=200; count++) {
						sbiAccount.counter();
					}
				}); 
      Thread thread2 = new Thread(
				
				() -> {
					System.out.println("Thread 2 started");
					for(int count = 1; count <=200; count++) {
						sbiAccount.counter();
					}
				});
		/*thread1.start();
		
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(sbiAccount.getCounter() + " End of Main");*/
      int a = 0;
      System.out.println("Value of a is "+String.valueOf(a));
		
	}

	
}
