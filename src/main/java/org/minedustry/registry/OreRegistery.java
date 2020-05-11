package org.minedustry.registry;

import java.util.ArrayList;
import java.util.List;

public class OreRegistery {
	
	public static final Ore PLATINUM = new Ore("platinum");
	public static final Ore COBALT   = new Ore("cobalt");
    public static final Ore THORIUM  = new Ore("thorium");
	public static final Ore TITANIUM  = new Ore("titanium");
    public static final Ore BISMUTH  = new Ore("bismuth", "chunk");
	
	public static final List<Ore> ORES = new ArrayList<>();
	
	static {
		reg(PLATINUM);
		reg(COBALT);
		reg(THORIUM);
		reg(TITANIUM);
		reg(BISMUTH);
	}
	
	public static void reg(Ore ore) { ORES.add(ore); }

}
