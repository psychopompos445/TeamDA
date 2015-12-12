package classes;

public class Encryption {
	String[] key = { "PUIYA", "OTGHB", "SCXVM", "FQENK", "WRLDJ" };

	String text = new String();

	public Encryption(String text) {
		text = text.replaceAll("\\s+","");
		this.text = text.toUpperCase();
	}

	public String encrypt() {
		String newText = new String();
		int firstIndex = 0;
		int secondIndex = 1;
		int position1 = 0;
		int position2 = 0;
		int wordIndex1 = 0;
		int wordIndex2 = 0;
		boolean flag = false;
		if (this.text.length() % 2 != 0) {
			System.out.println("an extra X was added at the end of the string");
			this.text += 'X';
		}
		for (int i = 0; i < text.length(); i += 2) {
			for (int j = 0; j < key.length; j++) {
				if (key[j].indexOf(this.text.charAt(firstIndex)) != -1
						&& key[j].indexOf(this.text.charAt(secondIndex)) != -1) {
					position1 = key[j].indexOf(this.text.charAt(firstIndex));
					position2 = key[j].indexOf(this.text.charAt(secondIndex));
					if (position1 + 1 >= key[j].length()) {
						position1 = -1;
					}
					if (position2 + 1 >= key[j].length()) {
						position2 = -1;
					}
					newText += key[j].charAt(position1 + 1);
					newText += key[j].charAt(position2 + 1);
					flag = true;
					break;
				} else {
					for (int k = 0; k < key.length; k++) {
						if (key[k].indexOf(this.text.charAt(firstIndex)) != -1) {
							position1 = key[k].indexOf(this.text.charAt(firstIndex));
							wordIndex1 = k;
						}
						if (key[k].indexOf(this.text.charAt(secondIndex)) != -1) {
							position2 = key[k].indexOf(this.text.charAt(secondIndex));
							wordIndex2 = k;
						}
					}
					if (position1 != position2) {
						newText += key[wordIndex2].charAt(position1);
						newText += key[wordIndex1].charAt(position2);
						flag = true;
						break;
					}
					if (wordIndex1 + 1 >= key.length) {
						wordIndex1 = -1;
					}
					if (wordIndex2 + 1 >= key.length) {
						wordIndex2 = -1;
					}
					if (position1 == position2) {
						newText += key[wordIndex1 + 1].charAt(position1);
						newText += key[wordIndex2 + 1].charAt(position2);
						flag = true;
						break;
					} 
				}
			}
			if (flag) {
				firstIndex += 2;
				secondIndex += 2;
				flag = false;
			}
		}
		return newText;
	}
	
	public String decrypt(String text) {
		String newText = new String();
		int firstIndex = 0;
		int secondIndex = 1;
		int position1 = 0;
		int position2 = 0;
		int wordIndex1 = 0;
		int wordIndex2 = 0;
		boolean flag = false;
		for (int i = 0; i < text.length(); i += 2) {
			for (int j = 0; j < key.length; j++) {
				if (key[j].indexOf(text.charAt(firstIndex)) != -1
						&& key[j].indexOf(text.charAt(secondIndex)) != -1) {
					position1 = key[j].indexOf(text.charAt(firstIndex));
					position2 = key[j].indexOf(text.charAt(secondIndex));
					if (position1 - 1 < 0) {
						position1 = key[j].length();
					}
					if (position2 - 1 < 0) {
						position2 = key[j].length();
					}
					newText += key[j].charAt(position1 - 1);
					newText += key[j].charAt(position2 - 1);
					flag = true;
					break;
				} else {
					for (int k = 0; k < key.length; k++) {
						if (key[k].indexOf(text.charAt(firstIndex)) != -1) {
							position1 = key[k].indexOf(text.charAt(firstIndex));
							wordIndex1 = k;
						}
						if (key[k].indexOf(text.charAt(secondIndex)) != -1) {
							position2 = key[k].indexOf(text.charAt(secondIndex));
							wordIndex2 = k;
						}
					}
					if (position1 != position2) {
						newText += key[wordIndex2].charAt(position1);
						newText += key[wordIndex1].charAt(position2);
						flag = true;
						break;
					}
					if (wordIndex1 - 1 < 0) {
						wordIndex1 = key.length;
					}
					if (wordIndex2 - 1 < 0) {
						wordIndex2 = key.length;
					}
					if (position1 == position2) {
						newText += key[wordIndex1 -1].charAt(position1);
						newText += key[wordIndex2 -1].charAt(position2);
						flag = true;
						break;
					} 
				}
			}
			if (flag) {
				firstIndex += 2;
				secondIndex += 2;
				flag = false;
			}
		}
		return newText;
	}

}
