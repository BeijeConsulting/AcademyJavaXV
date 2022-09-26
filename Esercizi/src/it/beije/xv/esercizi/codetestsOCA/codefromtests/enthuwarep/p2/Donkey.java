package it.beije.xv.esercizi.codetestsOCA.lambdas.oca.codefromtests.enthuwarep.p2;

import codefromtests.enthuwarep.p1.Movable;

public class Donkey implements Movable {
	int location = 200;
	
	@Override
	public void move(int by) {
		// TODO Auto-generated method stub
		location = location+by;
	}

	@Override
	public void moveBack(int by) {
		// TODO Auto-generated method stub
		location = location-by;
	}

}
