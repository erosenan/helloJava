package bonnie;

public class Node {
	private int x;
	private int y;
	private Grid g;
	private float energy;
	private Germ germ;
	private int invaders;
	private Germ[] invation;
	private float defence;
	
	public Node(int x, int y, Grid g){
		this.x = x;
		this.y = y;
		this.g = g;
		this.energy = 10;
		this.germ = new Germ();
		//this.consumption = 1.5f;
		this.defence = 0;
		invaders = 0;
		invation = new Germ[4];
		//System.out.println("node (" + x + ", " + y + ") set");
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public float getEnergy(){
		return energy;
	}
		
	public void nextTurn(){
		this.energy += 1;//= this.energy >= 9 ? 10 : this.energy + 1;
		if(germ.isAlive()){
			if(germ.isHibernating(energy))
				energy -= defence / 5;
			else{
				energy -= germ.getConsumption();
				energy -= defence / 3;
			}
				
		}
		if(energy < 0){
			energy = 0;
			germ = new Germ();
			defence = 0;
			Util.clearArray(invation);
//			for(int i = 0; i < 4; i ++)
//				invation[i] = null;
			invaders = 0;
			return;
		}
		if(invaders > 0)
			manageInvation();
		float toFortify = germ.fortification(energy, defence);
		defence += toFortify;
		energy -= toFortify;
		if(energy > 10)
			energy = 10;
		
		//defence = 0.3f;
	}
	
	private void manageInvation(){
		float energyUsed = 0;
		float attackAdvantage = 1.5f;
		if(germ.isHibernating()){
			defence /= 2;
		}
		while(invaders > 1 && defence > 0){
			if((invation[invaders - 1].getPower() - energyUsed) * invaders * attackAdvantage < defence){
				defence -= attackAdvantage * (invation[invaders - 1].getPower() - energyUsed) * invaders;
				energyUsed = invation[invaders - 1].getPower();
				invaders--;
			}
			else{
				energyUsed += defence / attackAdvantage / invaders;
				defence = 0;
			}
		}
		if(defence == 0){
			if(invaders == 1){
				this.germ = new Germ(invation[0], true);
				defence = 0;//Util.fit(germ.getPower() - energyUsed, 0.1f);
				invaders = 0;
				Util.clearArray(invation);
				return;
			}
			if(invation[0].getPower() == invation[1].getPower()){
				this.germ = new Germ();
				defence = 0;
			}
			else{
				this.germ = new Germ(invation[0], true);
				defence = 0;//Util.fit(invation[0].getPower() - energyUsed, 0.1f);
			}
		}
		else if((invation[0].getPower() - energyUsed) * attackAdvantage > defence){
			this.germ = new Germ(invation[0], true);
			defence = 0;//Util.fit(invation[0].getPower() - energyUsed, 0.1f);
		}
		else
			defence -= (invation[0].getPower() - energyUsed) * attackAdvantage;
		invaders = 0;
		Util.clearArray(invation);
//		for(int i = 0; i < 4; i ++)
//			invation[i] = null;
	}
	
	public void spread(){
		if(!germ.isAlive())
			return;
		checkInfectionTo(this.x + 1, this.y);
		checkInfectionTo(this.x - 1, this.y);
		checkInfectionTo(this.x, this.y + 1);
		checkInfectionTo(this.x, this.y - 1);
	}
	
	private void checkInfectionTo(int x, int y){
		if(!this.germ.isSimilar(g.getValue(x, y).getGerm()))
			if(this.germ.isInfecting(energy - germ.getConsumption(), g.getValue(x, y).getGerm())){
				energy -= germ.getPower();
				if(energy > 10)
					energy = 10;
				g.getValue(x, y).infect(this.germ);
			}
	}
	
	public void infect(Germ germ){
		if(invaders > 3){
			RuntimeException a = new RuntimeException();
		}
		int i = 0;
		Germ g1, g2;
		while(this.invation[i] != null && this.invation[i].getPower() > germ.getPower())
			i++;
		g1 = this.invation[i];
		this.invation[i] = new Germ(germ, false);
		i++;
		while(i < this.invaders){
			g2 = g1;
			g1 = this.invation[i];
			this.invation[i] = g2;
			i++;
		}
		if(i < 4)
			this.invation[i] = g1;
		invaders++;
		/*for(int j = 0; j < invaders; j ++)
			System.out.print(invation[j].getPower() + " ");*/
	}
	
	public void setGerm(Germ germ){
		this.germ = new Germ(germ, false);
		this.defence = 0.3f;//---------------------------------------------------------------
	}
	
	public boolean isAlive(){
		return germ.isAlive();
	}
	
	public Germ getGerm(){
		return germ;
	}
	
	public float getDefence(){
		return defence;
	}
}
