package random_programs;

import java.util.ArrayList;

public class feistel_cipher {
	public static ArrayList<String> feistel_decoder(String k1, String k2, String L, String R){
		ArrayList<String> plaintext = new ArrayList<>();
		//swap the L and R before decrypting
		plaintext = feistel_decoder_helper(k2, R, L);
		
		//positions of blocks remain the same in the next round of decryption
		String upper_L = plaintext.get(0);
		String upper_R = plaintext.get(1);
		plaintext = feistel_decoder_helper(k1, upper_L, upper_R);
		
		//swap blocks again after the decrypting is done
		String temp = plaintext.get(0);
		plaintext.set(0, plaintext.get(1));
		plaintext.set(1, temp);
		
		return plaintext;
	}
	
	public static ArrayList<String> feistel_decoder_helper(String k, String L, String R){
		ArrayList<String> upper_blocks = new ArrayList<>();
		String upper_L = R;
		String upper_R = "";
		String fRK = "";
		
		//encoding f function = reversed R xor k
		String rev_R = reverse(R);
		fRK = xor(rev_R, k);
		
		upper_R = xor(fRK, L);
		
		upper_blocks.add(upper_L);
		upper_blocks.add(upper_R);
		
		return upper_blocks;
	}
	
	//this function gives the result of a xor b
    static String xor(String a, String b){
    String  a_xor_b = "";
         
        // Loop to iterate over binary Strings
        for (int i = 0; i < a.length(); i++){
            // If characters with the same index match then result is 0, otherwise 1
            if (a.charAt(i) == b.charAt(i))
            	a_xor_b += "0";
            else
            	a_xor_b += "1";
        }
        return a_xor_b;
    }
    
    //this function reverses a string
    static String reverse(String a) {
    	String reversedString = "";
    	char temp;
        for (int i=0; i<a.length(); i++){
        	temp= a.charAt(i); //extracts each character
        	reversedString= temp+reversedString; //adds each character in front of the existing string
        }
    	return reversedString;
    }
    
	public static void main(String[] args) {
		String k1 = "10010101";
		String k2 = "11000001";
		
		String b1 = "00100101";
		String b2 = "00001010";
		String b3 = "11001001";
		String b4 = "00100110";
		
		ArrayList<String> firstPart = feistel_decoder(k1, k2, b1, b2);
		ArrayList<String> secondPart = feistel_decoder(k1, k2, b3, b4);
		
		System.out.println(firstPart);
		System.out.println(secondPart);
	}
}
