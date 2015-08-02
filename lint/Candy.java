package lint;

import junit.framework.TestCase;

public class Candy  extends TestCase{
	public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0]=1;
        for(int i=1; i<ratings.length; i++) {
            if (ratings[i]>ratings[i-1]) {
                candies[i]=candies[i-1]+1;
            }
            else if (ratings[i]==ratings[i-1]) {
                candies[i]=1;
            }
            else{ //when i<i-1
            	candies[i]=1;
                if (candies[i-1] == 1) {
                    for(int j=i-1; j>0 && ratings[j]>ratings[j+1] && candies[j]<=candies[j+1]  ; j--) {
                        candies[j]=candies[j]+1;
                    }
                }
            }
        }
        int total =0;
        for(int i=0; i<candies.length; i++) {
            total+=candies[i];
        }
        return total;
    }
	
	public void testCandy() {
		int[] sample = new int[]{1,3,4,3,2,1};
		assertEquals(13, this.candy(sample));
	}
}
