package kakao._2021_blind_recruitment;

public class _1_new_id_recommendation {
	public static void main(String[] args) {
		String new_id = "...!_@BaT#*..y.abcdefghijklm";
//		new_id = "z-+.^.";
//		new_id = "=.=";
//		new_id = "123_.def";
//		new_id = "abcdefghijklmn.p";
		String answer = solution(new_id);
		System.out.println("answer: " + answer);
	}
	
	public static String solution(String new_id) {
		//step 1
        new_id = new_id.toLowerCase();
        
        //step 2
        new_id = new_id.replaceAll("[^a-z0-9\\Q-_.\\E]", "");

        //step 3
        new_id = new_id.replaceAll("\\.+", "\\.");
        //step 4
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        //step 5
        if (new_id.isEmpty()) {
        	new_id = "a";
        }
        //step 6
        if (new_id.length() >= 16) {
        	new_id = new_id.substring(0, 15);
        }
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        //step 7
        if (new_id.length() <= 2) {
        	char endChar = new_id.charAt(new_id.length()-1);
        	while (new_id.length() < 3) {
        		new_id += endChar;
        	}
        }
        return new_id;
    }
}
