package main;

public class MenuFunction{
	private String menuNum;
	private String menuOptionText;
	
	public MenuFunction(String menuNum, String menuOptionText) {
		this.menuNum = menuNum;
		this.menuOptionText = menuOptionText;
	}

	public String getMenuNum() {
		return menuNum;
	}

	public String getMenuOptionText() {
		return menuOptionText;
	}


	@Override
	public String toString() {
		return "[" + menuNum + "] " + menuOptionText;
	}

}