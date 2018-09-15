import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
	public int points(String[] player, String[] dictionary) {
		int totalScore = 0;
		HashSet<String> playerSet = new HashSet<>(Arrays.asList(player));
		
		for (String word: dictionary) {
			if (playerSet.contains(word)) {
				totalScore += score(word);
			}
		}
		
		return totalScore;
	}
	
	public int score(String word) {
		return word.length() * word.length();
	}
}
