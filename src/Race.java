import java.util.Random;

public class Race implements RaceInterface {
	private char[] racetrack;
	private Creature[] candidates;
	//Please add a few more...this is currently only 10 names long
	private String[] animalNames = {
			"Ravioli",
			"Tintin",
			"Chichi",
			"Kiki",
			"Bean",
			"Yoshi",
			"Bowser",
			"Toad",
			"Chad",
			"Spice",
			"Mimi",
			"Micky",
			"Tom",
			"Jerry",
			"Pikachu",
			"Bin",
			"Puka",
			"Martin",
			"Tuni"
		};
	
	public boolean isFinished;
	
	/**
	 * Method to set original start of race to false
	 */
	public Race() {
		isFinished = false;
	}

	@Override
	/**
	 * Sets up character array racetrack
	 * @return char array named racetrack
	 */
	public char[] getRacetrack() {
		// System.out.println(racetrack.toString());
		return racetrack;
	}

	@Override
	/**
	 * Retrieves name of the racer based on index
	 * @param Int racer index value
	 * @return String racer name
	 */
	public String getRacerName(int racerIndex) {
//		// TODO Auto-generated method stub

		return candidates[racerIndex].getName();
	}

	@Override
	/**
	 * Retrieve position of a racer based on their index value
	 * @param Int racer index value
	 * @return integer racer position in race
	 */
	public int getRacerPosition(int racerIndex) {
		// TODO Auto-generated method stub
		return candidates[racerIndex].getPosition();
	}

	@Override
	/**
	 * Retrieves race winners
	 * @param Int racer index value
	 * @return boolean value of whether a racer won or not
	 */
	public boolean getRacerIsWinner(int racerIndex) {
		// TODO Auto-generated method stub
		return candidates[racerIndex].isWinner();
	}

	@Override
	/**
	 * Method to create the race using the appropriate characters and creates the racers. 
	 * @param int length, and int number of racers
	 */
	public void createRace(int length, int numRacers) {
		// TODO Auto-generated method stub
		char[] racetrackPieces = new char[4];
		racetrack = new char[length];
		racetrackPieces[0] = '#';
		racetrackPieces[1] = 'O';
		racetrackPieces[2] = '.';
		racetrackPieces[3] = '~';

		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			int randomIndexSwap = rand.nextInt(racetrackPieces.length);
			char temp = racetrackPieces[randomIndexSwap];
			racetrack[i] = temp;
			// System.out.println(racetrack);
		}
		racetrack[length - 1] = '|';

		candidates = new Creature[numRacers];
//		candidates[0] = new Ostrich("Bowser");
//		candidates[0].setRaceTrack(racetrack);
//		candidates[1] = new Monkey("Yoshi");
//		candidates[1].setRaceTrack(racetrack);
//		candidates[2] = new Turtle("Tintin");
//		candidates[2].setRaceTrack(racetrack);

		for (int i = 0; i < numRacers; i++) { 
			int randInt = rand.nextInt(3);
			int randNames = rand.nextInt(10);
			if (randInt == 0) {
				
				candidates[i] = new Ostrich("(Ostrich) " + animalNames[randNames]);
				candidates[i].setRaceTrack(racetrack);
			}
			if (randInt == 1) {
				candidates[i] = new Monkey("(Monkey) " + animalNames[randNames]);
				candidates[i].setRaceTrack(racetrack);
			}
			if (randInt == 2) {
				candidates[i] = new Turtle("(Turtle) " + animalNames[randNames]);
				candidates[i].setRaceTrack(racetrack);
			}
		}
	}

	@Override
	/**
	 * Method for animal racers to advance one turn
	 */
	public void advanceOneTurn() {
		// TODO Auto-generated method stub
		for (Creature candidate : candidates) {
			int points = new Random().nextInt(candidate.getMaxSpeed()) + 1;
			//int points = 2;  //for testing
			candidate.setMovementPoints(points);
			//System.out.println(candidate.getName() + " MovementPoints of this turn: "+ candidate.getMovementPoints()); //testing
			candidate.move();
			if (candidate.isWinner()) {
				isFinished = true;
			}
			//System.out.println("The last position of this turn: " + candidate.getPosition());
			//System.out.println("The remaining movementPoints after this turn: "+ candidate.getMovementPoints());//testing
			
		}

	}

	/**
	 * Check if the race is finished
	 * @return isFinished - if race is completed
	 */
	public boolean isRaceFinished() {
		return isFinished;
	}

	// I create this to test my part
	public void createRaceDemo() {
		candidates = new Creature[5];
		candidates[0] = new Ostrich("(Ostrich) Ravioli");
		candidates[1] = new Monkey("(Monkey) Tintin");
		candidates[2] = new Ostrich("(Ostrich) Chichi");
		candidates[3] = new Monkey("(Monkey) Ben");
		candidates[4] = new Turtle("(Turtle) Tur");
		racetrack = new char[20];
		racetrack[0] = '~';
		racetrack[1] = '~';
		racetrack[2] = '#';
		racetrack[3] = '.';
		racetrack[4] = '#';
		racetrack[5] = 'O';
		racetrack[6] = '.';
		racetrack[7] = '.';
		racetrack[8] = 'O';
		racetrack[9] = '|';
		for (Creature candidate : candidates) {
			candidate.setRaceTrack(racetrack);
		}
	}

//	public Creature[] getRacers() {
//		return candidates;
//	}
	
	/**
	 * Returns the racetrack
	 * @return String tack
	 */
	public String racetrackasString() {
		String track = new String(racetrack);
		return track;
	}
	/**
	 * Method to retrieve number of racers
	 * @return number of racers
	 */
	public int getNumberOfRacers() {
		return candidates.length;
	}

}
