package com.java.reincarnator;

import java.util.Random;

public class CreateEmbodiment {

	private static Random random = new Random();

	public static Embodiment createEmbodiment(Identity identity) {

		String body = createBody(identity);
		String clothe = "embClothe/Clothe.png";
		String eyes = "embEyes/EyesmBlue.png";
		String hair = "embHair/HairmStraightBlonde.png";
		String hand = createHand(identity);
		String head = createHead(identity);
		String mouth = "embMouth/MouthNarrow.png";
		String nose = "embNose/NoseCausoid.png";

		return new Embodiment(body, clothe, eyes, hair, hand, head, mouth, nose);
	}

	private static String createBody(Identity identity) {
		String s = String.valueOf(identity.getCountryStat().getraceNegIndex());
		return ("embBody/Body" + s + ".png");
	}

	private static String createHand(Identity identity) {
		String s = String.valueOf(identity.getCountryStat().getraceNegIndex());
		return ("embHand/Hand" + s + ".png");
	}

	private static String createHead(Identity identity) {
		String s = String.valueOf(identity.getCountryStat().getraceNegIndex());
		return ("embHead/Head" + s + ".png");
	}
}
