package gali;

public class Question extends Answer {

	private String question;
	private Answer ifYes;
	private Answer ifNo;

	public Question(String question, Answer ifYes, Answer ifNo) {
		this.question = question;
		this.ifYes = ifYes;
		this.ifNo = ifNo;
	}

	@Override
	public Answer play() {
		
		if (askb(question)) {
			ifYes = ifYes.play();
		} else {
			ifNo = ifNo.play();
		}
		return this;
	}
}
