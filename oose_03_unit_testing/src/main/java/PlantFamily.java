public class PlantFamily extends Monster
{
	protected static final int BASIC_MULTIPLIER=5;
	protected static final int SPECIAL_MULTIPLIER=10;
	
	protected int charges;
	protected int maxCharges;

	public PlantFamily(String name, int monsterLevel, int health, int maxCharges)
	{
		super(name, monsterLevel, health);
		charges = maxCharges;
		this.maxCharges = maxCharges;
	}

	public int getMaxCharges(){
		return maxCharges;
	}

	public int getCharges(){
		return charges;
	}

	public void levelUp()
	{
		super.levelUp();
		maxCharges++;
		System.out.println("They now have " + maxCharges + " charges of their special attack!");
	}

	public void takeDamage(Damage damage)
	{
		switch (damage.getType())
		{
		case PLANT:
			super.takeDamage(new Damage(damage.getType(),(int)(damage.getAmount()*RESIST_DAMAGE)));
			break;
		case FIRE:
			super.takeDamage(new Damage(damage.getType(),(int)(damage.getAmount()*VULNERABLE_DAMAGE)));
			break;
		default:
			super.takeDamage(damage);
		}
	}
	
	public Damage specialAttack()
	{
		if (charges > 0)
		{
			System.out.println(name + " shoots vines");
			charges--;
			return new Damage(DamageType.PLANT, monsterLevel * SPECIAL_MULTIPLIER);
		}
		else
		{
			System.out.println(name + " tries to summon the power to attack but can't do it!");
			return new Damage(DamageType.PLANT, 0);
		}
	}
	
	public Damage basicAttack()
	{
		return new Damage(DamageType.NORMAL,monsterLevel*BASIC_MULTIPLIER);
	}
	
	public void rest()
	{
		charges = maxCharges;
		super.rest();
	}
	
	public String makeMonsterDescription()
	{
		return super.makeMonsterDescription() + ", a plant monster with " + charges + "/" + maxCharges + " charges and "
				+ currentHealth + "/" + maxHealth + " health";
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}
}
