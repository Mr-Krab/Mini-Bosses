package me.tyler15555.minibosses.entity;

import me.tyler15555.minibosses.item.MBItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityInfernoGolem extends EntityIronGolem {

	public EntityInfernoGolem(World p_i1694_1_) {
		super(p_i1694_1_);
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	@Override
	public Item getDropItem() {
		return MBItems.ingotInferno;
	}
	
	@Override
	protected void attackEntity(Entity entity, float par2) {
		super.attackEntity(entity, par2);
		if(this.rand.nextInt(19) == 1) {
			entity.setFire(8);
		}
	}

}
