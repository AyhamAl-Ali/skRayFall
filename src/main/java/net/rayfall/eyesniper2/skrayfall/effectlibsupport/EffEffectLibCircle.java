package net.rayfall.eyesniper2.skrayfall.effectlibsupport;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

import de.slikey.effectlib.effect.CircleEffect;
import de.slikey.effectlib.util.DynamicLocation;
import de.slikey.effectlib.util.ParticleEffect;

import net.rayfall.eyesniper2.skrayfall.Core;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

@Name("Circle Effect")
@Description("Creates an EffectLib circle effect.")
public class EffEffectLibCircle extends Effect {

    // (spawn|create|apply) (a|the|an) circle (effect|formation) (at|on|for) %entity/location% with id
    // %string% [with particle[s] %-effectlibparticle%] [(and|with) radius %-number%]

    private Expression<?> target;
    private Expression<String> id;
    private Expression<ParticleEffect> particle;
    private Expression<Number> rad;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exp, int arg1, Kleenean arg2, ParseResult arg3) {
        target = exp[0];
        id = (Expression<String>) exp[1];
        particle = (Expression<ParticleEffect>) exp[2];
        rad = (Expression<Number>) exp[3];
        return true;
    }

    @Override
    public String toString(@Nullable Event arg0, boolean arg1) {
        return null;
    }

    @Override
    protected void execute(Event evt) {
        Object tar = target.getSingle(evt);
        CircleEffect effect = new CircleEffect(Core.effectManager);
        if (tar instanceof Entity) {
            effect.setDynamicOrigin(new DynamicLocation((Entity) tar));
        } else if (tar instanceof Location) {
            effect.setDynamicOrigin(new DynamicLocation((Location) tar));
        } else {
            assert false;
        }
        if (particle != null) {
            effect.particle = particle.getSingle(evt);
        }
        if (rad != null) {
            effect.radius = rad.getSingle(evt).floatValue();
        }
        effect.infinite();
        effect.start();
        Boolean check = Core.rayfallEffectManager.setEffect(effect, id.getSingle(evt).replace("\"", ""));
        if (!check) {
            effect.cancel();
        }
    }
}
