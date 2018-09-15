import java.util.*;

public class Anonymous {
	public int howMany(String[] headlines, String[] messages) {
		String headlinesString = "";
		int count = 0;
		
		for (String s: headlines) {
			headlinesString += s;
		}
		
		ArrayList<Character> headlinesCharArrayList = makeCharArrayList(headlinesString);
		
		for (String message: messages) {
			if (canBeMade(message, headlinesCharArrayList)) {
				count++;
			}
		}
		
		return count;
	}
	
	public static boolean canBeMade(String message, ArrayList<Character> headlinesCharArrayList) {
		HashSet<Character> charSet = makeCharSet(message);
		ArrayList<Character> messageCharArrayList = makeCharArrayList(message);
		
		for (Character c: charSet) {
			int headlinesCharFreq = Collections.frequency(headlinesCharArrayList, c);
			int messageCharFreq = Collections.frequency(messageCharArrayList, c);
			if (headlinesCharFreq < messageCharFreq) {
				return false;
			}
		}
		
		return true;
	}
	
	public static HashSet<Character> makeCharSet(String message) {
		message = noSpaceLowerCase(message);
		HashSet<Character> charSet = new HashSet<>();
		
		for (Character c: message.toCharArray()) {
			if (! charSet.contains(c)) {
				charSet.add(c);
			}
		}
		
		return charSet;
	}
	
	public static ArrayList<Character> makeCharArrayList(String message) {
		message = noSpaceLowerCase(message);
		ArrayList<Character> charArrayList = new ArrayList<>();
		
		for (Character c: message.toCharArray()) {
			charArrayList.add(c);
		}
		
		return charArrayList;
	}
	
	public static String noSpaceLowerCase(String message) {
		message = message.toLowerCase();
		String[] noSpace = message.split(" ");
		String noSpaceLowerCase = "";
		
		for (String s : noSpace) {
			noSpaceLowerCase += s;
		}
		
		return noSpaceLowerCase;
	}
	
	public static void main(String[] args) {
		
	}
}
