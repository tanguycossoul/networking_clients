import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private ArrayList<State> states;
    private ArrayList<String> state_names;

    public static final String education_filename = "data\\Education.csv";
    public static final int    education_file_start = 5; // with US: 5, without US: 6

    public static final String employment_filename = "data\\Unemployment.csv";
    public static final int    employment_file_start = 8;

    public static final String realestate_filename = "data\\RealEstateSaleHistory.csv";
    public static final int    realestate_file_start = 1;

    public DataManager() {
        states = new ArrayList<>();
        state_names = new ArrayList<>();
    }

    // Safe add:
    // - if already exists, don't add and return existing
    // - if doesn't already exists, add and return it
    public State safeAddState(String name) {
        if (name.equals("")) { return null; }

        name = name.toUpperCase();

        if ( state_names.contains( name ) ) {
            return searchState( name );
        }
        else {
            State state = new State( name );
            states.add( state );
            state_names.add( name );
            return state;
        }
    }

    private State searchState(String name) {
        for (State s : states) {
            if (s.getName().equals( name )) {
                return s;
            }
        }
        return null; // oops
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public State getState(String name) {
        for (State state: states) {
            if (state.getName().equals(name)) {
                return state;
            }
        }
        return null;
    }
}
