
public class Scorchitile extends FireFamily
{
	public Scorchitile(String name, int monsterLevel, int maxHealth, int maxFireMana)
	{
		super(name, monsterLevel, maxHealth, maxFireMana);
		monsterBreed="Scorchitile";
	}

	public Damage basicAttack()
	{
		System.out.println(name + "makes a scratching attack!");
		return new Damage(DamageType.NORMAL,monsterLevel*BASE_ATTACK_DAMAGE*2);
	}
}
