package net.rayfall.eyesniper2.skrayfall.citizens.conditions;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.DocumentationId;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.RequiredPlugins;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPCRegistry;

import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

@Name("Citizen is")
@Description("Checks if a citizen has a certain ID.")
@RequiredPlugins("Citizens")
@DocumentationId("CondCitizenIs")
public class CondIsNpcIdGeneral extends Condition {

    // %entity% is (citizen|npc) %number%

    private Expression<Entity> test;
    private Expression<Number> id;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exp, int arg1, Kleenean arg2, ParseResult arg3) {
        test = (Expression<Entity>) exp[0];
        id = (Expression<Number>) exp[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event arg0, boolean arg1) {
        return null;
    }

    @Override
    public boolean check(Event evt) {
        if (test.getSingle(evt) != null && id.getSingle(evt) != null
                && test.getSingle(evt).hasMetadata("NPC")) {
            NPCRegistry registry = CitizensAPI.getNPCRegistry();
            return registry.getNPC(test.getSingle(evt)).getId() == id.getSingle(evt).intValue();
        } else {
            return false;
        }
    }

}
