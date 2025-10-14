package procesosJava.procesos0101;

public class Divisores {
	public static void main(String[] args){
		int x, acc = 0;
		
		if(args.length > 0) {
			x = Integer.parseInt(args[0]);
			
			for(int i = 1; i <= x; i++) {
				if(x % i == 0) {
					System.out.println(i + " ");
					acc++;
				}
			}
			System.out.println("\nTiene " + acc + " divisores");
			System.exit(0);
			
		} else {
			System.exit(-1);
		}
	}
}
