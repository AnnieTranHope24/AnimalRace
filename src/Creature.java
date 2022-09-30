import java.util.Random;

public abstract class Creature {

	private String name;
	private char[] raceTrack;
	private int position;
	private boolean flag;
	private int movementPoints;

	/**
	 * Constructor of the class
	 * 
	 * @param name The name of the creature
	 */
	public Creature(String name) {
		this.name = name;
		position = -1; // when the creature has not entered the track
		setWinner(false);
	}

	/**
	 * Mutator of the field name
	 * 
	 * @param newName the name of the creature
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Accessor of the field name
	 * 
	 * @return String name
	 */
	public String getName() {

		return name;
	}

	/**
	 * Accessor of the max speed of the creature
	 * 
	 * @return max speed of racers
	 */
	public abstract int getMaxSpeed();

//	public abstract boolean isWinner();
//	public abstract char[] getRaceTrack();
//	public abstract int getPosition();
	/**
	 * How the creature moves. Each type of creatures will move in different way.
	 */
	abstract void move();

	/**
	 * Retrieves the racetrack
	 * 
	 * @return the raceTrack
	 */
	public char[] getRaceTrack() {
		return raceTrack;
	}

	/**
	 * Sets the racetrack as a character array
	 * 
	 * @param raceTrack the raceTrack array
	 */
	public void setRaceTrack(char[] raceTrack) {
		this.raceTrack = raceTrack;
	}

	/**
	 * Retrieves position of racer
	 * 
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Sets position of racer
	 * 
	 * @param position integer position
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * Decides whether or not to put a flag on winner
	 * 
	 * @return the flag
	 */
	public boolean isWinner() {
		return flag;
	}

	/**
	 * Sets flag on winner(s)
	 * 
	 * @param flag the flag to set
	 */
	public void setWinner(boolean flag) {
		this.flag = flag;
	}

	/**
	 * Retrieves movement points of animals
	 * 
	 * @return the movementPoints
	 */
	public int getMovementPoints() {
		return movementPoints;
	}

	/**
	 * Sets movement points for racers along track
	 * 
	 * @param points the points the creature receives
	 */
	public void setMovementPoints(int points) {
		movementPoints = points;
	}
}
