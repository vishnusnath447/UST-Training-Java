public class Challenge {
  public static int NumberOfDays(int cost, int savings, int start) {
		int temp=0;
		int count=0;
		while(cost>=savings){
			temp=start;
			for(int i=0;i<7;i++){
				savings = savings+temp;
				temp++;
				count++;
				if(savings>=cost){
					break;
				}
			}
			start++;
		}
		return(count);
  }
}