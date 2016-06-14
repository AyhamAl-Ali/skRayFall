package net.rayfall.eyesniper2.skRayFall;


import java.io.IOException;

import net.citizensnpcs.api.event.NPCDeathEvent;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.coreprotect.CoreProtect;
import net.coreprotect.CoreProtectAPI;
import net.gravitydevelopment.updater.Updater;
import net.gravitydevelopment.updater.Updater.UpdateResult;
import net.rayfall.eyesniper2.skRayFall.BossBar.BossBarManager;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffBossBarAddFlag;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffBossBarHide;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffBossBarRemoveFlag;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffBossBarShow;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffChangeBossBarColor;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffChangeBossBarStyle;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffChangeBossBarTitle;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffChangeBossBarValue;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffCreateModernBossBar;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffDeleteModernBossBar;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffRemovePlayerFromBossBar;
import net.rayfall.eyesniper2.skRayFall.BossBar.EffSetBossBar;
import net.rayfall.eyesniper2.skRayFall.BossBar.ExprBossBarTitle;
import net.rayfall.eyesniper2.skRayFall.BossBar.ExprBossBarValue;
import net.rayfall.eyesniper2.skRayFall.BossBar.skRayFallBarColor;
import net.rayfall.eyesniper2.skRayFall.BossBar.skRayFallBarFlag;
import net.rayfall.eyesniper2.skRayFall.BossBar.skRayFallBarStyle;
import net.rayfall.eyesniper2.skRayFall.BossBarAPI.EffCreateBossBar;
import net.rayfall.eyesniper2.skRayFall.BossBarAPI.EffDeleteBossBar;
import net.rayfall.eyesniper2.skRayFall.BossBarAPI.EffTimedBossBar;
import net.rayfall.eyesniper2.skRayFall.BossBarAPI.ExprBaseBossBar;
import net.rayfall.eyesniper2.skRayFall.Capes.EffRemoveCape;
import net.rayfall.eyesniper2.skRayFall.Capes.EffWearCape;
import net.rayfall.eyesniper2.skRayFall.CitizenConditions.CondisNPC;
import net.rayfall.eyesniper2.skRayFall.CitizenConditions.CondisNPCIdGeneral;
import net.rayfall.eyesniper2.skRayFall.CitizenConditions.CondisNPCNamed;
import net.rayfall.eyesniper2.skRayFall.CitizenConditions.CondisNPCid;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenAttack;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenHold;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenLookTarget;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenMove;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenNameVisable;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenSetCrouch;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenSetMaxHealth;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenSetSkin;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenSleep;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenSpeak;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenSwing;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenToggleCrouch;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCitizenVulnerablity;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffCreateCitizen;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffDeleteCitizen;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffDespawnCitizen;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffEquipCitizen;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffGiveLookCloseTrait;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffSentryFollowDistance;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffSentryProtect;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffSentryStopFollow;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffSetCitizenName;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffSpawnCitizen;
import net.rayfall.eyesniper2.skRayFall.CitizenEffects.EffStartBuilderBuild;
import net.rayfall.eyesniper2.skRayFall.CitizenExpressions.ExprBottomRightSchematic;
import net.rayfall.eyesniper2.skRayFall.CitizenExpressions.ExprCitizenIDFromEntity;
import net.rayfall.eyesniper2.skRayFall.CitizenExpressions.ExprGeneralCitizen;
import net.rayfall.eyesniper2.skRayFall.CitizenExpressions.ExprLastCitizen;
import net.rayfall.eyesniper2.skRayFall.CitizenExpressions.ExprNameOfCitizen;
import net.rayfall.eyesniper2.skRayFall.CitizenExpressions.ExprOwnerOfCitizen;
import net.rayfall.eyesniper2.skRayFall.CitizenExpressions.ExprTopLeftSchematic;
import net.rayfall.eyesniper2.skRayFall.Commands.GeneralCommands;
import net.rayfall.eyesniper2.skRayFall.CoreProtect.CondIsNOTNaturalCP;
import net.rayfall.eyesniper2.skRayFall.CoreProtect.CondIsNaturalCP;
import net.rayfall.eyesniper2.skRayFall.CrackShotEffects.EffPlaceMine;
import net.rayfall.eyesniper2.skRayFall.CrackShotEvents.EvtScope;
import net.rayfall.eyesniper2.skRayFall.CrackShotEvents.EvtUnscope;
import net.rayfall.eyesniper2.skRayFall.CrackShotExpressions.ExprCrackShotWeapon;
import net.rayfall.eyesniper2.skRayFall.EffectLibSupport.EffDeleteEffect;
import net.rayfall.eyesniper2.skRayFall.EffectLibSupport.EffEffectLibAnimatedBallEffect;
import net.rayfall.eyesniper2.skRayFall.EffectLibSupport.EffEffectLibArc;
import net.rayfall.eyesniper2.skRayFall.EffectLibSupport.EffEffectLibAtom;
import net.rayfall.eyesniper2.skRayFall.EffectLibSupport.EffEffectLibBleed;
import net.rayfall.eyesniper2.skRayFall.EffectLibSupport.EffEffectLibCircle;
import net.rayfall.eyesniper2.skRayFall.EffectLibSupport.EffEffectLibLine;
import net.rayfall.eyesniper2.skRayFall.EffectLibSupport.EffEffectLibText;
import net.rayfall.eyesniper2.skRayFall.EffectLibSupport.EffEffectLibWave;
import net.rayfall.eyesniper2.skRayFall.EffectLibSupport.EffEffectTornado;
import net.rayfall.eyesniper2.skRayFall.EffectLibSupport.skRayFallEffectManager;
import net.rayfall.eyesniper2.skRayFall.GeneralEffects.EffFakeFakeLightning;
import net.rayfall.eyesniper2.skRayFall.GeneralEffects.EffMakePlayerGlow;
import net.rayfall.eyesniper2.skRayFall.GeneralEffects.EffMaxHealth;
import net.rayfall.eyesniper2.skRayFall.GeneralEffects.EffPlayResourcePackSound;
import net.rayfall.eyesniper2.skRayFall.GeneralEffects.EffPlaySoundPacket;
import net.rayfall.eyesniper2.skRayFall.GeneralEffects.EffSetMetaData;
import net.rayfall.eyesniper2.skRayFall.GeneralEffects.EffSetPlayerListName;
import net.rayfall.eyesniper2.skRayFall.GeneralEffects.EffUnglowPlayer;
import net.rayfall.eyesniper2.skRayFall.GeneralEvents.ArmorStandDamageEvent;
import net.rayfall.eyesniper2.skRayFall.GeneralEvents.ArmorStandListener;
import net.rayfall.eyesniper2.skRayFall.GeneralEvents.EvtCraftClick;
import net.rayfall.eyesniper2.skRayFall.GeneralEvents.StoreEvent;
import net.rayfall.eyesniper2.skRayFall.GeneralEvents.StoreListener;
import net.rayfall.eyesniper2.skRayFall.GeneralEvents.UnstoreEvent;
import net.rayfall.eyesniper2.skRayFall.GeneralExpressions.ExprAbsoluteInventoryCount;
import net.rayfall.eyesniper2.skRayFall.GeneralExpressions.ExprArmorValue;
import net.rayfall.eyesniper2.skRayFall.GeneralExpressions.ExprMetaData;
import net.rayfall.eyesniper2.skRayFall.GeneralExpressions.ExprNoNBT;
import net.rayfall.eyesniper2.skRayFall.GeneralExpressions.ExprNumberOfEnchants;
import net.rayfall.eyesniper2.skRayFall.GeneralExpressions.ExprPlayerGlowing;
import net.rayfall.eyesniper2.skRayFall.GeneralExpressions.ExprShinyItem;
import net.rayfall.eyesniper2.skRayFall.GeneralExpressions.ExprSpecificEnchantIndex;
import net.rayfall.eyesniper2.skRayFall.GeneralExpressions.ExprTextToLocation;
import net.rayfall.eyesniper2.skRayFall.Holograms.CondHologramExists;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffBoundClientSideHoloObject;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffBoundHoloObject;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffCreateInteractiveStaticClientSideHolograms;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffCreateInteractiveStaticHolograms;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffCreateStaticClientHoloObject;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffCreateStaticHoloObject;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffDeleteHoloObject;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffDeleteHoloObjectLine;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffEditHoloObject;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffEditHoloObjectLine;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffTimedBindedHolo;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffTimedClientSideHolo;
import net.rayfall.eyesniper2.skRayFall.Holograms.EffTimedHologram;
import net.rayfall.eyesniper2.skRayFall.Holograms.ExprGetHoloLine;
import net.rayfall.eyesniper2.skRayFall.Holograms.HoloManager;
import net.rayfall.eyesniper2.skRayFall.Holograms.HoloPickupEvent;
import net.rayfall.eyesniper2.skRayFall.Holograms.HoloTouchEvent;
import net.rayfall.eyesniper2.skRayFall.Particles.EffClientsideStaticParticles;
import net.rayfall.eyesniper2.skRayFall.Particles.EffStaticParticles;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.CondisScoreboardSet;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffAddPlayerToGroupID;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffCreateGroupIDScore;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffDeleteIdScore;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffDeleteScore;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffEditGroupIDScore;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffEditIDScore;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffNameOfScore;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffRemovePlayerFromIDScore;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffRemoveScoreBelowName;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffRemoveScoreTab;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffRemoveScoreboard;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffSetIDBasedScore;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffSetScore;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffSetScoreBelowName;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.EffSetScoreTab;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.ExprScoreBoardTitle;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.ExprScoreNameFromGroupID;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.ExprScoreNameFromID;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.ExprScoreValueFromGroupID;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.ExprScoreValueFromID;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.IDScoreBoardManager;
import net.rayfall.eyesniper2.skRayFall.Scoreboard.RemoveGroupIDScore;
import net.rayfall.eyesniper2.skRayFall.Teams.TeamManager;
import net.rayfall.eyesniper2.skRayFall.Teams.V1_9.Eff1_9MessageOnDeathRule;
import net.rayfall.eyesniper2.skRayFall.Teams.V1_9.Eff1_9NameTagVisibility;
import net.rayfall.eyesniper2.skRayFall.Teams.V1_9.Eff1_9TeamCollisionRule;
import net.rayfall.eyesniper2.skRayFall.V1_10.EffActionBarV1_10;
import net.rayfall.eyesniper2.skRayFall.V1_10.EffParticlesV1_10;
import net.rayfall.eyesniper2.skRayFall.V1_10.EffTabTitlesV1_10;
import net.rayfall.eyesniper2.skRayFall.V1_10.EffTitleV1_10;
import net.rayfall.eyesniper2.skRayFall.V1_8.EffActionBarV1_8;
import net.rayfall.eyesniper2.skRayFall.V1_8.EffParticlesV1_8;
import net.rayfall.eyesniper2.skRayFall.V1_8.EffTabTitlesV1_8;
import net.rayfall.eyesniper2.skRayFall.V1_8.EffTitleV1_8;
import net.rayfall.eyesniper2.skRayFall.V1_8_3.EffActionBarV1_8_3;
import net.rayfall.eyesniper2.skRayFall.V1_8_3.EffParticlesV1_8_3;
import net.rayfall.eyesniper2.skRayFall.V1_8_3.EffTabTitlesV1_8_3;
import net.rayfall.eyesniper2.skRayFall.V1_8_3.EffTitleV1_8_3;
import net.rayfall.eyesniper2.skRayFall.V1_8_4.EffActionBarV1_8_4;
import net.rayfall.eyesniper2.skRayFall.V1_8_4.EffParticlesV1_8_4;
import net.rayfall.eyesniper2.skRayFall.V1_8_4.EffTabTitlesV1_8_4;
import net.rayfall.eyesniper2.skRayFall.V1_8_4.EffTitleV1_8_4;
import net.rayfall.eyesniper2.skRayFall.V1_9.EffActionBarV1_9;
import net.rayfall.eyesniper2.skRayFall.V1_9.EffParticlesV1_9;
import net.rayfall.eyesniper2.skRayFall.V1_9.EffTabTitlesV1_9;
import net.rayfall.eyesniper2.skRayFall.V1_9.EffTitleV1_9;
import net.rayfall.eyesniper2.skRayFall.V1_9_4.EffActionBarV1_9_4;
import net.rayfall.eyesniper2.skRayFall.V1_9_4.EffParticlesV1_9_4;
import net.rayfall.eyesniper2.skRayFall.V1_9_4.EffTabTitlesV1_9_4;
import net.rayfall.eyesniper2.skRayFall.V1_9_4.EffTitleV1_9_4;
import net.rayfall.eyesniper2.skRayFall.Voting.RayFallOfflineVoteEvent;
import net.rayfall.eyesniper2.skRayFall.Voting.RayFallVoteEvent;
import net.rayfall.eyesniper2.skRayFall.Voting.RayFallVoteListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team.OptionStatus;
import org.eclipse.jdt.annotation.Nullable;
import org.mcstats.Metrics;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;
import com.shampaggon.crackshot.events.WeaponReloadCompleteEvent;
import com.shampaggon.crackshot.events.WeaponReloadEvent;
import com.shampaggon.crackshot.events.WeaponScopeEvent;
import com.shampaggon.crackshot.events.WeaponShootEvent;

