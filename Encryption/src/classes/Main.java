package classes;

public class Main {

	public static void main(String[] args) {
		Encryption text = new Encryption("KRIS E HOMOSEKS");
		String text1 = text.encrypt();
		System.out.println(text1);
		text1 = text.decrypt(text1);
		System.out.println(text1);
	}
}
