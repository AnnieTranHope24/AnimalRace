
public class Ostrich extends Creature {
	public static final int MAXSPEED = 5;

	public Ostrich(String name) {
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

		for (int i = temp; i < getRaceTrack().length; i++) {

			if (i != temp && getRaceTrack()[i] == getRaceTrack()[i - 1]) {
				neededPoints = 0;

			}
			// start a new turn with an open plain or a desert.
			else if (i == temp && (getRaceTrack()[i] == '.' || getRaceTrack()[i] == '~')) {
				setMovementPoints(getMovementPoints() + 1);
				neededPoints = 0;
			}

			else {// starts a new turn with other terrains than an open plain or a desert or the
					// terrain changes.
					// or reaches the finish line
				if (getRaceTrack()[i] == '#') {
					neededPoints = 3;

				} else if (getRaceTrack()[i] == 'O') {
					neededPoints = 2;
				} else if (getRaceTrack()[i] == '|') {
					setWinner(true);
					setPosition(i);
					break;
				} else {
					neededPoints = 1;
				}

				if (getMovementPoints() >= neededPoints) {
					setMovementPoints(getMovementPoints() - neededPoints);
					setPosition(i);
				} else {
					break;
				}
			}

		}
	}
}
