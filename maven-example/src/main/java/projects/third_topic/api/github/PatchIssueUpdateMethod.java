package projects.third_topic.api.github;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class PatchIssueUpdateMethod extends AbstractApiMethodV2 {
    public PatchIssueUpdateMethod() {
        super("api.github/update_issue/rq.json", "api.github/update_issue/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        request.header("Authorization", "Bearer token");
    }
}


