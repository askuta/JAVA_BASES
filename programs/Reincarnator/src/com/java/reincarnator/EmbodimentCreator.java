package com.java.reincarnator;

import com.java.reincarnator.Identity.Gender;

public class EmbodimentCreator {

	public static Embodiment createEmbodiment(Identity identity) {

		String body = createBody(identity);
		String clothe = "embodiment/clothe/Clothe.png";
		String eyes = createEyes(identity);
		String hair = createHair(identity);
		String hand = createHand(identity);
		String head = createHead(identity);
		String mouth = createMouth(identity);
		String nose = createNose(identity);

		return new Embodiment(body, clothe, eyes, hair, hand, head, mouth, nose);
	}

	private static String createBody(Identity identity) {
		String s = String.valueOf(identity.getCountryStat().getraceNegIndex() + 1);
		return ("embodiment/body/Body" + s + ".png");
	}

	private static String createEyes(Identity identity) {

		String g;
		identity.getGender();
		if (identity.getGender() == Gender.MALE) {
			g = "m";
		} else {
			g = "f";
		}

		String t = EyesPicker.pickEyes((EyesRacePicker.pickEyesRace(identity.getCountryStat().getraceNegIndex(),
				identity.getCountryStat().getraceMonIndex())));
		return ("embodiment/eyes/Eyes" + g + t + ".png");
	}

	private static String createHair(Identity identity) {

		String g;
		identity.getGender();
		if (identity.getGender() == Gender.MALE) {
			g = "m";
		} else {
			g = "f";
		}

		String t = HairPicker.pickHair((HairRacePicker.pickHairRace(identity.getCountryStat().getraceNegIndex(),
				identity.getCountryStat().getraceMonIndex())));
		return ("embodiment/hair/Hair" + g + t + ".png");
	}

	private static String createMouth(Identity identity) {

		String t = MouthRacePicker.pickMouthRace(identity.getCountryStat().getraceNegIndex());
		return ("embodiment/mouth/Mouth" + t + ".png");
	}

	private static String createNose(Identity identity) {

		String t = (NoseRacePicker.pickNoseRace(identity.getCountryStat().getraceNegIndex(),
				identity.getCountryStat().getraceMonIndex()));
		return ("embodiment/nose/Nose" + t + ".png");
	}

	private static String createHand(Identity identity) {
		String s = String.valueOf(identity.getCountryStat().getraceNegIndex() + 1);
		return ("embodiment/hand/Hand" + s + ".png");
	}

	private static String createHead(Identity identity) {
		String s = String.valueOf(identity.getCountryStat().getraceNegIndex() + 1);
		return ("embodiment/head/Head" + s + ".png");
	}
}
