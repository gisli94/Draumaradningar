package DreamDiary;

public class Interpretation {

	private Dream dream;
	private String interpretation;

	public Interpretation(){}

	/*
	public Interpretation(Dream dream) {
		this.dream = dream;
		this.interpretation = "";
	}
	*/

	public Dream getDream() {
		return dream;
	}

	public void setDream(Dream dream) {
		this.dream = dream;
		this.interpretation = interpret(dream);
	}

	public String getInterpretation() {
		return interpretation;
	}

	public void setInterpretation(String interpretation) {
		this.interpretation = interpretation;
	}

	private String interpret(Dream dream) {
		String inter = (new StringBuilder(dream.getContent()).reverse().toString());
		return inter;
	}

}
