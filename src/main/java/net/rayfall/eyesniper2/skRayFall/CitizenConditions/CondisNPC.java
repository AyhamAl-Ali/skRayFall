package net.rayfall.eyesniper2.skRayFall.CitizenConditions;

import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class CondisNPC extends Condition{
	
	//%entity% is [a] (npc|citizen)
	
	private Expression<Entity> ent;

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] e, int arg1, Kleenean arg2,
			ParseResult arg3) {
		ent = (Expression<Entity>) e[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event arg0, boolean arg1) {
		return null;
	}

	@Override
	public boolean check(Event evt) {
		if(ent.getSingle(evt).hasMetadata("NPC")){
			return true;
		}
		else{
			return false;
		}
	}

}
