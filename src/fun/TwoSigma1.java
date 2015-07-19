package fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSigma1 {
	public static void main(String[] args) {
		String[] friend1 = { "YYNN", "YYYN", "NYYN", "NNNY" };
		String[] friend2 = { "YNNNN", "NYNNN", "NNYNN", "NNNYN", "NNNNY" };
		System.out.println(friendCircles(friend2));
	}


static int friendCircles(String[] friends) {
        // Assign every person a circle num. 
        // hashmap circle maps <person, circleNum>
		HashMap<Integer, Integer> circle = new HashMap<Integer, Integer>();
		int circleNum = 0; // Assign each circle a unique group number 
		int realCounter = 0; // Keep track of the actual number of circles (since at some point two circles might have to merge because of mutual friends)
        
		for (int i = 0; i < friends.length; i++) {
            // iterating just half of friends array because of the fifth constraint given above 
			for (int j = 0; j <= i; j++) {

				if ((friends[i].charAt(j) == 'Y')) {

					if (circle.get(i) == null && circle.get(j) == null) {// means none of the friends are in our hashmap

						realCounter++;
						circle.put(i, ++circleNum);
						if (i != j) {// avoid unnecessary operations if i==j
							circle.put(j, circleNum);
						}

					}
					// Case where two circles meet and merge
					else if (circle.get(i) != null && circle.get(j) != null
							&& circle.get(j) != circle.get(i)) {						
						int firstCircleNum = circle.get(i);
						int secondCircleNum = circle.get(j);
						// decrease the realCounter since we are merging the two circles because of mutualfriends
						realCounter--;
						// set the circleNum of all of second circle to the circleNum of first 
						for (int person: circle.keySet()){
							if (circle.get(person) == firstCircleNum)
								circle.put(person, secondCircleNum);							
						}
					}
					else if (circle.get(i) != null) { // i is already in a circle, so assign j the same circlenum as i 
						circle.put(j, circle.get(i));
					} else if (circle.get(j) != null) { // j is already in a circle, so assign i the same circlenum as j
						circle.put(i, circle.get(j));
					}
				}
			}
		}
        // return the real Counter
		return realCounter;
	}
}
