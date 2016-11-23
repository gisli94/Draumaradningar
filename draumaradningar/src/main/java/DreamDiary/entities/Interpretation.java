package DreamDiary.entities;

public class Interpretation {

	private String content;

	public Interpretation(){
		this.content = "";
	}
	public Interpretation(String content){
		this.content = content;
	}

	/*
	public Interpretation(Dream dream) {
		this.dream = dream;
		this.interpretation = "";
	}
	*/

	public String getContent(){
		return content;
	}

	public void setContent(String new_content){
		this.content = new_content;
	}

	/*
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
	*/

	public String toString(){
		return "" + content;
	}

	public static void interpret(Dream dream) {
		// String intr = Henrýfall(dream);
		interpreter Greinir = new interpreter();
		String intr = Greinir.analyzeDream(dream.getContent());
		dream.setInterpretation(new Interpretation(intr));
	}

}
