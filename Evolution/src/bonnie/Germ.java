package bonnie;

import java.util.Random;

public class Germ {
	private boolean isAlive;
	private boolean isHibernating;
	
	private float consumption;
	private float fortification;
	private float power;
	private float species;
	
	public Germ(){
		this.isAlive = false;
	}
	
	public Germ(float consumption, float fortification, float power, float species){
		this.isAlive = true;
		this.isHibernating = false;
		
		this.consumption = consumption;
		this.fortification = fortification;
		this.power = power;
		this.species = species;
	}
	
	public Germ(Germ germ, boolean toEvolve){
		this.isAlive = true;
		this.isHibernating = false;
		
		if(toEvolve){
			this.consumption = Util.chanceOf(0.1f)? Util.evolve(germ.getConsumption(), 0f): germ.getConsumption();
			this.fortification = Util.chanceOf(0.1f)? Util.evolve(germ.getFortification(), 0f): germ.getFortification();
			this.power = Util.chanceOf(0.01f)? Util.evolve(germ.getPower(), 0.05f): germ.getPower();
			this.species = Util.chanceOf(0.005f)? Util.evolve(germ.getSpecies(), 0.05f): germ.getSpecies();
		}
		else{
			this.consumption = germ.getConsumption();
			this.fortification = germ.getFortification();
			this.power = germ.getPower();
			this.species = germ.getSpecies();
		}
	}
	
	public boolean isInfecting(float energy, Germ germ){
		if(!isAlive)
			return false;
		if(!germ.isAlive() && Util.chanceOf(0.7f))
			return true;
		if(energy < power || isHibernating || this.isSimilar(germ))
			return false;
		if(Util.chanceOf(0.3f))
			return true;
		return false;
	}
	
	public boolean isSimilar(Germ g){
		if(!g.isAlive())
			return false;
		if(this.species == g.getSpecies())
			return true;
		return false;
	}
	
	public boolean isHibernating(float energy){
		if(energy > 5)
			isHibernating = false;
		else if (energy < 2)
			isHibernating = true;
		return isHibernating;
	}
	
	public float fortification(float energy, float defence){
		if(defence >= fortification || isHibernating)
			return 0;
		if(energy < 0.15f - defence)//---------------------------------------------------------------------------------
			return Util.fit(energy, 0.15f);
		return Util.fit(fortification - defence, 0.15f);
	}
	
	public boolean isAlive(){
		return this.isAlive;
	}
	
	public boolean isHibernating(){
		return isHibernating;
	}
	
	public float getConsumption(){
		return this.consumption;
	}
	
	public float getFortification(){
		return this.fortification;
	}
	
	public float getPower(){
		return this.power;
	}
	
	public float getSpecies(){
		return this.species;
	}
}
