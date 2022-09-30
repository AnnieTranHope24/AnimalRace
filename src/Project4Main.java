
public class Project4Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//step1: create the race
		Race race = new Race();
		race.createRace(20, 10);
		// race.createRaceDemo(); //for testing
		// System.out.println(race.racetrackasString());
		// int turnNum = 0;//turnNum

//step2: if there is no winner yet, continue another turn		
		while (!race.isFinished) {
			// turnNum++; //for testing
//			System.out.println();
//			System.out.println("Turn " + turnNum);//print the number of turn			
			race.advanceOneTurn();

		}

//step3: after the race is finished (there are winners), print out each racer and its position
		for (int racerIndex = 0; racerIndex < race.getNumberOfRacers(); racerIndex++) {
			int tempIndex = racerIndex + 1;
			String racetrack = race.racetrackasString();
			String finalraceTrack = "";
			for (int i = 0; i < racetrack.length(); i++) {
				String temp = racetrack.substring(i, i + 1);
				if (i == race.getRacerPosition(racerIndex)) {
					temp = "<" + temp + ">";
				}
				temp = " " + temp + " ";
				finalraceTrack += temp;

			}
			System.out.println(race.getRacerName(racerIndex) + " " + tempIndex + ": ");
			System.out.println(finalraceTrack);
		}
		// step4: print out the winners
		System.out.println("Winner(s): ");
		for (int i = 0; i < race.getNumberOfRacers(); i++) {
			if (race.getRacerIsWinner(i)) {
				int temp = i+1;
				System.out.println(race.getRacerName(i) + " ID: " + temp);
			}
		}

	}
}
