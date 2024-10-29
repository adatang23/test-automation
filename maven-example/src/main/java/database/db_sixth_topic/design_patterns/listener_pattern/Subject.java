package database.db_sixth_topic.design_patterns.listener_pattern;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Listener> listeners = new ArrayList<Listener>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state, Integer id) {
        this.state = state;
        notifyAllListeners(id);
    }

    public void attach(Listener listener) {
        listeners.add(listener);
    }

    public void notifyAllListeners(Integer id) {
        for (Listener listener: listeners) {
            listener.update(id);
        }
    }
}
