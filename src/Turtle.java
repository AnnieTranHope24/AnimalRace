
public class Turtle extends Creature {
	public static final int MAXSPEED = 2;
	public Turtle(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Retrieves the max speed of the selected racer.
	 * @return int max speed
	 */
	public int getMaxSpeed() {
		// TODO Auto-generated method stub
		return MAXSPEED;
	}

	@Override
	/**
	 * Method that allows the animals to move along the track
	 */
	public void move() {
		// TODO Auto-generated method stub
		
		int neededPoints;
		int temp = getPosition() + 1;
		for(int i=temp; i<getRaceTrack().length; i++) {
			
			if(i!= temp && getRaceTrack()[i]==getRaceTrack()[i-1]) {
				neededPoints = 0;
				
			}else {					//just starts a new turn or the terrain changes or reaches the finish line
				if(getRaceTrack()[i] == 'O') {
				neededPoints = 0;
				
				}
				else if(getRaceTrack()[i] == '|'){
					setWinner(true);
					setPosition(i);
					break;
				}
				else {
				neededPoints = 1;
			}
			
			if(getMovementPoints()>= neededPoints) {
				setMovementPoints(getMovementPoints()-neededPoints);
				setPosition(i);
			}else {
				break;
			}
		}
		
	}
	

	}}
