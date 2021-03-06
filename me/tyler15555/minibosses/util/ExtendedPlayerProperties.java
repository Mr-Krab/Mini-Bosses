package me.tyler15555.minibosses.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayerProperties implements IExtendedEntityProperties {

	private int currentAbilitySaveCount;
	private boolean powersOn;
	public static String PROP_NAME = "MB-Occulus-Use-Properties";
	
	public ExtendedPlayerProperties() {
	
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		compound.setInteger("abilityUses", currentAbilitySaveCount);
		compound.setBoolean("powersOn", powersOn);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		currentAbilitySaveCount = compound.getInteger("abilityUses");
		powersOn = compound.getBoolean("powersOn");
	}

	@Override
	public void init(Entity entity, World world) {

	}
	
	public void decreaseAbilityUsage() {
		--currentAbilitySaveCount;
	}
	
	public int getAbilityUsageAmount() {
		return currentAbilitySaveCount;
	}
	
	public void setAbilityUsage(int amt) {
		currentAbilitySaveCount = amt;
	}
	
	public boolean getPowersEnabled() {
		return this.powersOn;
	}
	
	public void togglePowers() {
		this.powersOn = !this.powersOn;
	}

}
