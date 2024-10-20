package database.db_fourth_topic.parsers.parser;
import database.db_fourth_topic.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class JSONParser {
    public Customer parseJSONCustomer(String jsonPathCustomer) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(jsonPathCustomer), Customer.class);
    }

    public Branch parseJSONBranches(String jsonPathBranch) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(jsonPathBranch), Branch.class);
    }
}
