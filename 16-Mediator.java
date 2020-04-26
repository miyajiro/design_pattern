import java.util.*;

public class Saito implements LoveMediator {
    private Map<String, Colleague> colleagueMap = new HashMap<String, Colleague>();

    public void addColleague(Colleague colleague) {
        colleagueMap.put(colleague.getName(), colleague);
    }

    public int consultation(Colleague colleagueInLove, Colleague secretLover) {
        int possibility = 0;
        /* さまざまな状況を考慮して、possibility を導出 */
        // ・・・・
        return possibility;
    }
}

public class Nitta implements Colleague {
    private String name = "新田";
    private int tension;
    private Colleague secretLover = null;
    private LoveMediator mediator = new Saito();

    public String getName() {
        return name;
    }

    public void setSecretLover(Colleague colleague) {
        this.secretLover = colleague;
    }

    public void needsAdvice() {
        this.tension = mediator.consultation(this, secretLover);
    }
}