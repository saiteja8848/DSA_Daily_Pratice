package recursion;

public class TowersOfHanoi {
	
	// these parameters of fixed and  they work according there definition
		// source - starting and destination is the place where we are moving rods to
		static void towersOfHanoi(int n, char source, char auxiliary, char destination) {
			
			if(n==1) {
				System.out.println(source +"-->"+destination);
				return;
			}
			
			towersOfHanoi(n-1, source, destination, auxiliary); // here source--> auxilaryNode
			towersOfHanoi(1,source, auxiliary, destination); // source --> destination
			towersOfHanoi(n-1,auxiliary,source,destination ); // now we put back auxilaryNode --> Source
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
