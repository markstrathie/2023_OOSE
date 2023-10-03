public class Trainer
{
	private static final int MAX_MONSTER_CAPACITY =6;
	private static final int SPECIAL_ATTACK=1;
	private static final int BASIC_ATTACK=0;
	
	private Monster[] trainerMonsters=new Monster[MAX_MONSTER_CAPACITY];
	private int numberOfMonsters=0;

	public Trainer(Monster starterMonster)
	{
		trainerMonsters[0] = starterMonster;
		numberOfMonsters++;
	}

	public void fight(int trainerMonsterNumber, Monster enemyMonster)
	{
		int turn=1;
		System.out.println("NEW BATTLE");
		while(trainerMonsters[trainerMonsterNumber].isConscious()&&enemyMonster.isConscious())
		{
			System.out.println("Turn:"+turn);
			attack(trainerMonsters[trainerMonsterNumber],enemyMonster,turn%2);
			if(enemyMonster.isConscious())
			{
				attack(enemyMonster,trainerMonsters[trainerMonsterNumber],turn%2);
			}
			turn++;
		}
		endFight(trainerMonsterNumber, enemyMonster);
	}
	
	private void endFight(int trainerMonsterNumber, Monster enemyMonster) 
	{	
		String looserName=trainerMonsters[trainerMonsterNumber].getName();
		if(trainerMonsters[trainerMonsterNumber].isConscious())
		{
			trainerMonsters[trainerMonsterNumber].levelUp();
			looserName=enemyMonster.getName();
		}
		System.out.println(looserName+ " is unconscious and can't fight!");
	}

	private void attack(Monster attacker, Monster defender, int attackType) {
		switch (attackType) {
		case SPECIAL_ATTACK:
			defender.takeDamage(attacker.specialAttack());
			break;
		case BASIC_ATTACK:
			defender.takeDamage(attacker.basicAttack());
			break;
		}
	}

	public void restTeam()
	{
		for (int i=0;i<numberOfMonsters;i++)
		{
			trainerMonsters[i].rest();
		}
	}
	
	public void addMonster(Monster newMonster)
	{
		if(numberOfMonsters<MAX_MONSTER_CAPACITY)
		{
			trainerMonsters[numberOfMonsters]=newMonster;
			numberOfMonsters++;
			System.out.println("Welcome to the team:"+trainerMonsters[numberOfMonsters-1].makeMonsterDescription());
		}
		else
		{
			System.out.println("You have reached capacity for new monsters.");
		}
	}
	
	public void printRoster()
	{
		for (int i = 0; i < numberOfMonsters; i++)
		{
			if (trainerMonsters[i].isConscious())
			{
				System.out.println((i)+"-  " + trainerMonsters[i].makeMonsterDescription());
			}
			else
			{
				System.out.println("This monster is not conscious so can't fight:");
				System.out.println((i) +"-  "+ trainerMonsters[i].makeMonsterDescription());
			}
		}
	}
		
	public Monster[] getMonsters()
	{
		return trainerMonsters;
	}

	public int getNumberOfMonsters()
	{
		return numberOfMonsters;
	}
	
	public static void main(String[] args)
	{
		Monster scorchitile =new Scorchitile("Flamey",1,35,15);
		Monster dragonfish =new Dragonfish("Splashy",1,30);
		Monster seedatops = new Seedatops("Vinesy",1,50,2);
		Trainer trainer = new Trainer (dragonfish);
		trainer.fight(0, seedatops);
		trainer.printRoster();
		seedatops.rest();
		trainer.fight(0, seedatops);
		trainer.printRoster();
		trainer.addMonster(scorchitile);
		trainer.printRoster();
		trainer.restTeam();
		trainer.printRoster();
		seedatops.levelUp();
		seedatops.levelUp();
		seedatops.rest();
		trainer.fight(1, seedatops);
		trainer.fight(1, seedatops);
		trainer.fight(0, seedatops);
		seedatops.rest();
		trainer.fight(0, seedatops);
		trainer.fight(0, seedatops);
		trainer.addMonster(seedatops);
		trainer.printRoster();
		trainer.addMonster(seedatops);
		trainer.addMonster(seedatops);
		trainer.addMonster(seedatops);
		trainer.printRoster();
		trainer.restTeam();
		trainer.printRoster();
		trainer.fight(0, seedatops);
		trainer.printRoster();
	}
}