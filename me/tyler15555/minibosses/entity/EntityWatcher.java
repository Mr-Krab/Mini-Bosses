package me.tyler15555.minibosses.entity;

import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.util.IMiniboss;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityWatcher extends EntityMob implements IMiniboss {

	public EntityWatcher(World par1World) {
		super(par1World);
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(125D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.followRange).setBaseValue(20.5D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(4.5D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(.40D);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		super.attackEntityAsMob(entity);
		if(this.rand.nextInt(100) == 1 && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			
			player.addPotionEffect(new PotionEffect(Potion.blindness.id, 600));
			player.addPotionEffect(new PotionEffect(Potion.confusion.id, 600));
			return true;
		}
		return true;
	}
	
	@Override
	public Item getDropItem() {
		return MBItems.occulus_item;
	}

	@Override
	public String getBanlistName() {
		return "Watcher";
	}

	@Override
	public ItemStack getPossibleLoot() {
		return new ItemStack(MBItems.medusaEye);
	}

	@Override
	public int getDropChance() {
		return 60;
	}

}