import ch.njol.skript.Skript;
import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.Classes;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.util.ParticleEffect;

@SuppressWarnings("deprecation")
public class skRayFall extends JavaPlugin implements Listener {
	
	public static EffectManager effectManager;
	public static Plugin plugin = null;
	public static skRayFallEffectManager effLibManager;
	public static IDScoreBoardManager sbManager;
	public boolean enableFastScoreboards = true;
	public static CoreProtectAPI skCoreProtect = null;
	public static TeamManager teamManager;
	public static BossBarManager bossbarManager;
	
	 @Override
	    public void onEnable() {
		 getLogger().info("Yay! You are running skRayFall " + this.getDescription().getVersion() + "!");
		 getLogger().info("Nathan and Lewis <3 you.");
		 getServer().getPluginManager().registerEvents(this, this);
		 Skript.registerAddon(this);
		 saveDefaultConfig();
		 this.getCommand("skrayfall").setExecutor(new GeneralCommands(this));
		 if (plugin == null){
			 plugin = this;
		 }
		 getLogger().info("Cooking Bacon...");
		 try {
		        Metrics metrics = new Metrics(this);
		        metrics.start();
		    } catch (IOException e) {
		        getLogger().info("MCStats had an issue :/ " + e.getMessage() + "This will not affect anything. *Server gets moar bacon*");
		    }
		 if(Skript.isAcceptRegistrations()){
			 regesterElements();
			 if (Bukkit.getVersion().contains("1.9")||Bukkit.getVersion().contains("1.10")){
				 regesterV1_9Elements();
				 if(!(Bukkit.getVersion().contains("(MC: 1.9)") || Bukkit.getVersion().contains("(MC: 1.9.1)"))){
					 regesterV1_9_2Elements();
				 }
				 else{
					 regesterNon1_9_2TeamElements();
				 }
			 }
			 else{
				 regesterNon1_9_2TeamElements();
			 }
		 }
		 else{
			 getLogger().info("skRayFall was unable to register some extra types.");
		 }
		 if (getServer().getPluginManager().isPluginEnabled("Citizens"))
		    {
			 getLogger().info("Getting more bacon for the army of citizens...");
			 Skript.registerEffect(EffCreateCitizen.class,"create [a] citizen named %string% (at|%direction%) %location% [as (a|an) %entitytypes%]");
			 Skript.registerEffect(EffCitizenMove.class,"move citizen %number% to %location% [at speed %number%]");
			 Skript.registerEffect(EffDespawnCitizen.class,"despawn citizen %number%");
			 Skript.registerEffect(EffEquipCitizen.class,"(equip|give) citizen %number% with [an] %itemstack%");
			 Skript.registerEffect(EffCitizenHold.class, "make citizen %number% hold [an] %itemstack%");
			 Skript.registerEffect(EffSpawnCitizen.class,"respawn citizen %number% (at|%direction%) %location%");
			 Skript.registerEffect(EffDeleteCitizen.class,"(remove|destroy) citizen %number%");
			 Skript.registerEffect(EffCitizenSpeak.class,"make citizen %number% (say|communicate) %string% to %livingentities%");
			 Skript.registerEffect(EffSetCitizenName.class,"(set|make) citizen[s] %number% name to %string%");
			 Skript.registerEffect(EffCitizenSetMaxHealth.class,"(set|make) citizen[s] %number% max health [to] %number%");
			 //doesn't work
			 Skript.registerEffect(EffCitizenNameVisable.class,"(set|make) citizen[s] %number% nametag (1Šinvisible|0Švisible)");
			 Skript.registerEffect(EffCitizenLookTarget.class,"make citizen %number% look at %location%");
			 Skript.registerEffect(EffCitizenAttack.class,"make citizen %number% (attack|fight) %entity%");
			 //buggy
			 Skript.registerEffect(EffCitizenSetSkin.class,"change citizen %number% skin to %string%");
			 Skript.registerEffect(EffGiveLookCloseTrait.class, "(give|set) npc %number% the look close trait");
			 Skript.registerEffect(EffCitizenVulnerablity.class,"make citizen %number% (1Šinvulnerable|0Švulnerable)");
			 Skript.registerEffect(EffCitizenSleep.class, "(make|force) (npc|citizen) with id %number% to sleep", "(make|force) (npc|citizen) with id %number% to wake [up]");
			 Skript.registerEffect(EffCitizenSetCrouch.class, "(set|make) citizen %number% [to] [be] crouch[ed]", "(set|make) citizen %number% [to] [be] uncrouch[ed]");
			 Skript.registerEffect(EffCitizenToggleCrouch.class, "toggle citizen %number%['s] crouch");
			 Skript.registerEffect(EffCitizenSwing.class, "make citizen %number% swing [arm]");
			 Skript.registerExpression(ExprLastCitizen.class, Number.class, ExpressionType.SIMPLE, "last created citizen [id]");
			 Skript.registerExpression(ExprNameOfCitizen.class, String.class, ExpressionType.SIMPLE, "name of citizen %number%");
			 Skript.registerExpression(ExprCitizenIDFromEntity.class, Number.class, ExpressionType.SIMPLE, "citizen id of %entity%");
			 Skript.registerExpression(ExprGeneralCitizen.class, Entity.class, ExpressionType.PROPERTY, "citizen %number%");
			 Skript.registerExpression(ExprOwnerOfCitizen.class, String.class, ExpressionType.PROPERTY, "owner of (citizen|npc) %number%");
			 Skript.registerEvent("NPC/Citizen Right Click", SimpleEvent.class, NPCRightClickEvent.class,"(NPC|Citizen) right click");
			 EventValues.registerEventValue(NPCRightClickEvent.class, Player.class, new Getter<Player, NPCRightClickEvent>() {
		            @Override
		            public Player get(NPCRightClickEvent NPCRightClickEvent) {
		                return NPCRightClickEvent.getClicker();
		            }
		        }, 0);
			 EventValues.registerEventValue(NPCRightClickEvent.class, NPC.class, new Getter<NPC, NPCRightClickEvent>() {
		            @Override
		            public NPC get(NPCRightClickEvent NPCRightClickEvent) {
		                return NPCRightClickEvent.getNPC();
		            }
		        }, 0);
			 EventValues.registerEventValue(NPCRightClickEvent.class, Number.class, new Getter<Number, NPCRightClickEvent>() {
		            @Override
		            public Number get(NPCRightClickEvent NPCRightClickEvent) {
		                return NPCRightClickEvent.getNPC().getId();
		            }
		        }, 0);
			 Skript.registerEvent("NPC/Citizen Left Click", SimpleEvent.class, NPCLeftClickEvent.class,"(NPC|Citizen) left click");
			 EventValues.registerEventValue(NPCLeftClickEvent.class, Player.class, new Getter<Player, NPCLeftClickEvent>() {
		            @Override
		            public Player get(NPCLeftClickEvent NPCLeftClickEvent) {
		                return NPCLeftClickEvent.getClicker();
		            }
		        }, 0);
			 EventValues.registerEventValue(NPCLeftClickEvent.class, NPC.class, new Getter<NPC, NPCLeftClickEvent>() {
		            @Override
		            public NPC get(NPCLeftClickEvent NPCLeftClickEvent) {
		                return NPCLeftClickEvent.getNPC();
		            }
		        }, 0);
			 EventValues.registerEventValue(NPCLeftClickEvent.class, Number.class, new Getter<Number, NPCLeftClickEvent>() {
		            @Override
		            public Number get(NPCLeftClickEvent NPCLeftClickEvent) {
		                return NPCLeftClickEvent.getNPC().getId();
		            }
		        }, 0);
			 Skript.registerEvent("NPC/Citizen Death", SimpleEvent.class, NPCDeathEvent.class,"(NPC|Citizen) death");
			 EventValues.registerEventValue(NPCDeathEvent.class, NPC.class, new Getter<NPC, NPCDeathEvent>() {
		            @Override
		            public NPC get(NPCDeathEvent NPCDeathEvent) {
		                return NPCDeathEvent.getNPC();
		            }
		        }, 0);
			 Skript.registerCondition(CondisNPCid.class, "(NPC|Citizen) is %number%");
			 Skript.registerCondition(CondisNPCIdGeneral.class, "%entity% is (citizen|npc) %number%");
			 Skript.registerCondition(CondisNPCNamed.class, "(NPC|Citizen)['s] [is] name[d] [is] %string%");
			 Skript.registerCondition(CondisNPC.class, "%entity% is [a] (npc|citizen)");
			 if(getServer().getPluginManager().isPluginEnabled("Builder")){
				 getLogger().info("Getting bacon sandwiches for builders!");
				 Skript.registerEffect(EffStartBuilderBuild.class, "make citizen %number% build %string% at %location% [speed %number%] for %player%");
				 Skript.registerExpression(ExprTopLeftSchematic.class, Location.class, ExpressionType.SIMPLE, "for builder %number% get the location of the top left of schematic centered at %location%");
				 Skript.registerExpression(ExprBottomRightSchematic.class, Location.class, ExpressionType.SIMPLE, "for builder %number% get the location of the bottom right of schematic centered at %location%");
			 }
			 if(getServer().getPluginManager().isPluginEnabled("Sentry")){
				 getLogger().info("Roasting bacon for Sentry's!");
				 Skript.registerEffect(EffSentryProtect.class, "set citizen %number% to protect %player%");
				 Skript.registerEffect(EffSentryStopFollow.class, "make sentry %number% stop following");
				 Skript.registerEffect(EffSentryFollowDistance.class, "set follow[ distance] of citizen %number% to %number%");
			 }
		    }
		 else{
		      getLogger().info("Citizens not found! Sorry you cant make friends, but don't worry we will still be your friend <3");   
		 }
		 //All EffectLib Stuff!
			 getLogger().info("Got bacon for the EffectLib partical ninjas!");
			 effLibManager = new skRayFallEffectManager(this);
			 effectManager = new EffectManager(this);
			 //more stuff and options to be added
			 Skript.registerEffect(EffDeleteEffect.class, "(delete|stop) (effect|formation) %string%");
			 Skript.registerEffect(EffEffectLibAtom.class, "(spawn|create|apply) (a|the|an) atom (effect|formation) (at|on|for|to) %entity/location% with id %string%");
			 Skript.registerEffect(EffEffectLibBleed.class, "(spawn|create|apply) (a|the|an) bleed (effect|formation) (at|on|for|to) %entity/location% with id %string%");
			 Skript.registerEffect(EffEffectLibText.class, "(spawn|create|apply) (a|the|an) text (effect|formation) with text %string% as %effectlibparticle% (at|on|for|to) %entities/location% with id %string%[(,| and) %number% large]");
			 Skript.registerEffect(EffEffectLibAnimatedBallEffect.class, "(spawn|create|apply) (a|the|an) animated ball (effect|formation) (at|on|for|to) %entity/location% with id %string% [with particle %-effectlibparticle%] [offset by %number%, %number%(,| and) %number%]");
			 Skript.registerEffect(EffEffectLibArc.class, "(spawn|create|apply) (a|the|an) arc (effect|formation) from %entity/location% to %entity/location% with id %string% [with particle[s] %-effectlibparticle%] [%number% high] [and %number% particles]");
			 Skript.registerEffect(EffEffectLibWave.class, "(spawn|create|apply) (a|the|an) wave (effect|formation) at %entity/location% with id %string% [with particle[s] %-effectlibparticle%]");
			 Skript.registerEffect(EffEffectLibLine.class, "(spawn|create|apply) (a|the|an) line (effect|formation) from %entity/location% to %entity/location% with id %string% [with particle[s] %-effectlibparticle%]");
			 Skript.registerEffect(EffEffectLibCircle.class, "(spawn|create|apply) (a|the|an) circle (effect|formation) (at|on|for) %entity/location% with id %string% [with particle[s] %-effectlibparticle%] [(and|with) radius %-number%]");
			 Skript.registerEffect(EffStaticParticles.class, "(create|display|show) %number% [of] %effectlibparticle% particle[s] at %location% [(with data of %-itemstack%|with color %number%, %number%(,| and) %number%)] [offset by %number%, %number%(,| and) %number%] [(with|at) speed %number%]");
			 Skript.registerEffect(EffClientsideStaticParticles.class, "(create|display|show) %number% [of] %effectlibparticle% particle[s] at %location% for %player% [with data of %-itemstack%] [offset by %number%, %number%(,| and) %number%] [(with|at) speed %number%]");
			 Skript.registerEffect(EffEffectTornado.class, "(spawn|create|apply) (a|the|an) tornado (effect|formation) at %entity/location% with id %string% [with tornado particle[s] %-effectlibparticle% and cloud particle[s] %-effectlibparticle%] [(set|and) radius %number%] [(set|and) max height %number%]");
			 //Skript.registerEffect(EffEffectLibUpwardsSpiral.class, "(spawn|create|apply) (a|the|an) upward[s] spiral (effect|formation) (at|on|for|to) %entity/location% with id %string%");
		
		//Votifier Stuff 
		 if (getServer().getPluginManager().isPluginEnabled("Votifier")){
			 getLogger().info("Getting more bacon for the Votifier runners!");
			 new RayFallVoteListener(this);
			 Skript.registerEvent("On Vote", SimpleEvent.class, RayFallVoteEvent.class, "vote[ing]");
			 EventValues.registerEventValue(RayFallVoteEvent.class, Player.class, new Getter<Player, RayFallVoteEvent>() {
				    @Nullable
		            @Override
		            public Player get(RayFallVoteEvent evt) {
		            	return evt.getPlayer();
		            }
		        }, 0);
			 EventValues.registerEventValue(RayFallVoteEvent.class, String.class, new Getter<String, RayFallVoteEvent>() {
				    @Nullable
		            @Override
		            public String get(RayFallVoteEvent evt) {
		            	return evt.getSite();
		            }
		        }, 0);
			 Skript.registerEvent("On Offline Vote", SimpleEvent.class, RayFallOfflineVoteEvent.class, "offline vote[ing]");
			 EventValues.registerEventValue(RayFallOfflineVoteEvent.class, Player.class, new Getter<Player, RayFallOfflineVoteEvent>() {
				    @Nullable
		            @Override
		            public Player get(RayFallOfflineVoteEvent evt) {
		            	return evt.getPlayer();
		            }
		        }, 0);
			 EventValues.registerEventValue(RayFallOfflineVoteEvent.class, String.class, new Getter<String, RayFallOfflineVoteEvent>() {
				    @Nullable
		            @Override
		            public String get(RayFallOfflineVoteEvent evt) {
		            	return evt.getSite();
		            }
		        }, 0);
		 }
		 else{
			 getLogger().info("No Votifier Found! *Checks oven for finished bacon*");
		 }
		 //Holograms
		 if (getServer().getPluginManager().isPluginEnabled("HolographicDisplays")){
				getLogger().info("Bacon holograms found");
				Skript.registerEffect(EffTimedHologram.class, "create hologram %string% at %location% for %timespan%");
				Skript.registerEffect(EffTimedBindedHolo.class, "bind hologram %string% to %entity% for %timespan% [offset by %number%, %number%( and|,) %number%]");
				Skript.registerEffect(EffCreateStaticHoloObject.class, "create holo object %string% with id %string% at %location%");
				Skript.registerEffect(EffDeleteHoloObject.class, "delete holo object %string%");
				Skript.registerEffect(EffCreateInteractiveStaticHolograms.class, "create interactive holo object %string% with id %string% at %location%");
				Skript.registerEffect(EffDeleteHoloObject.class, "delete holo object %string%");
				Skript.registerEffect(EffEditHoloObject.class, "edit holo object %string% to %string% [and set interactivity to %-boolean%]");
				Skript.registerEffect(EffBoundHoloObject.class, "create bound holo object %string% with id %string% to %entity% [offset by %number%, %number%( and|,) %number%]");
				Skript.registerEffect(EffEditHoloObjectLine.class, "edit holo object %string% [with] line [number] %number% to %string% [and set interactivity to %-boolean%]");
				Skript.registerEffect(EffDeleteHoloObjectLine.class, "(delete|remove) line %number% in holo object %string%");
				Skript.registerCondition(CondHologramExists.class, "(holo object|hologram) %string% exists");
				Skript.registerEvent("hologram (touch|click)", SimpleEvent.class, HoloTouchEvent.class, "hologram (touch|click)");
				Skript.registerExpression(ExprGetHoloLine.class, String.class, ExpressionType.SIMPLE, "text in line %number% of holo[gram] [object] %string%");
				EventValues.registerEventValue(HoloTouchEvent.class, String.class, new Getter<String, HoloTouchEvent>() {
				    @Nullable
		            @Override
		            public String get(HoloTouchEvent evt) {
		            	return evt.getHoloID();
		            }
		        }, 0);
				EventValues.registerEventValue(HoloTouchEvent.class, Number.class, new Getter<Number, HoloTouchEvent>() {
				    @Nullable
		            @Override
		            public Number get(HoloTouchEvent evt) {
		            	return evt.getLineNumber();
		            }
		        }, 0);
				EventValues.registerEventValue(HoloTouchEvent.class, Player.class, new Getter<Player, HoloTouchEvent>() {
				    @Nullable
		            @Override
		            public Player get(HoloTouchEvent evt) {
		            	return evt.getPlayer();
		            }
		        }, 0);
				Skript.registerEvent("hologram pickup", SimpleEvent.class, HoloPickupEvent.class, "hologram pickup");
				EventValues.registerEventValue(HoloPickupEvent.class, String.class, new Getter<String, HoloPickupEvent>() {
				    @Nullable
		            @Override
		            public String get(HoloPickupEvent evt) {
		            	return evt.getHoloID();
		            }
		        }, 0);
				EventValues.registerEventValue(HoloPickupEvent.class, Number.class, new Getter<Number, HoloPickupEvent>() {
				    @Nullable
		            @Override
		            public Number get(HoloPickupEvent evt) {
		            	return evt.getLineNumber();
		            }
		        }, 0);
				EventValues.registerEventValue(HoloPickupEvent.class, Player.class, new Getter<Player, HoloPickupEvent>() {
				    @Nullable
		            @Override
		            public Player get(HoloPickupEvent evt) {
		            	return evt.getPlayer();
		            }
		        }, 0);
				if (getServer().getPluginManager().isPluginEnabled("ProtocolLib")){
					getLogger().info("Client Side bacon holograms enabled");
					Skript.registerEffect(EffCreateInteractiveStaticClientSideHolograms.class, "create interactive client side holo object %string% with id %string% at %location% to %player%");
					Skript.registerEffect(EffTimedClientSideHolo.class, "display hologram %string% at %location% to %player% for %timespan%");
					Skript.registerEffect(EffCreateStaticClientHoloObject.class, "create client side holo object %string% with id %string% at %location% to %player%");
					Skript.registerEffect(EffBoundClientSideHoloObject.class, "create client side bound holo object %string% with id %string% to %entity% for %player% [offset by %number%, %number%( and|,) %number%]");
				}
		}
		 //CrackShot Stuff
		 if (getServer().getPluginManager().isPluginEnabled("CrackShot")){
			 getLogger().info("Giving CrackShot snipers bacon.");
			 Skript.registerExpression(ExprCrackShotWeapon.class, ItemStack.class, ExpressionType.SIMPLE, "(gun|crackshot weapon) %string%");
			 Skript.registerEffect(EffPlaceMine.class, "(place|set|spawn) mine at %location% for %player% as %string%");
			 Skript.registerEvent("(crackshot|weapon|gun) shoot", SimpleEvent.class, WeaponShootEvent.class,"(crackshot|weapon|gun) shoot");
			 EventValues.registerEventValue(WeaponShootEvent.class, Player.class, new Getter<Player, WeaponShootEvent>() {
				    @Nullable
		            @Override
		            public Player get(WeaponShootEvent evt) {
		            	return evt.getPlayer();
		            }
		        }, 0);
			 EventValues.registerEventValue(WeaponShootEvent.class, Entity.class, new Getter<Entity, WeaponShootEvent>() {
				    @Nullable
		            @Override
		            public Entity get(WeaponShootEvent evt) {
		            	return evt.getProjectile();
		            }
		        }, 0);
			 EventValues.registerEventValue(WeaponShootEvent.class, String.class, new Getter<String, WeaponShootEvent>() {
				    @Nullable
		            @Override
		            public String get(WeaponShootEvent evt) {
		            	return evt.getWeaponTitle();
		            }
		        }, 0);
			 Skript.registerEvent("(crackshot|weapon|gun) damage", SimpleEvent.class, WeaponDamageEntityEvent.class,"(crackshot|weapon|gun) damage");
			 EventValues.registerEventValue(WeaponDamageEntityEvent.class, String.class, new Getter<String, WeaponDamageEntityEvent>() {
				    @Nullable
		            @Override
		            public String get(WeaponDamageEntityEvent evt) {
		            	return evt.getWeaponTitle();
		            }
		        }, 0);
			 EventValues.registerEventValue(WeaponDamageEntityEvent.class, Entity.class, new Getter<Entity , WeaponDamageEntityEvent>(){
				 @Nullable
		            @Override
		            public Entity get(WeaponDamageEntityEvent evt) {
		            	return evt.getVictim();
				 }
			 }, 0);
			 EventValues.registerEventValue(WeaponDamageEntityEvent.class, Player.class, new Getter<Player, WeaponDamageEntityEvent>(){
				 @Nullable
		           @Override
		            public Player get(WeaponDamageEntityEvent evt) {
		            	return evt.getPlayer();
				 }
			 }, 0);
			 EventValues.registerEventValue(WeaponDamageEntityEvent.class, String.class, new Getter<String, WeaponDamageEntityEvent>(){
				 @Nullable
		           @Override
		            public String get(WeaponDamageEntityEvent evt) {
		            	return evt.getWeaponTitle();
				 }
			 }, 0);
			 Skript.registerEvent("Scope", EvtScope.class, WeaponScopeEvent.class,"[crackshot|gun|weapon] scope [in]");
			 Skript.registerEvent("Unscope", EvtUnscope.class, WeaponScopeEvent.class,"[crackshot|gun|weapon] unscope");
			 EventValues.registerEventValue(WeaponScopeEvent.class, String.class, new Getter<String, WeaponScopeEvent>(){
				 @Nullable
		           @Override
		            public String get(WeaponScopeEvent evt) {
		            	return evt.getWeaponTitle();
				 }
			 }, 0);
			 EventValues.registerEventValue(WeaponScopeEvent.class, Player.class, new Getter<Player, WeaponScopeEvent>(){
				 @Nullable
		           @Override
		            public Player get(WeaponScopeEvent evt) {
		            	return evt.getPlayer();
				 }
			 }, 0);
			 Skript.registerEvent("(crackshot|weapon|gun) reload", SimpleEvent.class, WeaponReloadEvent.class,"(crackshot|weapon|gun) reload");
			 EventValues.registerEventValue(WeaponReloadEvent.class, Player.class, new Getter<Player, WeaponReloadEvent>(){
				 @Nullable
		           @Override
		            public Player get(WeaponReloadEvent evt) {
		            	return evt.getPlayer();
				 }
			 }, 0);
			 EventValues.registerEventValue(WeaponReloadEvent.class, String.class, new Getter<String, WeaponReloadEvent>(){
				 @Nullable
		           @Override
		            public String get(WeaponReloadEvent evt) {
		            	return evt.getWeaponTitle();
				 }
			 }, 0);
			 EventValues.registerEventValue(WeaponReloadEvent.class, Number.class, new Getter<Number, WeaponReloadEvent>(){
				 @Nullable
		           @Override
		            public Number get(WeaponReloadEvent evt) {
		            	return evt.getReloadDuration();
				 }
			 }, 0);
			 Skript.registerEvent("(crackshot|weapon|gun) reload (finish|complete)", SimpleEvent.class, WeaponReloadCompleteEvent.class,"(crackshot|weapon|gun) reload (finish|complete)");
			 EventValues.registerEventValue(WeaponReloadCompleteEvent.class, Player.class, new Getter<Player, WeaponReloadCompleteEvent>(){
				 @Nullable
		           @Override
		            public Player get(WeaponReloadCompleteEvent evt) {
		            	return evt.getPlayer();
				 }
			 }, 0);
			 EventValues.registerEventValue(WeaponReloadCompleteEvent.class, String.class, new Getter<String, WeaponReloadCompleteEvent>(){
				 @Nullable
		           @Override
		            public String get(WeaponReloadCompleteEvent evt) {
		            	return evt.getWeaponTitle();
				 }
			 }, 0);
			//Skript.registerEvent("weapon explosion", SimpleEvent.class, WeaponExplodeEvent.class,"(crackshot|weapon) (explode|explosion)");
			//Skript.registerEvent("landmine explode", SimpleEvent.class, WeaponTriggerEvent.class,"[crackshot] landmine explode");
		 }
		 // BossBar API additions
		 if (getServer().getPluginManager().isPluginEnabled("BossBarAPI")){
				getLogger().info("Making BossBar Bacon.");
				Skript.registerEffect(EffTimedBossBar.class, "display bossbar with %string% to %player% for %timespan%");
				Skript.registerEffect(EffCreateBossBar.class, "set bossbar named %string% for %player% to %number%");
				Skript.registerEffect(EffDeleteBossBar.class, "delete bossbar of %player%");
				Skript.registerExpression(ExprBaseBossBar.class, Number.class, ExpressionType.PROPERTY, "bossbar of %player%");
		 }
		 // Capes
		 if (getServer().getPluginManager().isPluginEnabled("Capes")){
				getLogger().info("Getting heroic cape bacon.");
				Skript.registerEffect(EffRemoveCape.class, "remove cape of %player%");
				Skript.registerEffect(EffWearCape.class, "make %player% wear cape %itemstack%");
		 }
		 
		 //CoreProtect
		if (getServer().getPluginManager().isPluginEnabled("CoreProtect")) {
			CoreProtectAPI CoreProtect = ((CoreProtect)getServer().getPluginManager().getPlugin("CoreProtect")).getAPI();
				if(CoreProtect.APIVersion() < 4){
					skCoreProtect = CoreProtect;
					getLogger().info("Cooking bacon for the CoreProtect loggers.");
					Skript.registerCondition(CondIsNaturalCP.class, "%block% is natural");
					Skript.registerCondition(CondIsNOTNaturalCP.class, "%block% is not natural");
				}
		}
		 
		 Skript.registerEffect(EffPlaySoundPacket.class,"play %string% to %players% [at volume %number%]");
		 Skript.registerEvent("Crafting Click", EvtCraftClick.class, InventoryClickEvent.class,"crafting click in slot %number%");
		 Skript.registerEvent("On Store", SimpleEvent.class, StoreEvent.class,"(store|chest add)");
		 Skript.registerEvent("On Unstore", SimpleEvent.class, UnstoreEvent.class,"(unstore|chest remove)");
		 new StoreListener(this);
		 EventValues.registerEventValue(StoreEvent.class, ItemStack.class, new Getter<ItemStack, StoreEvent>() {
			    @Nullable
	            @Override
	            public ItemStack get(StoreEvent evt) {
	            	return evt.getItem();
	            }
	        }, 0);
		 EventValues.registerEventValue(StoreEvent.class, Player.class, new Getter<Player, StoreEvent>() {
			    @Nullable
	            @Override
	            public Player get(StoreEvent evt) {
	            	return evt.getPlayer();
	            }
	        }, 0);
		 EventValues.registerEventValue(StoreEvent.class, Inventory.class, new Getter<Inventory, StoreEvent>() {
			    @Nullable
	            @Override
	            public Inventory get(StoreEvent evt) {
	            	return evt.getInventory();
	            }
	        }, 0);
		 EventValues.registerEventValue(UnstoreEvent.class, ItemStack.class, new Getter<ItemStack, UnstoreEvent>() {
			    @Nullable
	            @Override
	            public ItemStack get(UnstoreEvent evt) {
	            	return evt.getItem();
	            }
	        }, 0);
		 EventValues.registerEventValue(UnstoreEvent.class, Player.class, new Getter<Player, UnstoreEvent>() {
			    @Nullable
	            @Override
	            public Player get(UnstoreEvent evt) {
	            	return evt.getPlayer();
	            }
	        }, 0);
		 EventValues.registerEventValue(UnstoreEvent.class, Inventory.class, new Getter<Inventory, UnstoreEvent>() {
			    @Nullable
	            @Override
	            public Inventory get(UnstoreEvent evt) {
	            	return evt.getInventory();
	            }
	        }, 0);
		 sbManager = new IDScoreBoardManager(this);
		 //Made by njol, ported by eyesniper2 to 1.8. All credit goes to njol on this one!
		 Skript.registerEffect(EffMaxHealth.class, "set rf max[imum] h(p|ealth) of %livingentities% to %number%");
		 Skript.registerEffect(EffNameOfScore.class,"set name of sidebar (of|for) %players% to %string%");
		 Skript.registerEffect(EffSetScore.class,"set score %string% in sidebar of %player% to %number%");
		 Skript.registerEffect(EffDeleteScore.class,"delete score %string% in sidebar of %player%");
		 Skript.registerEffect(EffRemoveScoreboard.class,"(wipe|erase|delete) %player%['s] sidebar");
		 Skript.registerEffect(EffSetScoreBelowName.class,"set score %string% below %player% to %number% for %player%");
		 Skript.registerEffect(EffRemoveScoreBelowName.class,"(wipe|erase) below score[s] for %player%");
		 Skript.registerEffect(EffSetScoreTab.class,"set tab[list] score of %player% to %number% for %player%");
		 Skript.registerEffect(EffRemoveScoreTab.class,"(wipe|erase|delete) %player%['s] tab[list]");
		 Skript.registerEffect(EffSetIDBasedScore.class,"(set|create) id [based] score %string% in sidebar of %player% to %number% with id %string%");
		 Skript.registerEffect(EffEditIDScore.class, "(edit|update) score [with] id %string% to %string% and %number%");
		 Skript.registerEffect(EffDeleteIdScore.class, "(delete|remove) score [with] id %string%");
		 // Group ID Based scores
		 Skript.registerEffect(EffCreateGroupIDScore.class, "(set|create) group id [based] score %string% in sidebar for %players% to %number% with id %string%");
		 Skript.registerEffect(EffAddPlayerToGroupID.class, "add %player% to group score [with id] %string%");
		 Skript.registerEffect(EffEditGroupIDScore.class, "(edit|update) score [with][in] group [id] %string% to %string% and %number%");
		 Skript.registerEffect(EffRemovePlayerFromIDScore.class, "(delete|remove) %player% from group [id based] score %string%");
		 Skript.registerEffect(RemoveGroupIDScore.class, "(delete|remove) score[s] [with] group id %string%");
		 Skript.registerExpression(ExprScoreNameFromID.class, String.class, ExpressionType.SIMPLE, "score (name|title) (of|from) id %string%");
		 Skript.registerExpression(ExprScoreNameFromGroupID.class, String.class, ExpressionType.SIMPLE, "group score (name|title) (of|from) id %string%");
		 Skript.registerExpression(ExprScoreValueFromID.class, Number.class, ExpressionType.SIMPLE, "score (value|number) (of|from) id %string%");
		 Skript.registerExpression(ExprScoreValueFromGroupID.class, Number.class, ExpressionType.SIMPLE, "group score (value|number) (of|from) id %string%");
		 Skript.registerExpression(ExprScoreBoardTitle.class, String.class, ExpressionType.SIMPLE, "sidebar (title|name) for %player%");
		 Skript.registerCondition(CondisScoreboardSet.class, "side bar is set for %player%");
		 // Team Support
		 //teamManager = new TeamManager();
		 //Skript.registerEffect(EffSetTeamPrefix.class, "set prefix of team %string% to %string%");
		 //Skript.registerEffect(EffCreateTeam.class, "(create|make) [a] team named %string% [with %-players%]");
		 Skript.registerEffect(EffPlayResourcePackSound.class, "play (resource|[custom ]sound) [sound] pack %string% to %player% [at %-location%] [(and|with) volume %number%] [(and|with) pitch %number%]");
		 Skript.registerEffect(EffFakeFakeLightning.class, "(create|strike) (fake|ultra|no sound) fake lightning at %location%");
		 Skript.registerEffect(EffSetPlayerListName.class, "set %player% tab name to %string%");
		 Skript.registerEffect(EffSetMetaData.class, "set meta %string% for %entity% to %string%");
		 Skript.registerExpression(ExprArmorValue.class, Number.class, ExpressionType.PROPERTY, "%player%['s] armo[u]r value");
		 Skript.registerExpression(ExprNumberOfEnchants.class, Number.class, ExpressionType.SIMPLE, "number of enchant[ment]s on %itemstack%");
		 Skript.registerExpression(ExprTextToLocation.class, Location.class, ExpressionType.SIMPLE, "%string% converted to location");
		 Skript.registerExpression(ExprSpecificEnchantIndex.class, String.class, ExpressionType.SIMPLE, "info of enchant[ment] %number% (of|on) %itemstack%");
		 Skript.registerExpression(ExprAbsoluteInventoryCount.class, Number.class, ExpressionType.SIMPLE, "(absolute|complex|abs) number of %itemstack% in %player%['s] (inventory|inv)");
		 Skript.registerExpression(ExprMetaData.class, String.class, ExpressionType.SIMPLE, "meta %string% for %entity%");
		 if (Bukkit.getVersion().contains("1.8") || Bukkit.getVersion().contains("1.9") || Bukkit.getVersion().contains("1.10")){
			 getLogger().info("Enabling general 1.8/1.9/1.10 bacon!");
			 Skript.registerExpression(ExprShinyItem.class, ItemStack.class, ExpressionType.PROPERTY, "shiny %itemstacks%");
			 Skript.registerExpression(ExprNoNBT.class, ItemStack.class, ExpressionType.PROPERTY, "%itemstacks% with no nbt");
			 new ArmorStandListener(this);
			 Skript.registerEvent("armorstand damage", SimpleEvent.class, ArmorStandDamageEvent.class, "armo[u]r stand damage");
			 EventValues.registerEventValue(ArmorStandDamageEvent.class, Entity.class, new Getter<Entity, ArmorStandDamageEvent>() {
				    @Nullable
		            @Override
		            public Entity get(ArmorStandDamageEvent evt) {
		            	return evt.getArmorStand();
		            }
		        }, 0);
			 EventValues.registerEventValue(ArmorStandDamageEvent.class, Player.class, new Getter<Player, ArmorStandDamageEvent>() {
				    @Nullable
		            @Override
		            public Player get(ArmorStandDamageEvent evt) {
		            	return evt.getDamager();
		            }
		        }, 0);
		 }
		 if(Bukkit.getVersion().contains("(MC: 1.8)")){
			 getLogger().info("Getting all the special 1.8 bacon!");
			 Skript.registerEffect(EffTitleV1_8.class,"send %players% title %string% [with subtitle %-string%] [for %-timespan%] [with %-timespan% fade in and %-timespan% fade out]");
			 Skript.registerEffect(EffParticlesV1_8.class, "show %number% %string% particle[s] at %location% for %player% [offset by %number%, %number%( and|,) %number%]");
			 Skript.registerEffect(EffActionBarV1_8.class, "set action bar of %players% to %string%", "set %player%['s] action bar to %string%");
			 Skript.registerEffect(EffTabTitlesV1_8.class, "set tab header to %string% and footer to %string% for %player%");
		 }
		 if(Bukkit.getVersion().contains("(MC: 1.8.3)")){
			 getLogger().info("Getting the extra special 1.8.3 bacon!");
			 Skript.registerEffect(EffTitleV1_8_3.class,"send %players% title %string% [with subtitle %-string%] [for %-timespan%] [with %-timespan% fade in and %-timespan% fade out]");
			 Skript.registerEffect(EffParticlesV1_8_3.class, "show %number% %string% particle[s] at %location% for %player% [offset by %number%, %number%( and|,) %number%]");
			 Skript.registerEffect(EffActionBarV1_8_3.class, "set action bar of %players% to %string%", "set %player%['s] action bar to %string%");
			 Skript.registerEffect(EffTabTitlesV1_8_3.class, "set tab header to %string% and footer to %string% for %player%");
		 }
		 if(Bukkit.getVersion().contains("(MC: 1.8.4)") || Bukkit.getVersion().contains("(MC: 1.8.5)") || Bukkit.getVersion().contains("(MC: 1.8.6)") || Bukkit.getVersion().contains("(MC: 1.8.7)") || Bukkit.getVersion().contains("(MC: 1.8.8)")){
			 getLogger().info("Getting the extra special 1.8.4 - 1.8.8 bacon!");
			 Skript.registerEffect(EffTitleV1_8_4.class,"send %players% title %string% [with subtitle %-string%] [for %-timespan%] [with %-timespan% fade in and %-timespan% fade out]");
			 Skript.registerEffect(EffParticlesV1_8_4.class, "show %number% %string% particle[s] at %location% for %player% [offset by %number%, %number%( and|,) %number%]");
			 Skript.registerEffect(EffActionBarV1_8_4.class, "set action bar of %players% to %string%", "set %player%['s] action bar to %string%");
			 Skript.registerEffect(EffTabTitlesV1_8_4.class, "set tab header to %string% and footer to %string% for %player%");
		 }
		 if(Bukkit.getVersion().contains("1.9") || Bukkit.getVersion().contains("1.10")){
			 getLogger().info("Getting the general 1.9/1.10 bacon!");
			 //New bossbar content
			 bossbarManager = new BossBarManager();
			 Skript.registerEffect(EffCreateModernBossBar.class, "create (bossbar|boss bar) title[d] %string% and id %string% for %players% [with (value|progress) %number%] [with colors %-bossbarcolor%] [with style %-bossbarstyle%] [with flags %-bossbarflag%]");
			 Skript.registerEffect(EffDeleteModernBossBar.class, "(remove|destroy) bossbar %string%");
			 Skript.registerEffect(EffRemovePlayerFromBossBar.class, "remove %players% [from] bossbar %string%");
			 Skript.registerEffect(EffSetBossBar.class, new String[] {"(add|set) bossbar %string% for %player% ", "(add|give) %players% [to] bossbar %string%"});
			 Skript.registerEffect(EffChangeBossBarValue.class, "(set|edit) bossbar %string% (value|progress) to %number%");
			 Skript.registerEffect(EffChangeBossBarColor.class, "(set|edit) bossbar %string% colo[u]r to %bossbarcolor%");
			 Skript.registerEffect(EffChangeBossBarTitle.class, "(set|edit) bossbar %string% (title|name) to %string%");
			 Skript.registerEffect(EffChangeBossBarStyle.class, "(set|edit) bossbar %string% style to %bossbarstyle%");
			 Skript.registerEffect(EffBossBarAddFlag.class, "(add|set) [a] [the] flag %bossbarflag% to [the] bossbar %string%");
			 Skript.registerEffect(EffBossBarRemoveFlag.class, "(remove|delete) [a] [the] flag %bossbarflag% [to] [from] [the] bossbar %string%");
			 Skript.registerEffect(EffBossBarShow.class, "(show|display|unhide) bossbar %string%");
			 Skript.registerEffect(EffBossBarHide.class, "hide bossbar %string%");
			 Skript.registerExpression(ExprBossBarTitle.class, String.class, ExpressionType.SIMPLE, "(title|name) of bossbar %string%");
			 Skript.registerExpression(ExprBossBarValue.class, Number.class, ExpressionType.SIMPLE, "(value|progress) of bossbar %string%");
			 //Glowing API
			 Skript.registerEffect(EffMakePlayerGlow.class, "make %player% glow");
			 Skript.registerEffect(EffUnglowPlayer.class, "make %player% (unglow|stop glowing)");
			 Skript.registerExpression(ExprPlayerGlowing.class, Boolean.class, ExpressionType.SIMPLE, "%player% glowing");
			 //1.9.2 Team stuff
			 //Skript.registerEffect(Eff1_9MessageOnDeathRule.class, "(show|display) death message[s] %teamoptionstatus% for team %string%");
			 //Skript.registerEffect(Eff1_9NameTagVisibility.class, "(show|display) (name tags|nametags) %teamoptionstatus% for team %string%");
			 //Skript.registerEffect(Eff1_9TeamCollisionRule.class, "(set|define) team collision [rule] as %teamoptionstatus% for team %string%");
		 }
		 if(Bukkit.getVersion().contains("(MC: 1.9)") || Bukkit.getVersion().contains("(MC: 1.9.1)")|| Bukkit.getVersion().contains("(MC: 1.9.2)")|| Bukkit.getVersion().contains("(MC: 1.9.3)")){
			 getLogger().info("Getting the extra special 1.9 - 1.9.3 bacon!");
			 Skript.registerEffect(EffTitleV1_9.class,"send %players% title %string% [with subtitle %-string%] [for %-timespan%] [with %-timespan% fade in and %-timespan% fade out]");
			 Skript.registerEffect(EffParticlesV1_9.class, "show %number% %string% particle[s] at %location% for %player% [offset by %number%, %number%( and|,) %number%]");
			 Skript.registerEffect(EffActionBarV1_9.class, "set action bar of %players% to %string%", "set %player%['s] action bar to %string%");
			 Skript.registerEffect(EffTabTitlesV1_9.class, "set tab header to %string% and footer to %string% for %player%");
		 }
		 if(Bukkit.getVersion().contains("(MC: 1.9.4)")){
			 getLogger().info("Getting the extra special 1.9.4 bacon!");
			 Skript.registerEffect(EffTitleV1_9_4.class,"send %players% title %string% [with subtitle %-string%] [for %-timespan%] [with %-timespan% fade in and %-timespan% fade out]");
			 Skript.registerEffect(EffParticlesV1_9_4.class, "show %number% %string% particle[s] at %location% for %player% [offset by %number%, %number%( and|,) %number%]");
			 Skript.registerEffect(EffActionBarV1_9_4.class, "set action bar of %players% to %string%", "set %player%['s] action bar to %string%");
			 Skript.registerEffect(EffTabTitlesV1_9_4.class, "set tab header to %string% and footer to %string% for %player%");
		 }
		 if(Bukkit.getVersion().contains("(MC: 1.10)")){
			 getLogger().info("Getting the extra special 1.10 bacon!");
			 Skript.registerEffect(EffTitleV1_10.class,"send %players% title %string% [with subtitle %-string%] [for %-timespan%] [with %-timespan% fade in and %-timespan% fade out]");
			 Skript.registerEffect(EffParticlesV1_10.class, "show %number% %string% particle[s] at %location% for %player% [offset by %number%, %number%( and|,) %number%]");
			 Skript.registerEffect(EffActionBarV1_10.class, "set action bar of %players% to %string%", "set %player%['s] action bar to %string%");
			 Skript.registerEffect(EffTabTitlesV1_10.class, "set tab header to %string% and footer to %string% for %player%");
		 }
		 enableFastScoreboards = this.getConfig().getBoolean("enableFastScoreBoards");
		 if(this.getConfig().getBoolean("UpdateAlerts", false)){
			 Updater updater = new Updater(this, 88677, this.getFile(), Updater.UpdateType.NO_DOWNLOAD, true);
			 if(updater.getResult() == UpdateResult.UPDATE_AVAILABLE){
				 getServer().getConsoleSender().sendMessage("[" + ChatColor.DARK_AQUA + "skRayFall" + ChatColor.RESET + "] " + ChatColor.RED + "An update for skRayFall is available!");
			 }
		 }
		 getLogger().info("Bacon is ready!");
	 }
	 
