package me.rusty.rustycore.enums;

public enum Mode {
	
	Maintenance,
	Beta,
	Online;
	
	private static Mode current;
	
	public static Mode getMode() {
		
		return current;
		
	}
	
	public static void setMode(Mode current) {
		
		Mode.current = current;
		
	}
	
}
