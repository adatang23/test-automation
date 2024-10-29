package database.db_sixth_topic.design_patterns.decorator_pattern;

public class InformationDisplayDecorator implements InformationDisplay {
    protected InformationDisplay informationDisplay;

    public InformationDisplayDecorator(InformationDisplay informationDisplay) {
        this.informationDisplay = informationDisplay;
    }

    @Override
    public void display(Integer id) {
        this.informationDisplay.display(id);
    }
}