	 @Override
	    public void onDisable(){
		 getLogger().info("Bacon has been eaten. Make some more soon!");
		 HoloManager.dumpHoloMap();
		 effLibManager.dumpData();
		 sbManager.dumpData();
		 if(bossbarManager != null){
			 bossbarManager.dumpData();
		 }
	 }
	 
	 @EventHandler
	 public void onJoin(PlayerJoinEvent evt){
		 if (enableFastScoreboards == true){
			 Player player = evt.getPlayer();
			 ScoreboardManager manager = Bukkit.getScoreboardManager();
			 Scoreboard board = manager.getNewScoreboard();
			 player.setScoreboard(board);
		 }
	 }
	 
	private void regesterElements() {
		Classes.registerClass(new ClassInfo<ParticleEffect>(
				ParticleEffect.class, "effectlibparticle")
				.parser(new Parser<ParticleEffect>() {
					@Override
					public String getVariableNamePattern() {
						return ".+";
					}

					@Override
					@Nullable
					public ParticleEffect parse(String s, ParseContext cont) {
						try {
							return ParticleEffect.valueOf(s.replace(" ", "_")
									.trim().toUpperCase());
						} catch (IllegalArgumentException e) {
							return null;
						}
					}

					@Override
					public String toString(ParticleEffect eff, int i) {
						return eff.getName().replace("_", " ").toLowerCase();
					}

					@Override
					public String toVariableNameString(ParticleEffect eff) {
						return eff.getName().replace("_", " ").toLowerCase();
					}
				}));
		
	}
	
	private void regesterNon1_9_2TeamElements(){
		Classes.registerClass(new ClassInfo<NameTagVisibility>(
				NameTagVisibility.class, "nametagvisibility")
				.parser(new Parser<NameTagVisibility>() {
					@Override
					public String getVariableNamePattern() {
						return ".+";
					}

					@Override
					@Nullable
					public NameTagVisibility parse(String s, ParseContext cont) {
						try {
							return NameTagVisibility.valueOf(s
									.replace(" ", "_").trim().toUpperCase());
						} catch (IllegalArgumentException e) {
							return null;
						}
					}

					@Override
					public String toString(NameTagVisibility name, int i) {
						return name.name().replace("_", " ").toLowerCase();
					}

					@Override
					public String toVariableNameString(NameTagVisibility name) {
						return name.name().replace("_", " ").toLowerCase();
					}
				}));
	}
	

	private void regesterV1_9Elements() {
		Classes.registerClass(new ClassInfo<skRayFallBarColor>(skRayFallBarColor.class,
				"bossbarcolor").parser(new Parser<skRayFallBarColor>() {
			@Override
			public String getVariableNamePattern() {
				return ".+";
			}

			@Override
			@Nullable
			public skRayFallBarColor parse(String s, ParseContext cont) {
				try {
					return skRayFallBarColor.valueOf(s.replace(" ", "_").trim()
							.toUpperCase());
				} catch (IllegalArgumentException e) {
					return null;
				}
			}

			@Override
			public String toString(skRayFallBarColor eff, int i) {
				return eff.name().replace("_", " ").toLowerCase();
			}

			@Override
			public String toVariableNameString(skRayFallBarColor eff) {
				return eff.name().replace("_", " ").toLowerCase();
			}
		}));
		Classes.registerClass(new ClassInfo<skRayFallBarFlag>(skRayFallBarFlag.class,
				"bossbarflag").parser(new Parser<skRayFallBarFlag>() {
			@Override
			public String getVariableNamePattern() {
				return ".+";
			}

			@Override
			@Nullable
			public skRayFallBarFlag parse(String s, ParseContext cont) {
				try {
					return skRayFallBarFlag.valueOf(s.replace(" ", "_").trim()
							.toUpperCase());
				} catch (IllegalArgumentException e) {
					return null;
				}
			}

			@Override
			public String toString(skRayFallBarFlag eff, int i) {
				return eff.name().replace("_", " ").toLowerCase();
			}

			@Override
			public String toVariableNameString(skRayFallBarFlag eff) {
				return eff.name().replace("_", " ").toLowerCase();
			}
		}));
		Classes.registerClass(new ClassInfo<skRayFallBarStyle>(skRayFallBarStyle.class,
				"bossbarstyle").parser(new Parser<skRayFallBarStyle>() {
			@Override
			public String getVariableNamePattern() {
				return ".+";
			}

			@Override
			@Nullable
			public skRayFallBarStyle parse(String s, ParseContext cont) {
				try {
					return skRayFallBarStyle.valueOf(s.replace(" ", "_").trim()
							.toUpperCase());
				} catch (IllegalArgumentException e) {
					return null;
				}
			}

			@Override
			public String toString(skRayFallBarStyle eff, int i) {
				return eff.name().replace("_", " ").toLowerCase();
			}

			@Override
			public String toVariableNameString(skRayFallBarStyle eff) {
				return eff.name().replace("_", " ").toLowerCase();
			}
		}));
		
	}
	private void regesterV1_9_2Elements() {
		
		//TODO: Test 1.9.2 Team stuff
		Classes.registerClass(new ClassInfo<OptionStatus>(OptionStatus.class,
				"teamoptionstatus").parser(new Parser<OptionStatus>() {
			@Override
			public String getVariableNamePattern() {
				return ".+";
			}

			@Override
			@Nullable
			public OptionStatus parse(String s, ParseContext cont) {
				try {
					return OptionStatus.valueOf(s.replace(" ", "_").trim()
							.toUpperCase());
				} catch (IllegalArgumentException e) {
					return null;
				}
			}

			@Override
			public String toString(OptionStatus eff, int i) {
				return eff.name().replace("_", " ").toLowerCase();
			}

			@Override
			public String toVariableNameString(OptionStatus eff) {
				return eff.name().replace("_", " ").toLowerCase();
			}
		}));
	}

}

